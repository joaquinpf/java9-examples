package com.sparkdigital.java9.examples.stream;

import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StreamTest {

    @Test
    public void ofNullableTest() {
        String configurationDirectory =
                Stream.of("app.config", "app.home", "user.home")
                        .flatMap(key -> {
                            final String property = System.getProperty(key);
                            if (property == null) {
                                return Stream.empty();
                            } else {
                                return Stream.of(property);
                            }
                        })
                        .findFirst()
                        .orElseThrow(IllegalStateException::new);

        assertThat(configurationDirectory).isNotBlank();
    }


    @Test
    public void ofNullableTestJava9() {
        String configurationDirectory =
                Stream.of("app.config", "app.home", "user.home")
                        .flatMap(key -> Stream.ofNullable(System.getProperty(key)))
                        .findFirst()
                        .orElseThrow(IllegalStateException::new);

        assertThat(configurationDirectory).isNotBlank();
    }
}
