package Google.SentenceScreenFitting418;

/**
 * Given a rows x cols screen and a sentence represented as a list of strings,
 * return the number of times the given sentence can be fitted on the screen.
 *
 * The order of words in the sentence must remain unchanged,
 * and a word cannot be split into two lines.
 * A single space must separate two consecutive words in a line.
 */
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int index = 0;
        int count = 0;
        for(int i = 0;i<rows;i++){
            if(sentence[index].length() > cols){
                return 0;
            }
            int colLength = sentence[index].length();
            while(colLength <= cols){
                colLength++;
                if(index != sentence.length-1){
                    index = index +1;
                } else {
                    index = 0;
                    count++;
                }
                colLength += sentence[index].length();
            }
        }
        return count;
    }
}
