package com.sparkdigital.java9.examples.collections;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CollectionsTest {

    @Test
    public void listTests() {
        List<String> list = List.of("spark", "digital", "test");

        // We can't add new elements
        assertThatThrownBy(() -> list.add("can't add new elements")).isInstanceOf(UnsupportedOperationException.class);

        // We can't remove elements
        assertThatThrownBy(() -> list.remove(0)).isInstanceOf(UnsupportedOperationException.class);

        // We can add null values to a regular ArrayList
        List<String> oldList = new ArrayList<>();
        oldList.add(null);

        // But not using the factory method
        assertThatThrownBy(() -> List.of(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void setTests() {
        Set<String> set = Set.of("spark", "digital", "test");

        // We can't add new elements
        assertThatThrownBy(() -> set.add("can't add new elements")).isInstanceOf(UnsupportedOperationException.class);

        // We can't remove elements
        assertThatThrownBy(() -> set.remove("spark")).isInstanceOf(UnsupportedOperationException.class);

        // We can add null values to a regular HashSet
        Set<String> oldList = new HashSet<>();
        oldList.add(null);

        // But not using the factory method
        assertThatThrownBy(() -> Set.of(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void mapTests() {
        Map<String, String> map = Map.of("spark", "v1", "digital", "v2", "test", "v3");

        // We can't add new elements
        assertThatThrownBy(() -> map.put("can't add new elements", "value")).isInstanceOf(UnsupportedOperationException.class);

        // We can't remove elements
        assertThatThrownBy(() -> map.remove("spark")).isInstanceOf(UnsupportedOperationException.class);

        // We can't modify existing elements
        assertThatThrownBy(() -> map.put("spark", "value")).isInstanceOf(UnsupportedOperationException.class);

        // We can add null values to a regular HashMap
        Map<String, String> oldMap = new HashMap<>();
        oldMap.put("aa", null);

        // But not using the factory method
        assertThatThrownBy(() -> Map.of("spark", null)).isInstanceOf(NullPointerException.class);
    }
}
