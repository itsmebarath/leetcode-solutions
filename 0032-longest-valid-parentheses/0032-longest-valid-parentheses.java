class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                // Store index of '('
                stack.push(i);

            } else {
                // Try to match ')'
                stack.pop();

                if (stack.isEmpty()) {
                    // No matching '('
                    // Current ')' becomes the new base
                    stack.push(i);

                } else {
                    // Valid parentheses found
                    int length = i - stack.peek();

                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
}