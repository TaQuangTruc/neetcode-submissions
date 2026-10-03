class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();

        char[] arr = s.toCharArray();
        int left = 0;
        int res = 0;

        for (int right = 0; right < arr.length; right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
