package com.salimov.yurii.generator;

import java.util.Random;

/**
 * Class for generating random string.
 *
 * @author Yuriy Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public class StringGenerator implements Generator<String> {

    /**
     * An instance of Random class is used to generate
     * a stream of pseudorandom numbers.
     */
    private final static Random RANDOM = new Random();

    /**
     * Default pattern to generated new string.
     */
    private final static char[] DEFAULT_PATTERN;

    /**
     * Default length to generate string.
     */
    private final static long DEFAULT_LENGTH = 10;

    /**
     * Pattern to generated new string.
     */
    private final char[] pattern;

    /**
     * Length to generate string.
     */
    private final long length;

    /**
     * Generated string.
     */
    private String string;

    /**
     * Static block.
     * Pattern initialization.
     */
    static {
        DEFAULT_PATTERN = (
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                        "abcdefghijklmnopqrstuvwxyz" +
                        "0123456789"
        ).toCharArray();
    }

    /**
     * Default constructor.
     */
    public StringGenerator() {
        this.pattern = DEFAULT_PATTERN;
        this.length = DEFAULT_LENGTH;
    }

    /**
     * Constructor.
     *
     * @param length a length to generate string.
     */
    public StringGenerator(final long length) {
        this.pattern = DEFAULT_PATTERN;
        this.length = length > 0 ? length : DEFAULT_LENGTH;
    }

    /**
     * Constructor.
     *
     * @param pattern a pattern to generated new string.
     */
    public StringGenerator(final String pattern) {
        this.pattern = pattern != null ? pattern.toCharArray() : DEFAULT_PATTERN;
        this.length = DEFAULT_LENGTH;
    }

    /**
     * Constructor.
     *
     * @param pattern a pattern to generated new string.
     * @param length  a length to generate string.
     */
    public StringGenerator(final String pattern, final long length) {
        this.pattern = pattern != null ? pattern.toCharArray() : DEFAULT_PATTERN;
        this.length = length > 0 ? length : DEFAULT_LENGTH;
    }

    /**
     * Generates random string.
     *
     * @return The generated string.
     */
    @Override
    public String generate() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.length; i++) {
            sb.append(getRandomChar());
        }
        this.string = sb.toString();
        return this.string;
    }

    /**
     * Returns generated string.
     * If string is null then calls method generate().
     *
     * @return The generated string.
     */
    @Override
    public String get() {
        if (this.string == null) {
            generate();
        }
        return this.string;
    }

    /**
     * Returns random char.
     *
     * @return The random char.
     */
    private char getRandomChar() {
        return this.pattern[RANDOM.nextInt(this.pattern.length)];
    }
}
