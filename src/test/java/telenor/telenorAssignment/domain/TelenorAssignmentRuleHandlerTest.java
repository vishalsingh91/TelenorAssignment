package telenor.telenorAssignment.domain;

import org.junit.Test;
import telenor.telenorAssignment.domain.exception.PathNotYetImplementedException;

import static org.junit.Assert.assertEquals;


public class TelenorAssignmentRuleHandlerTest {


    @Test
    public void shouldRetrunGreetMessageIfPersonalUser() throws Exception {
        //given
        String account = "personal";
        int id = 123;
        String expectedMessage = "Hi, userId " + id;

        //when
        String actualMessage = new TelenorAssignmentRuleHandler().validateAndGreet(account, id, null);

        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void shouldReturnWelcomeMessageIfBusinessUser() {
        //given
        String account = "business";
        int id = 123;
        String type = "big";
        String expectedMessage = "Welcome, Business user!";

        //when
        String actualMessage = new TelenorAssignmentRuleHandler().validateAndGreet(account, id, type);

        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(expected = PathNotYetImplementedException.class)
    public void shouldThrowExceptionTypeIsSmall() {
        //given
        String account = "business";
        int id = 123;
        String type = "small";
        //when
        new TelenorAssignmentRuleHandler().validateAndGreet(account, id, type);

        //then

    }
}