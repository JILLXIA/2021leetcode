package Google.SentenceScreenFitting418;
// simulation 的办法太耗时了！！
public class Solution1 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        // 定义一个cursor
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<sentence.length;i++){
            sb.append(sentence[i] + " ");
        }
        String wholeSentence = sb.toString();
        int cursor = 0;
        for(int i = 0; i < rows;i++){
            cursor += cols;
            if(wholeSentence.charAt(cursor % wholeSentence.length())==' '){
                cursor++;
            } else {
                while(cursor >= 0 && wholeSentence.charAt(cursor % wholeSentence.length())!=' '){
                    cursor--;
                }
                cursor++;
            }
        }
        return cursor / wholeSentence.length();
    }
}
