package com.smartcloud.common.utils.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCode {

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars1 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
//        System.out.println(compress(chars1));
        int can[] = {10, 1, 2,2,4,4, 7, 6, 1, 5};
//        List<List<Integer>> lists = combinationSum(can, 12);
        List<List<Integer>> lists = combinationSum2(can, 8);
        System.out.println(lists);
    }

    public static int compress(char[] chars) {

        if (chars.length < 2) return chars.length;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.putIfAbsent(c, 1);
            }
        }
        List<Character> res = new ArrayList();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            res.add(entry.getKey());
            if (entry.getValue() > 1) {
                String s = String.valueOf(entry.getValue());
                char[] temp = s.toCharArray();
                Stream stream = Stream.of(temp);
                List collect = (List<Character>) stream.collect(Collectors.toList());
                res.addAll(collect);
            }
        }
        return res.size();
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        help(candidates, 0, temp, target, res);

        return res.stream().distinct().collect(Collectors.toList());
    }

    public static void help(int[] can, int start, List<Integer> each, int tartget, List<List<Integer>> res) {
        for (int i = start; i < can.length; i++) {
            List<Integer> temp = new ArrayList<>(each);
            if (i > start && can[i] == can[i - 1]) {
                //remove duplicates.
                System.out.println("remove duplicates");
                continue;
            } else if (can[i] == tartget) {
                temp.add(can[i]);
                res.add(temp);
                break;
            } else if (can[i] < tartget) {
                temp.add(can[i]);
                help(can, i+1, new ArrayList<>(temp), tartget - can[i], res);
            } else {
                break;
            }
        }
    }

    static HashSet<List<Integer>> set = new HashSet<>();

    /**
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        help(candidates, 0, new ArrayList<Integer>(), target, res);
        return res;
    }
}
