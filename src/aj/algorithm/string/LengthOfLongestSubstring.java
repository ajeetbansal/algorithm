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
        System.out.println("lengthOfLongestSubstring(\"\") = " + lengthOfLongestSubstring(""));
    }
//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            }
//            else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
//    }
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty())
            return 0;
        int maxLen = 0;
        Set<Character> maxSet = new HashSet<Character>();
        for(int i=0; i< s.length();) {
            Character nextChar = s.charAt(i);
            if(maxSet.contains(nextChar)){
                maxSet.remove(nextChar);
            } else {
                maxSet.add(nextChar);
                if(maxSet.size() > maxLen)
                    maxLen = maxSet.size();
                i++;
            }

        }
        return maxLen;
    }
}
