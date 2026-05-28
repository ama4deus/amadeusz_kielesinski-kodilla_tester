package com.kodilla;


import com.kodilla.abstracts.Animal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTestSuite {

    // Tworzymy prostą klasę dziedziczącą na potrzeby testu
    private static class Dog extends Animal {
        public Dog() {
            super(4);
        }
        @Override
        public void giveVoice() {
            System.out.println("Woof!");
        }
    }

    @Test
    void testAnimalLogic() {
        // Given
        Animal dog = new Dog();

        // When & Then
        assertEquals(4, dog.getNumberOfLegs());
        dog.giveVoice(); // To wywołanie "zazieleni" metodę abstrakcyjną
    }
}
