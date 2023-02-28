package ProgrammerCarl.ReverseWordsInAString151;

/**
 * we don't want to use the extra space
 */
public class Solution1 {
    // reverse the whole string
    // find the word and reverse
    // trim the space
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverseWhole(arr, 0,arr.length - 1);
        reverseWord(arr);
        int bound = trimSpace(arr);
        return String.valueOf(arr).substring(0, bound);
    }

    public void reverseWhole(char[] arr, int start, int end){
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

    public void reverseWord(char[] arr){
        int left = 0;
        int right = 0;
        while(right < arr.length){
            if(arr[right]==' '){
                left++;
                right++;
            } else {
                while(right < arr.length && arr[right]!= ' '){
                    right++;
                }
                reverseWhole(arr, left, right-1);
                left = right;
            }
        }
    }

    public int trimSpace(char[] arr){
        int left = 0;
        int right = 0;
        while(right < arr.length){
            while(right < arr.length && arr[right]==' '){
                right++;
            }
            while(right < arr.length && arr[right] != ' '){
                arr[left++] = arr[right++];
            }
            // trim the space suffix
            while(right < arr.length && arr[right]==' '){
                right++;
            }
            if(right != arr.length){
                arr[left++] = ' ';
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String s = "  hello world  ";
        char[] c = s.toCharArray();
        System.out.println(solution.reverseWords(s));
        // System.out.println(c);
    }
}
