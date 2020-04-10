package Questions.Question1to30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 30. 串联所有单词的子串
 * <p>
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        for (int i =0; i < s.length() - wordNum * wordLen +1; i++){
            HashMap<String,Integer> hasWords = new HashMap<>();
            int num = 0;
            while (num < wordNum){
                String word = s.substring(i + num * wordLen,i + (num +1 )* wordLen);
                if (allWords.containsKey(word)){
                    int value = hasWords.getOrDefault(word,0);
                    hasWords.put(word,value + 1);
                    if (hasWords.get(word)> allWords.get(word) ){
                        break;
                    }
                }else{
                    break;
                }
                num++;
            }
            if (num == wordNum){
                res.add(i);
            }
        }
        return res;
    }
}
