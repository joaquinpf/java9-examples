package com.sparkdigital.java9.examples.interfaces;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> users = new HashMap<>();

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public User deleteUser(String id) {
        return users.remove(id);
    }

    @Override
    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }
}
