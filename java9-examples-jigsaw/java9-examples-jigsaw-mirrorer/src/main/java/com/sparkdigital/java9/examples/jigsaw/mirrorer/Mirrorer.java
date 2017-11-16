package com.sparkdigital.java9.examples.jigsaw.mirrorer;

import com.sparkdigital.java9.examples.jigsaw.api.StringTransformer;

public class Mirrorer implements StringTransformer {

    @Override
    public String transform(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
