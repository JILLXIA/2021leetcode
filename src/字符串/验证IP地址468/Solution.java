package 字符串.验证IP地址468;

import java.util.Locale;

/**
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或IPv6 地址。
 *
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 * IPv4地址由十进制数和点来表示，每个地址包含 4 个十进制数，
 * 其范围为0 -255，用(".")分割。比如，172.16.254.1；
 *
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址172.16.254.01 是不合法的。
 *
 * IPv6地址由 8 组 16 进制的数字来表示，每组表示16 比特。
 * 这些组数字通过 (":")分割。比如,
 * 2001:0db8:85a3:0000:0000:8a2e:0370:7334
 * 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，
 * 字母可以使用大写，也可以是小写。所以，
 * 2001:db8:85a3:0:0:8A2E:0370:7334
 * 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 *
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。
 * 比如，2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 *
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。
 * 比如，02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 */
public class Solution {
    public String validIPAddress(String IP) {
        String[] temp1 = IP.split("\\.",-1);
        String[] temp2 = IP.split(":",-1);

        if(temp1.length==4 && checkIP4(temp1)){
            return "IPv4";
        }else if(temp2.length==8 && checkIP6(temp2)){
            return "IPv6";
        }else{
            return "Neither";
        }
    }

    public static boolean checkIP4(String[] s){
        for(int i = 0;i<s.length;i++){
            if(s[i].equals("")){
                return false;
            }
            if(s[i].charAt(0)=='0' && s[i].length()!=1){
                return false;
            }
            char[] ctmp = s[i].toCharArray();
            int num = 0;
            for(int j = 0;j<ctmp.length;j++){
                if(ctmp[j]<='9' && ctmp[j]>='0'){
                    num = num*10+ctmp[j]-'0';
                }else{
                    return false;
                }
            }
            if(num<0 || num>255){
                return false;
            }
        }
        return true;
    }

    public static boolean checkIP6(String[] s){
        for(int i = 0;i<s.length;i++){
            if(s[i].equals("")){
                return false;
            }
            char[] ctmp = s[i].toLowerCase().toCharArray();
            if(ctmp.length>4){
                return false;
            }

            for(int j = 0;j<ctmp.length;j++){
                if((ctmp[j]>='0'&&ctmp[j]<='9')
                || (ctmp[j]>='a'&& ctmp[j]<='f')){
                    continue;
                }else{
                    return false;
                }
            }

        }
        return true;
    }

}
