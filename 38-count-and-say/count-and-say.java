class Solution {
    public String countAndSay(int n) {
      StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n; i++) {
            ans = helper(ans);
        }
        return ans.toString();
    }

    public StringBuilder helper(StringBuilder prev) {
        StringBuilder ans = new StringBuilder();
        int freq = 1;
        for (int i = 0; i < prev.length(); i++) {
            if (i == prev.length() - 1 || prev.charAt(i) != prev.charAt(i + 1)) {
                ans.append(freq);
                ans.append(prev.charAt(i));
                freq = 1;
            } else {
                freq++;
            }
        }
        System.gc();
        return ans;
    }
}