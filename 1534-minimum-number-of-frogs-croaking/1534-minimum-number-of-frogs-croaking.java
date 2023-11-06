class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        int idx = 0;
        int ans = 0;
        int curr = 0;
        int max_frogs = n/5;
        if (n%5!=0) return -1;
        int[] freq = new int[] {0, 0, 0, 0, 0};
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);

        while (idx<croakOfFrogs.length()) {
            Character ch = croakOfFrogs.charAt(idx);
            if (!map.containsKey(ch)) return -1;
            if (ch=='k') {
                curr--;
            } else {
                freq[map.get(ch)]++;
                if (ch=='c'){
                    curr++;
                    ans = Math.max(ans, curr);
                } else {
                    freq[map.get(ch)-1]--;
                    if (freq[map.get(ch)-1]==-1) return -1;
                }
            }
            idx++;
        }
        if (freq[0]>0) return -1;
        return ans;
    }
}