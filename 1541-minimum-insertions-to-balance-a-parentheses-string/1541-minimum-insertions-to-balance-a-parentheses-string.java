class Solution {
public int minInsertions(String s) {
int ans = 0;
int open = 0;


    for (char ch : s.toCharArray()) {
        if (ch == '(') {
            open += 2;

            if (open % 2 != 0) {
                ans++;
                open--;
            }
        } else {
            open--;

            if (open < 0) {
                ans++;
                open = 1;
            }
        }
    }

    return ans + open;
}

}
