package com.coding.herren;

import java.util.Arrays;

public class Test4 {

    public static final int goal = 7; // 목표값
    public static void main(String[] args) {
        String str = "apdkf35k47n1t2";

        // 대상자 - 중복제거
        int[] nums = Arrays.stream(str.replaceAll("[^0-9]","").split("")).mapToInt(Integer::valueOf).distinct().toArray();
        // 방문 노드
        boolean[] visited = new boolean[nums.length];

        // 멱집합으로 계산
        int a = powerSet(nums, visited, 0);
        System.out.println("a= "+a);
    }

    public static int powerSet(int[] arr, boolean[] visited, int i) {
        if (i == arr.length) {
            // 방문한 노드의 값만 합산
            int sum = 0;
            for (int w = 0; w < arr.length; w++) {
                if (visited[w]) {
                    sum += arr[w];
                }
            }
            return sum== goal? 1: 0;
        }

        visited[i] = false; // 현재 값이 포함되지 않는 경우
        int case1 = powerSet(arr, visited, i + 1);

        visited[i] = true;    // 현재값이 포함되는 경우
        int case2 = powerSet(arr, visited, i + 1);
        return case1 + case2;
    }
}
