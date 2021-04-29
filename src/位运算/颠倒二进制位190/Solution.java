package 位运算.颠倒二进制位190;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。
 * 在这种情况下，输入和输出都将被指定为有符号整数类型，
 * 并且不应影响您的实现，因为无论整数是有符号的还是无符号的，
 * 其内部的二进制表示形式都是相同的。
 *
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。
 * 因此，在上面的示例 2中，输入表示有符号整数 -3，
 * 输出表示有符号整数 -1073741825。
 */

/**
 * int转换为二进制字符串
 *
 * Integer.toBinaryString(5);
 *
 * 二进制字符串转换为int
 *
 * int i=Integer.parseUnsignedInt("10010",2);
 *
 * parseUnsignedInt方法中第二个参数为基数(radix)，2即二进制。
 * 这个方法最多可解析32位的二进制数，即无符号int型
 *
 * parseInt也类似，但只能解析31位二进制数，即有符号int型
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return Integer.reverse(n);//用API里面的方法
    }

}
