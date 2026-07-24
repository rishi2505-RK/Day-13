class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0, right = Long.MAX_VALUE;

        long maxWorker = 0;
        for (int w : workerTimes) {
            maxWorker = Math.max(maxWorker, w);
        }
        long n = mountainHeight;
        right = maxWorker * n * (n + 1) / 2;

        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canFinish(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canFinish(long time, int height, int[] workerTimes) {
        long reduced = 0;

        for (int w : workerTimes) {

            long lo = 0, hi = height;

            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;
                long needed = (long) w * mid * (mid + 1) / 2;

                if (needed <= time) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            reduced += hi;

            if (reduced >= height) {
                return true;
            }
        }

        return false;
    }
}