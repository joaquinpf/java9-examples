package com.sparkdigital.java9.examples.optional;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OptionalTest {

    @Test
    public void optionalIfPresentOrElse() {
        List<Optional<String>> words = List.of(Optional.of("Spark"), Optional.empty());

        words.stream().forEach(word -> word.ifPresentOrElse(System.out::println, () -> System.out.println("Digital")));
    }

    @Test
    public void optionalOr() {
        List<Optional<String>> words = List.of(Optional.of("Spark"), Optional.empty());

        List<Optional<String>> completedWords = words.stream().map(word -> word.or(() -> Optional.of("Digital"))).collect(Collectors.toList());

        assertThat(completedWords).containsExactly(Optional.of("Spark"), Optional.of("Digital"));
    }

    @Test
    public void optionalStream() {
        List<Optional<String>> words = List.of(Optional.of("Spark"), Optional.of("Digital"), Optional.empty(), Optional.ofNullable(null));

        // Filter results with actual values
        List<String> filteredList = words.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        // Check results
        assertThat(filteredList).containsExactly("Spark", "Digital");
    }

}
