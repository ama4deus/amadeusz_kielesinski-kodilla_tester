package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import com.kodilla.stream.UsersRepository;
import java.util.List;

public class ForumStats {
    public static void main(String[] args) {
        List<User> users = UsersRepository.getUsersList();

        System.out.println("Średnia postów (wiek >= 40): " + getAvgPostsForUsersOlderThanOrEqualTo40(users));
        System.out.println("Średnia postów (wiek < 40): " + getAvgPostsForUsersYoungerThan40(users));
    }

    public static double getAvgPostsForUsersOlderThanOrEqualTo40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() >= 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0.0);
    }

    public static double getAvgPostsForUsersYoungerThan40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() < 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0.0);
    }
}