class Solution {
    public int getLucky(String s, int k) {
        int j, i, c;
        int sum1 = 0;
        int sum2 = 0;
        int n, num, r, rem;
        int[] temp = new int[100];
        char[] str = new char[26];
        for (i = 0; i < 26; i++) {
            str[i] = (char) ('a' + i);
        }

        for (j = 0; j < s.length(); j++) {
            for (i = 0; i < 26; i++) {
                if (s.charAt(j) == str[i]) {
                    c = 0;
                    temp[c] = i + 1;
                    // System.out.println(temp[c]);
                    c++;
                }
            }
            for (i = 0; i < temp.length; i++) {
                num = temp[i];
                while (num > 0) {
                    rem = num % 10;
                    num = num / 10;
                    sum1 = sum1 + rem;
                }
            }
        }
        System.out.println("Transformation 1 :" + sum1);

        for (i = 1; i < k; i++) {
            n = sum1;
            while (n > 0) {
                r = n % 10;
                n = n / 10;
                sum2 = sum2 + r;
            }
            System.out.format("Transformation %d = %d", i + 1, sum2);
            sum1 = sum2;
            sum2 = 0;
            System.out.println();
        }
    return sum1;
    }
}