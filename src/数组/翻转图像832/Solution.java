package 数组.翻转图像832;

/**
 * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 *
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
 */
public class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i = 0;i<image.length;i++){
            for(int j = 0;j<=(image[0].length-1)/2;j++){
                int temp = image[i][image[0].length-1-j];
                image[i][image[0].length-1-j] = image[i][j];
                image[i][j] = temp;

                image[i][j] = 1-image[i][j];
                if(j!=image[0].length-1-j){
                    image[i][image[0].length-1-j] = 1-image[i][image[0].length-1-j];
                }
            }
        }
        return image;
    }
}
