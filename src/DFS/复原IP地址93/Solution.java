package DFS.复原IP地址93;

/**
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，
 * 返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255
 * 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是
 * 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效 IP 地址。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 用回溯解决字符串的分割问题
 * 需要剪枝的地方比较多
 * 1、一开始，字符串的长度小于 4 或者大于 12 ，
 * 一定不能拼凑出合法的 ip 地址
 * （这一点可以一般化到中间结点的判断中，以产生剪枝行为）；
 *
 * 2、每一个结点可以选择截取的方法只有 3 种：
 * 截 1 位、截 2 位、截 3 位，因此每一个结点可以生长出的分支最多只有 3 条分支；
 *
 * 根据截取出来的字符串判断是否是合理的 ip 段，这里写法比较多，可以先截取，再转换成 int ，再判断。我采用的做法是先转成 int，是合法的 ip 段数值以后，再截取。
 *
 * 3、由于 ip 段最多就 4 个段，因此这棵三叉树最多 4 层，这个条件作为递归终止条件之一；
 *
 * 4、每一个结点表示了求解这个问题的不同阶段，需要的状态变量有：
 *
 * splitTimes：已经分割出多少个 ip 段；
 * begin：截取 ip 段的起始位置；
 * path：记录从根结点到叶子结点的一个路径（回溯算法常规变量，是一个栈）；
 * res：记录结果集的变量，常规变量。
 */
public class Solution {
    List<String> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    StringBuffer paths = new StringBuffer();
    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4||s.length()>12){
            return result;
        }
        int splittime = 0;
        dfs(s,0,splittime);
        return result;
    }

    public void dfs(String s, int index,int splittime){
//        System.out.println(String.join(".", path));
        if(index==s.length()){
            if(path.size()==4) {
                result.add(String.join(".", path));
            }
            return;
        }

        // 看到剩下的不够了，就退出（剪枝），len - begin 表示剩余的还未分割的字符串的位数
        if (s.length() - index < (4 - splittime)
                || s.length() - index > 3 * (4 - splittime)) {
            return;
        }

        for(int i = index;i<=3+index;i++){//剪枝，一段不超过3个字符
            if(i>s.length()){
                return;
            }
            if(!isCorrect(s.substring(index,i))){
                continue;
            }
            path.add(s.substring(index,i));
            dfs(s,i,splittime+1);
            path.remove(path.size()-1);
        }
    }

    public boolean isCorrect(String s){
        if(s.equals("")){
            return false;
        }
        if((s.length()>1 && s.charAt(0)=='0')||s.length()==0){
            return false;
        }
        int num = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)<='9' && s.charAt(i)>='0'){
                num = num*10+s.charAt(i)-'0';
            }else{
                return false;
            }
        }
        if(num>255 || num<0){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        s.restoreIpAddresses("25525511135");
    }
}
