class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int low = Integer.MAX_VALUE;
        int high = 0;

        for (int choco : sweetness) {
            low = Math.min(low, choco);
            high += choco;
        }

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canDivide(sweetness, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canDivide(int[] sweetness, int mid, int k) {
        int chunks = 0;
        int sum = 0;

        for (int choco : sweetness) {
            sum += choco;
            if (sum >= mid) {
                chunks++;
                sum = 0;
                if (chunks == k + 1) {
                    return true;
                }
            }
        }

        return false;
    }
}