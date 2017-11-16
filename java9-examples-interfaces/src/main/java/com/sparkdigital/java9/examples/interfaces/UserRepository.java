package com.sparkdigital.java9.examples.interfaces;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface UserRepository {

    User getUser(String id);

    User deleteUser(String id);

    User createUser(User user);

    List<User> getUsers();

    default List<User> filterByName(String name) {
        return filterBy(article -> article.getName().equals(name));
    }

    default List<User> filterByTag(String tag) {
        return filterBy(article -> article.getTags().contains(tag));
    }

    private List<User> filterBy(Predicate<User> toFilterBy) {
        return getUsers().stream()
                .filter(toFilterBy)
                .collect(Collectors.toList());
    }
}