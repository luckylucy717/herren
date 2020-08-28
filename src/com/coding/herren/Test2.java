package com.coding.herren;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {
        String text = "자바프로그래밍";

        String data = text.chars().mapToObj(m->getInitialSound((char) m)).collect(Collectors.joining(""));
        System.out.println(data);
    }

    // 아래 소스를 이용함
    // http://www.gisdeveloper.co.kr/?p=1973
    static String getInitialSound(char chName) {
        String[] chs = { "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ" };
        if(chName >= 0xAC00)
        {
            int uniVal = chName - 0xAC00;
            int cho = ((uniVal - (uniVal % 28))/28)/21;

            return chs[cho];
        }
        return null;
    }
}
