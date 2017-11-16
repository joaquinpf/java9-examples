package com.sparkdigital.java9.examples.interfaces;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class InMemoryUserRepositoryTest {

    @Test
    public void filterByName() {
        UserRepository repository = new InMemoryUserRepository();
        repository.createUser(new User("Spark", List.of("dev")));
        repository.createUser(new User("Digital", List.of("dev", "qa")));

        List<User> filteredUsers = repository.filterByName("Spark");

        assertThat(filteredUsers).hasSize(1);
        assertThat(filteredUsers.get(0).getName()).isEqualTo("Spark");
    }

    @Test
    public void filterByTag() {
        UserRepository repository = new InMemoryUserRepository();
        repository.createUser(new User("Spark", List.of("dev")));
        repository.createUser(new User("Digital", List.of("dev", "qa")));

        List<User> filteredUsers = repository.filterByTag("qa");

        assertThat(filteredUsers).hasSize(1);
        assertThat(filteredUsers.get(0).getTags()).contains("qa");
    }
}