import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloAppTest {
    @Test
    void testGreeting() {
        String expected = "Hello, Intern! This is a simple Java app running in Docker.";
        assertEquals(expected, HelloApp.buildGreeting("Intern"));
    }
}
