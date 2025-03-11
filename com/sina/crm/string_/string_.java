package com.sina.crm.string_;

/**
 * @author caoshuai
 * @version 1.0
 */
public class string_ {
    public static void main(String[] args) {

        String str = "0123456789";
        int i = 2, j = 6;
        char[] c = str.toCharArray();
        for (; i < j; i++, j--) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        String ans = new String(c);
        System.out.println(ans);


    }

}


