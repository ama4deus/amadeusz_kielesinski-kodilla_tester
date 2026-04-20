package com.kodilla.stream;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UsersManagerTest {

    @Test
    void testFilterChemistGroupUsernames() {
        // When
        List<String> usernames = UsersManager.filterChemistGroupUsernames();

        // Then
        assertEquals(2, usernames.size());
        assertTrue(usernames.contains("Walter White"));
        assertTrue(usernames.contains("Gale Boetticher"));
    }

    @Test
    void testFilterUsersOlderThan() {
        // Given
        int ageToCompare = 40;

        // When
        List<User> result = UsersManager.filterUsersOlderThan(ageToCompare);

        // Then
        for (User user : result) {
            assertTrue(user.getAge() > ageToCompare);
        }
        assertEquals(4, result.size());
    }

    @Test
    void testFilterUsersWithMoreThanOneHundredPosts() {
        // When
        List<String> result = UsersManager.filterUsersWithMoreThanOneHundredPosts();

        // Then
        assertEquals(2, result.size());
        assertTrue(result.contains("Jessie Pinkman"));
        assertTrue(result.contains("Tuco Salamanca"));
    }
}