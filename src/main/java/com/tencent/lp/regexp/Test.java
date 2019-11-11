package com.tencent.lp.regexp;

import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Leepong
 * @date 16:09  2019/11/8
 * @description
 */
public class Test {
    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.contains(".") || p.contains("*")) {
            return s.matches(p);
        } else {
            return s.equals(p);
        }
    }
}
