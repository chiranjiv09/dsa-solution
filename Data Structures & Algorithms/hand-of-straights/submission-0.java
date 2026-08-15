class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        // Total cards must be divisible by groupSize
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Frequency of every card
        Map<Integer, Integer> count = new HashMap<>();

        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        // Process smallest cards first
        Arrays.sort(hand);

        for (int card : hand) {

            // This card was already used
            if (count.get(card) == 0) {
                continue;
            }

            // Start a group from this card
            for (int i = 0; i < groupSize; i++) {

                int current = card + i;

                // Required card doesn't exist
                if (count.getOrDefault(current, 0) == 0) {
                    return false;
                }

                // Use this card
                count.put(current, count.get(current) - 1);
            }
        }

        return true;
    }
}