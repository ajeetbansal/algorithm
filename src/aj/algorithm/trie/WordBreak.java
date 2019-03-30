/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 Note:

 The same word in the dictionary may be reused multiple times in the segmentation.
 You may assume the dictionary does not contain duplicate words.
 Example 1:

 Input: s = "leetcode", wordDict = ["leet", "code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".
 Example 2:

 Input: s = "applepenapple", wordDict = ["apple", "pen"]
 Output: true
 Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 Note that you are allowed to reuse a dictionary word.
 Example 3:

 Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 Output: false

 */
package aj.algorithm.trie;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ajeet on 3/30/2019.
 */
public class WordBreak {

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("theanybye", Arrays.asList(keys)));

    }
    Trie trie = new Trie();
    public boolean wordBreak(String s, List<String> wordDict) {
        wordDict.stream().forEach(trie::insert);
        return canWordBreak(s);
    }

    private boolean canWordBreak(String s) {
        if(s.isEmpty()) return true;
        for(int i=1;i <=s.length(); i++){
            String subStr = s.substring(0, i);
            if(trie.search(subStr) && canWordBreak(s.substring(i)))
                return true;
        }
        return false;
    }
}
