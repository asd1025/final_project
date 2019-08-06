package com.cafe24.shoppingmall.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CodeMaker {
    public static String makeCode(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
        long timeInMillis =System.currentTimeMillis();
        Date timeInDate = new Date(timeInMillis);
        String timeInFormat = sdf.format(timeInDate);
        return timeInFormat+makeRandomAlpha(2);
    }

    private static String makeRandomAlpha(int digit){
        int num=(int)(Math.random() * 2);
        String alpha="";
        for (int i=0;i<digit;i++) {
            switch (num) {
                case 0: alpha+=(char)((int)(Math.random() * 26)+65); break;
                case 1: alpha+=(char)((int)(Math.random() * 26)+97); break;
            }
        }
        return alpha;
    }

    public static void main(String[] args) {
        // 65~90
        //char ch = (char)((int)(Math.random() * 26)+65);

        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());
        System.out.println(makeCode());

    }
}
