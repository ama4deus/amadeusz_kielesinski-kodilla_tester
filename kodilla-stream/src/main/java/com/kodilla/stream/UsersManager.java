package com.kodilla.stream;

import java.util.List;
import java.util.stream.Collectors;

public class UsersManager {

    public static List<String> filterChemistGroupUsernames() {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getGroup().equals("Chemists"))
                .map(User::getUsername)
                .collect(Collectors.toList());
    }

    public static List<User> filterUsersOlderThan(int age) {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public static List<String> filterUsersWithMoreThanOneHundredPosts() {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getNumberOfPost() > 100)
                .map(User::getUsername)
                .collect(Collectors.toList());
    }
}