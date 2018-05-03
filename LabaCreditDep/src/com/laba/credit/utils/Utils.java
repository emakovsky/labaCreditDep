package com.laba.credit.utils;

import java.util.Random;

public class Utils {

    public static String generateId() {
        return new Random().nextInt() + "";
    }
}
