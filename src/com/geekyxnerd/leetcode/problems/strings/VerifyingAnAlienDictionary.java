package com.geekyxnerd.leetcode.problems.strings;

/**
 * @author geekyxnerd
 * Created on 09-Apr-21 at 8:24 PM.
 *
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */
public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {

        //Assign weights to the characters in the order
        int weight = 0;
        int[] mapping = new int[26]; // because only lowercase english alphabets are to be considered
        //Loop throughout the order array
        for(char c: order.toCharArray()){
            //Assign the weights
            mapping[c-'a'] = weight++; // c -'a' - to make it a -> 0, b-> 1 and so on ...
        }
        //Iterate over the words
        for(int i=0;i<words.length - 1;i ++){
            //Compare two words only till min of length of the words
            String curr = words[i];
            String next = words[i+1];

            int len = Math.min(curr.length(),next.length());

            //Case: when the second word is a subsequence of first word
            if(len != curr.length() && curr.startsWith(next)){
                return false;
            }

            // Compare each alphabets in the two words
            for(int l=0;l<len;l++){
                //If alphabet from word 1 has more weight compared to next word then return false
                int chWeight1 = mapping[curr.charAt(l) - 'a'];
                int chWeight2 = mapping[next.charAt(l) - 'a'];

                if(chWeight1 > chWeight2){
                    return false;
                }

                //If alphabet from word 1 has less weigth compared to next word we got to know its lexicographically sorted..
                if(chWeight1 < chWeight2){
                    break;
                }

            }
        }
        return true;

    }
}
