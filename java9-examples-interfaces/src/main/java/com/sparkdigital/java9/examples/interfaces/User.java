package com.sparkdigital.java9.examples.interfaces;

import java.util.List;
import java.util.Objects;

public class User {
    private String id;
    private String name;
    private List<String> tags;

    public User(String name, List<String> tags) {
        this.name = name;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getTags(), user.getTags());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTags());
    }
}
