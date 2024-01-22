package Grind75.AddBinary67;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class Solution {
    public String addBinary(String a, String b) {
        int carrier = 0;
        int digita = 0;
        int digitb = 0;
        StringBuilder sb = new StringBuilder();
        String reversea = new StringBuilder(a).reverse().toString();
        String reverseb = new StringBuilder(b).reverse().toString();
        for(int i = 0; i < Math.max(reversea.length(), reverseb.length()); i++) {
            if(i >= reversea.length()) {
                digita = 0;
                digitb = reverseb.charAt(i) - '0';
            } else if(i >= reverseb.length()) {
                digitb = 0;
                digita = reversea.charAt(i) - '0';
            } else {
                digita = reversea.charAt(i) - '0';
                digitb = reverseb.charAt(i) - '0';
            }

            int resultDig = digita ^ digitb ^ carrier;
            carrier = (digita + digitb + carrier) / 2;
            sb.append(resultDig);
        }
        if(carrier == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("1010", "1011"));
    }
}
