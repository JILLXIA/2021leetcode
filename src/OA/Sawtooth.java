package OA;

public class Sawtooth {
    long solution(int[] arr) {
        int left = 0;
        int right = 1;
        int direction = 0;
        long result = 0;
        while(right < arr.length){
            if(arr[right] > arr[right-1]){
                direction += 1;
            } else if(arr[right-1] > arr[right]){
                direction += -1;
            }
            if(Math.abs(direction) > 1 || arr[right-1] == arr[right]){
                long length = right - left;
                result += length * (length - 1) /2;
                left = arr[right-1] == arr[right] ? right : right - 1;
                if(arr[right-1] == arr[right]){
                    right++;
                }
                direction = 0;
                continue;
            }
            right++;
        }
        result += (long)(right - left) * ((right - left) - 1) /2;
        return result;
    }

    public static void main(String[] args) {
        Sawtooth s = new Sawtooth();
        System.out.println(s.solution(new int[]{10,10,10}));
    }
}
