package codeSignal.MaximumRepeatingSubstring1668;

/**
 * For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence. The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence. If word is not a substring of sequence, word's maximum k-repeating value is 0.
 *
 * Given strings sequence and word,
 * return the maximum k-repeating value of word in sequence.
 */
public class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder(word);
        int count = 0;
        while(true){
            if(sequence.contains(sb)){
                count++;
                sb.append(word);
            } else {
                return count;
            }

        }
    }
}
