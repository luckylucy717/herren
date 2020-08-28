package com.coding.herren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        String values = "";
        try {
            num = Integer.parseInt(br.readLine());
            values = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 입력받은 갯수만큼만 정렬하도록 제한
        // 제한을 제외할 경우 limit(num) 제외
        String result = Arrays.stream(values.split(","))
                            .limit(num)
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.joining(","));
        System.out.println(result);
    }


}
