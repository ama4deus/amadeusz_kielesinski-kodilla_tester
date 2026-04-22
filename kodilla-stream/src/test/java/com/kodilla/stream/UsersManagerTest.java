package com.kodilla.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersManagerTest {

    @Test
    void testFilterChemistGroupUsernames() {
        List<String> usernames = UsersManager.filterChemistGroupUsernames();
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
        boolean allOlder = result.stream()
                .allMatch(user -> user.getAge() > ageToCompare);

        assertTrue(allOlder);
        assertEquals(4, result.size());
    }

    @Test
    void testFilterUsersOlderThan100() {
        // Given
        int ageToCompare = 100;

        // When
        List<User> result = UsersManager.filterUsersOlderThan(ageToCompare);

        // Then
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testFilterUsersWithMoreThanOneHundredPosts() {
        List<String> result = UsersManager.filterUsersWithMoreThanOneHundredPosts();
        assertEquals(2, result.size());
        assertTrue(result.contains("Jessie Pinkman"));
        assertTrue(result.contains("Tuco Salamanca"));
    }
}