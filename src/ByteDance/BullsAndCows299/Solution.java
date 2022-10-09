package ByteDance.BullsAndCows299;

import java.util.HashMap;

/**
 * You are playing the Bulls and Cows game with your friend.
 *
 * You write down a secret number and ask your friend to guess what the number is.
 * When your friend makes a guess, you provide a hint with the following info:
 *
 * The number of "bulls", which are digits in the guess that are in the correct position.
 * The number of "cows", which are digits in the guess that are
 * in your secret number but are located in the wrong position.
 * Specifically, the non-bull digits in the guess that could be
 * rearranged such that they become bulls.
 * Given the secret number secret and your friend's guess guess,
 * return the hint for your friend's guess.
 *
 * The hint should be formatted as "xAyB",
 * where x is the number of bulls and y is the number of cows.
 * Note that both secret and guess may contain duplicate digits.
 */
public class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<secret.length();i++){
            int num = secret.charAt(i) - '0';
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int bulls = 0;
        int cows = 0;
        for(int i = 0;i<guess.length();i++){
            int num = guess.charAt(i) - '0';
            if(guess.charAt(i)==secret.charAt(i)){
                bulls++;
                map.put(num, map.get(num) - 1);
                if(map.get(num)==0){
                    map.remove(num);
                }
            }
        }
        for(int i = 0;i<guess.length();i++){
            int num = guess.charAt(i) - '0';
            if(map.containsKey(num) && guess.charAt(i)!=secret.charAt(i)){
                bulls++;
                map.put(num, map.get(num) - 1);
                if(map.get(num)==0){
                    map.remove(num);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }
}
