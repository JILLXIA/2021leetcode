package 字符串.移除无效的括号1249;

public class Solution1 {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
                result.append(s.charAt(i));
            }else if(s.charAt(i)==')'){
                count--;
                if(count>=0){
                    result.append(s.charAt(i));
                }else{
                    count = 0;
                }
            }else{
                result.append(s.charAt(i));
            }
        }
        count = 0;

        int length = result.length();
        StringBuilder newResult = new StringBuilder();
        for(int i = length-1;i>=0;i--){
            if(result.charAt(i)==')'){
                count++;
                newResult.append(result.charAt(i));
            }else if(result.charAt(i)=='('){
                count--;
                if(count>=0){
                    newResult.append(result.charAt(i));
                }else{
                    count = 0;
                }
            }else{
                newResult.append(result.charAt(i));
            }
        }

        return newResult.reverse().toString();
    }

    public static void main(String[] args){
        Solution1 s = new Solution1();
        System.out.println(s.minRemoveToMakeValid("))(("));
    }
}
