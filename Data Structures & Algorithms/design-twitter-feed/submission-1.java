class Tweet {
    int tweetId;
    int time;

    Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}

class User {
    int userId;
    Set<Integer> following = new HashSet<>();
    List<Tweet> tweets = new ArrayList<>();

    User(int userId) {
        this.userId = userId;
        following.add(userId);
    }
}

class Twitter {

    private int time = 0;
    private Map<Integer, User> users = new HashMap<>();

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {

        users.putIfAbsent(userId, new User(userId));

        users.get(userId)
             .tweets
             .add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {

        users.putIfAbsent(userId, new User(userId));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                b[0],
                a[0]
            )
        );

        User user = users.get(userId);

        // Add latest tweet of every followee
        for (int followeeId : user.following) {

            User followee = users.get(followeeId);

            if (followee != null && !followee.tweets.isEmpty()) {

                int index = followee.tweets.size() - 1;

                Tweet tweet = followee.tweets.get(index);

                pq.offer(new int[]{
                    tweet.time,
                    followeeId,
                    index
                });
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {

            int[] current = pq.poll();

            int followeeId = current[1];
            int index = current[2];

            Tweet tweet =
                users.get(followeeId)
                     .tweets
                     .get(index);

            result.add(tweet.tweetId);

            // Move to previous tweet of same user
            if (index > 0) {

                Tweet previous =
                    users.get(followeeId)
                         .tweets
                         .get(index - 1);

                pq.offer(new int[]{
                    previous.time,
                    followeeId,
                    index - 1
                });
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));

        users.get(followerId)
             .following
             .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!users.containsKey(followerId)) {
            return;
        }

        // User must always follow himself
        if (followerId == followeeId) {
            return;
        }

        users.get(followerId)
             .following
             .remove(followeeId);
    }
}