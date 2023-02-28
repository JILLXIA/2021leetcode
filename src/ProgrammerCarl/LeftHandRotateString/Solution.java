package ProgrammerCarl.LeftHandRotateString;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        // rotate part of the string
        // then rotate the whole part of the string
        char[] arr = s.toCharArray();
        reverse(arr, 0,n-1);
        reverse(arr, n, arr.length-1);
        reverse(arr, 0, arr.length-1);
        return String.valueOf(arr);
    }

    public void reverse(char[] arr, int start, int end){
        int left = start;
        int right = end;

        while(left < right){
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
