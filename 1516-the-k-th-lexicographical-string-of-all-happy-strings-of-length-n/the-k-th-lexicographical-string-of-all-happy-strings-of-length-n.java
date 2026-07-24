class Solution {
    public String getHappyString(int n, int k) {

        int total = 3 * (1 << (n - 1));
        
        if (k > total) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        char[] chars = {'a', 'b', 'c'};

        for (int i = 0; i < n; i++) {
            for (char ch : chars) {
                if (i > 0 && ans.charAt(i - 1) == ch) {
                    continue;
                }

                int count = 1 << (n - i - 1);

                if (k > count) {
                    k -= count;
                } else {
                    ans.append(ch);
                    break;
                }
            }
        }

        return ans.toString();
    }
}