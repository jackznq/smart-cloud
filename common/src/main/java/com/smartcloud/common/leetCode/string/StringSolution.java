package com.smartcloud.common.leetCode.string;

import java.util.*;

/**
 * @Date 18/11/27 下午9:07
 * @Auther znq
 * @ClassName StringSolution
 **/
public class StringSolution {

    public static void main(String[] args) {

        String inout = "(])";
//        boolean valid = isValid(inout);
//        System.out.println(valid);
        String s = "anagram";
        String t = "nagaram";
//        System.out.println(isAnagram(s, t));
        String[] data = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        groupAnagrams(data);
//        isAnagram(s, t);
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
//        String s1 = replaceWords(dict, "the cattle was rattled by the battery");
//        System.out.println(s1);
    }

    /**
     * Input: "()[]{}"
     * Output: true
     * <p>
     * "(])"
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (null == s) return false;
        Map<Character, Character> validCharacter = new HashMap<>();
        validCharacter.put(')', '(');
        validCharacter.put('}', '{');
        validCharacter.put(']', '[');
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (validCharacter.containsValue(c)) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (stack.peek().equals(validCharacter.get(c))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 242. Valid Anagram
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;

        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return getMap(s).equals(getMap(t));
    }

    private static Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> smap = new HashMap();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (smap.containsKey(c)) {
                Integer val = smap.get(c);
                smap.remove(c);
                val++;
                smap.put(c, val);
                continue;
            }
            smap.put(c, 1);
        }
        return smap;
    }

    public int singleNumber(int[] nums) {

        return 0;
    }

    /**
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String a : strs) {
            char[] chars = a.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(a);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 648. Replace Words
     *
     * @param dict
     * @param sentence
     * @return
     */
    public static String replaceWords(List<String> dict, String sentence) {

        if (dict.size() == 0) {
            return sentence;
        }
        String[] split = sentence.split(" ");
        for (String s : dict) {
            for (int i = 0; i < split.length; i++) {
                if (split[i].startsWith(s)) {
                    split[i] = split[i].replaceAll(split[i], s);
                }
            }
        }
        return Arrays.toString(split).replace(",", "").replace("[", "").replace("]", "");
    }





    /**
     * 217. Contains Duplicate
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set containsDuplicate = new HashSet();
        for (int i : nums) {
            if (containsDuplicate.contains(i)) {
                return true;
            }
            containsDuplicate.add(i);

        }
        return false;
    }


}
