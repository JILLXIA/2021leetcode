package ByteDance.VerifyPreorderSerializationOfABinaryTree331;

public class Solution1 {
    public boolean isValidSerialization(String preorder) {
        // 每一个不是0的都贡献两个slot
        int slot = 1;
        String[] sarr = preorder.split(",");
        for(int i = 0;i<sarr.length;i++) {
            slot--;
            if(slot < 0){
                return false;
            }

            if(!sarr[i].equals("#")){
                slot = slot + 2;
            }
        }
        return slot == 0;
    }
}
