package auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
class RegistrationTest {
    @Test
    void isUsernameExistsInDBTest() {
        var registration = new Registration();
        var isUsernameExistsInDB = registration.checkUsernameExistInDB("kirill");
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("\n---------------------------------------------------" +
                           "\ntest " + name);
        assertTrue(isUsernameExistsInDB);
    }

    @Test
    void isCredExistInDBTest() {
        var registration = new Registration();
        var isCredExistInDB = registration.checkCredExistInDB("kirill", "qwe");
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("\n---------------------------------------------------" +
                           "\ntest " + name);
        assertTrue(isCredExistInDB);
    }

}
