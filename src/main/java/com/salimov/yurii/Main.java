package com.salimov.yurii;

import com.salimov.yurii.generator.StringGenerator;

/**
 * Program for generating random string.
 * Example, for generating passwords.
 *
 * @author Yuriy Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        final StringGenerator generator = new StringGenerator();
        final String string = generator.generate();
        System.out.println("Your string: " + string);
    }
}
