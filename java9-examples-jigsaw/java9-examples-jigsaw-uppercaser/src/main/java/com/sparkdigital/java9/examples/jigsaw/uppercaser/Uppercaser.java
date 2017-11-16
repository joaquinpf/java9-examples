package com.sparkdigital.java9.examples.jigsaw.uppercaser;

import com.sparkdigital.java9.examples.jigsaw.api.StringTransformer;

public class Uppercaser implements StringTransformer {

    @Override
    public String transform(String input) {
        return input.toUpperCase();
    }
}
