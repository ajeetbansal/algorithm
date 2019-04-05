package aj.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ajeet on 3/26/2019.
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring(\"abcabcaaa\") = " + lengthOfLongestSubstring("abcabcaaa"));
        System.out.println("lengthOfLongestSubstring(\"abcdabcdeaaa\") = " + lengthOfLongestSubstring("abcdabcdeaaa"));
        System.out.println("lengthOfLongestSubstring(\"bbaaa\") = " + lengthOfLongestSubstring("bbaaa"));
        System.out.println("lengthOfLongestSubstring(\"bbbbb\") = " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("lengthOfLongestSubstring(\"dvdf\") = " + lengthOfLongestSubstring("dvdf"));
        System.out.println("lengthOfLongestSubstring(\"pwwkew\") = " + lengthOfLongestSubstring("pwwkew"));
        System.out.println("lengthOfLongestSubstring(\"\") = " + lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int maxLen = 0;
        int currBeg = 0;
        Set<Character> maxSet = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character nextChar = s.charAt(i);
            while (maxSet.contains(nextChar)) {
                maxSet.remove(s.charAt(currBeg));
                currBeg++;
            }
            maxSet.add(nextChar);
            if (maxSet.size() > maxLen)
                maxLen = maxSet.size();
        }
        return maxLen;
    }
}
