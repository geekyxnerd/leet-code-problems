package com.geekyxnerd.leetcode.problems.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gautam
 * Created on 07-Apr-21 at 6:11 PM.
 */
public class LikeUnLike {


    public static void main(String[] args) {
        String s = "textbook";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        int length = s.length();
        return count1(s.toCharArray(), 0, length/2) == count1(s.toCharArray(),length/2,length);
    }

    private static int count1(char[] half, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            char c = half[i];
            if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U'){
                count++;
            }
        }
        return count;
    }

    private static int count(String substring) {
        Pattern pattern = Pattern.compile("[aeiouAEIOU]");
        Matcher matcher = pattern.matcher(substring);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        return count;
    }
}
