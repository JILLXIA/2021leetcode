package ProgrammerCarl.SubstituteSpace05;

public class Solution {
    public String replaceSpace(String s) {
        // expand the capacity of s
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == ' '){
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
