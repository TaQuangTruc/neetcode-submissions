class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();

        int left = 0;
        int maxF = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // Add ký tự bên phải vào window
            count.put(
                rightChar,
                count.getOrDefault(rightChar, 0) + 1
            );

            // Frequency lớn nhất từng đạt được
            maxF = Math.max(maxF, count.get(rightChar));

            // Nếu số ký tự cần replace > k
            // => window invalid => shrink từ bên trái
            while ((right - left + 1) - maxF > k) {
                char leftChar = s.charAt(left);

                count.put(
                    leftChar,
                    count.get(leftChar) - 1
                );

                left++;
            }

            res = Math.max(
                res,
                right - left + 1
            );
        }

        return res;
    }
}