package me.skrew.javastudy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] card) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : card) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                Integer integer = map.get(i);
                map.put(i, integer + 1);
            }
        }

        int[] answer = new int[2];
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                if (answer[0] == 0) answer[0] = integer;
                else answer[1] = integer;
            }
        }

        int[] ints = Arrays.stream(answer).sorted().toArray();

        return ints;
    }

}
