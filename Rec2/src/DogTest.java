import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @org.junit.jupiter.api.Test
    void getHeight() {
    }

    @Test
    void setHeight() {
    }

    @org.junit.jupiter.api.Test
    void getWeight() {
    }

    @org.junit.jupiter.api.Test
    void setWeight() {
    }

    @org.junit.jupiter.api.Test
    void getName() {
    }

    @org.junit.jupiter.api.Test
    void setName() {
    }

    @org.junit.jupiter.api.Test
    void makeNoise() {
    }

    @Test
    void test() {

        // FORMAT: assertEquals(expected value, actual value);

        Animal dog1 = new Dog(1, 12, "JK");

        assert(dog1.getHeight() == 1);
        assertEquals(1, dog1.getHeight());
        assertEquals("JK", dog1.getName());
    }
}