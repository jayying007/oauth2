package com.example.authserver.util;

import java.util.Random;

/**
 * @author jayying
 * @since 2021/1/13
 */
public class CodeUtils {
    private static final Random random = new Random();

    public static String getRandomCode(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            int n = random.nextInt(80) + 48;
            if(n >= 'a' && n <= 'z') {
                sb.append((char) n);
            } else if(n >= 'A' && n <= 'Z') {
                sb.append((char) n);
            } else if(n >= '0' && n <= '9') {
                sb.append((char) n);
            } else {
                i--;
            }
        }
        return sb.toString();
    }
}
