package com.smartcloud.common.utils.leetCode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Word Break
 * Created by ddfhznq on 2017/11/20.
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        List<Integer> size = new ArrayList<>();
        int len = s.length();
        for (String ss : wordDict) {
            size.add(ss.length());
        }
        int result=0;
        for (Integer i:size) {
            result+=i;
        }
        if (len!=result){
            return false;
        }
        int wordDictSize = wordDict.size();
        int count=0;
        for (String string: wordDict) {
            if (s.contains(string)){
                count++;
            }
        }
        if (wordDictSize==count){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("bbb");
        strings.add("bbbb");
        String s = "bb";
        System.out.println(wordBreak(s,strings));
    }
}
