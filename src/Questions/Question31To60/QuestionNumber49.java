package Questions.Question31To60;

import java.util.*;

/**
 * 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 */
class QuestionNumber49 {
    //    解法一
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            List<String> temp = null;
            if (!used[i]) {
                temp = new ArrayList<>();
                temp.add(strs[i]);
                for (int j = 0; j < strs.length; j++) {
                    if (Equals(strs[i], strs[j])) {
                        used[j] = true;
                        temp.add(strs[j]);
                    }
                }
            }
            if (temp != null) {
                ans.add(temp);
            }
        }
        return ans;
    }

    private boolean Equals(String str, String str1) {
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (hash.containsKey(str.charAt(i))) {
                hash.put(str.charAt(i), hash.get(str.charAt(i)) + 1);
            } else {
                hash.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str1.length(); i++) {
            if (hash.containsKey(str1.charAt(i))) {
                hash.put(str1.charAt(i), hash.get(str1.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        Set<Character> set = hash.keySet();
        for (char c : set) {
            if (hash.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    //    解法二
    public List<List<String>> groupAnagrams1(String[] str) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            char[] s_arr = str[i].toCharArray();
            Arrays.sort(s_arr);
            String key = String.valueOf(s_arr);
            if (hash.containsKey(key)) {
                hash.get(key).add(str[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str[i]);
                hash.put(key, temp);
            }
        }
        return new ArrayList<>(hash.values());
    }

    //    解法三
    public List<List<String>> groupAnagrams2(String[] str) {
        HashMap<Integer, List<String>> hash = new HashMap<>();
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 32, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for (int i = 0; i < str.length; i++) {
            int key = 1;
            for (int j = 0; j < str[i].length(); j++) {
                key *= prime[str[i].charAt(j) - 'a'];
            }
            if (hash.containsKey(key)) {
                hash.get(key).add(str[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str[i]);
                hash.put(key, temp);
            }
        }
        return new ArrayList<>(hash.values());
    }

    //    解法四
    public List<List<String>> groupAnagrams3(String[] str) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            int[] num = new int[26];
            for (int j = 0; j < str[i].length();i++){
                num[str[i].charAt(j) - 'a']++;
            }
            String key = "";
            for (int j = 0; j < num.length; j++) {
                key = key +num[j]+'#';
            }
            if (hash.containsKey(key)) {
                hash.get(key).add(str[i]);
            }else {
                List<String> temp = new ArrayList<> ();
                temp.add(str[i]);
                hash.put(key, temp);
            }
        }
        return new ArrayList<> (hash.values());
    }
}
