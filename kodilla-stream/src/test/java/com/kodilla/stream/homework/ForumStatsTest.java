package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForumStatsTest {

    @Test
    void testGetAvgPostsForUsersOlderThanOrEqualTo40() {
        // Given
        List<User> users = new ArrayList<>();
        users.add(new User("Walter", 50, 10, "Chemists"));
        users.add(new User("Gus", 40, 20, "Board"));
        users.add(new User("Jessie", 25, 100, "Sales"));

        // When
        double avg = ForumStats.getAvgPostsForUsersOlderThanOrEqualTo40(users);

        // Then
        assertEquals(15.0, avg);
    }

    @Test
    void testGetAvgPostsForUsersYoungerThan40() {
        // Given
        List<User> users = new ArrayList<>();
        users.add(new User("Jessie", 25, 50, "Sales"));
        users.add(new User("Tuco", 35, 10, "Manager"));
        users.add(new User("Walter", 50, 10, "Chemists"));

        // When
        double avg = ForumStats.getAvgPostsForUsersYoungerThan40(users);

        // Then
        assertEquals(30.0, avg);
    }

    @Test
    void testGetAvgWhenNoUsersYoungerThan40() {
        // Given
        List<User> users = new ArrayList<>();

        // When
        double avg = ForumStats.getAvgPostsForUsersYoungerThan40(users);

        // Then
        assertEquals(0.0, avg);
    }

    @Test
    void testGetAvgWhenNoUsersOlderThanOrEqualTo40() {
        // Given
        List<User> users = new ArrayList<>();

        // When
        double avg = ForumStats.getAvgPostsForUsersOlderThanOrEqualTo40(users);

        // Then
        assertEquals(0.0, avg);
    }
}