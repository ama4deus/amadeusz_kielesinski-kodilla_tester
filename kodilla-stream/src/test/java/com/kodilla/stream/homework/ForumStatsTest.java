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
        users.add(new User("Gus", 40, 20, "Board")); // Brzegowy: dokładnie 40 lat
        users.add(new User("Jessie", 25, 100, "Sales")); // Ten nie powinien być liczony

        // When
        double avg = ForumStats.getAvgPostsForUsersOlderThanOrEqualTo40(users);

        // Then
        // (10 + 20) / 2 = 15.0
        assertEquals(15.0, avg);
    }

    @Test
    void testGetAvgPostsForUsersYoungerThan40() {
        // Given
        List<User> users = new ArrayList<>();
        users.add(new User("Jessie", 25, 50, "Sales"));
        users.add(new User("Tuco", 35, 10, "Manager"));
        users.add(new User("Walter", 50, 10, "Chemists")); // Ten nie powinien być liczony

        // When
        double avg = ForumStats.getAvgPostsForUsersYoungerThan40(users);

        // Then
        // (50 + 10) / 2 = 30.0
        assertEquals(30.0, avg);
    }

    @Test
    void testGetAvgWhenNoUsersMatchCriteria() {
        // Given - warunek brzegowy)
        List<User> users = new ArrayList<>();

        // When
        double avg = ForumStats.getAvgPostsForUsersYoungerThan40(users);

        // Then
        assertEquals(0.0, avg);
    }
}