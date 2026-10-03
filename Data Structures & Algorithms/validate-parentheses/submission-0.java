class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        Map<Character, Character> mp = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );

        for (char c : s.toCharArray()) {
            if (mp.containsKey(c)) {
                if (st.isEmpty() || st.peek() != mp.get(c)) {
                    return false;
                }

                st.pop();
            } else {
                st.push(c);
            }
        }

        return st.isEmpty();
    }
}