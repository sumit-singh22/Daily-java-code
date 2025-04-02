class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxTriplet = 0;

        int[] maxPrefix = new int[n]; // Stores the maximum value from index 0 to i-1
        maxPrefix[0] = nums[0];

        // Compute prefix max array
        for (int i = 1; i < n; i++) {
            maxPrefix[i] = Math.max(maxPrefix[i - 1], nums[i]);
        }

        // Iterate through j and k
        for (int j = 1; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                long currValue = ((long) maxPrefix[j - 1] - nums[j]) * nums[k];
                maxTriplet = Math.max(maxTriplet, currValue);
            }
        }

        return maxTriplet;
    }
}
