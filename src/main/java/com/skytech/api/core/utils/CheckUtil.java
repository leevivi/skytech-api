package com.skytech.api.core.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LiWei on 2019/4/4.
 */
public class CheckUtil {
    public static Boolean checkEmail(String email){
        //电子邮件
        String check = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    public static boolean checkTargetValueInList(int[] arr,int targetValue){
        return Arrays.asList(arr).contains(targetValue);
    }
    public static void main(String[] args){
        int[] abc = new int[]{1,2,3};
        Boolean abcd = checkTargetValueInList(abc,2);
        System.out.println(abcd);
        /*int b = (int)((66+6.2*62*2.2+12.7*162*0.39-6.76*25)*1.55/5);
        System.out.println(b);

        String BMR = String.valueOf((int)((66+(6.2*62*2.2)+(12.7*162*0.39)-(6.76*25))*1.55/5));
        System.out.println(BMR);*/

    }
}
