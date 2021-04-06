package 数组.翻转图像832;

/**
 * 实际上可以一步到位，找到规律
 *
 * 具体而言，考虑以下四种情况。
 *
 * 情况一：image[i][left]=0,image[i][right]=0。对第 i 行进行水平翻转之后，image[i][left]=0,image[i][right]=0。进行反转之后，image[i][left]=1,image[i][right]=1。
 *
 * 情况二：image[i][left]=1,image[i][right]=1。对第 i 行进行水平翻转之后，image[i][left]=1,image[i][right]=1。进行反转之后，image[i][left]=0,image[i][right]=0。
 *
 * 情况三：image[i][left]=0,image[i][right]=1。对第 i 行进行水平翻转之后，image[i][left]=1,image[i][right]=0。进行反转之后，image[i][left]=0,image[i][right]=1。
 *
 * 情况四：image[i][left]=1,image[i][right]=0。对第 i 行进行水平翻转之后，image[i][left]=0,image[i][right]=1。进行反转之后，image[i][left]=1,image[i][right]=0。
 *
 * 情况一和情况二是 image[i][left]=image[i][right] 的情况。在进行水平翻转和反转之后，image[i][left] 和 image[i][right] 的元素值都发生了改变，即元素值被反转。
 *
 * 情况三和情况四是 image[i][left]=image[i][right] 的情况。在进行水平翻转和反转之后，image[i][left] 和 image[i][right] 的元素值都发生了两次改变，恢复原状。
 *
 * 异或：计算对象值不同为1，值相同为0
 */
public class Solution1 {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i = 0;i< image.length;i++){
            int left = 0;
            int right = image[0].length-1;

            while(left<=right){
                if(left==right){
                    image[i][left] ^= 1;
                }
                else if(image[i][left]==image[i][right]){
                    image[i][left] ^=1;
                    image[i][right] ^=1;
                }

                left++;
                right--;
            }
        }
        return image;
    }
}
