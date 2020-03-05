package telenor.telenorAssignment.domain;

import org.junit.Test;
import telenor.telenorAssignment.domain.exception.PathNotYetImplementedException;

import static org.junit.Assert.assertEquals;


public class TelenorAssignmentRuleHandlerTest {


    @Test
    public void shouldReturnGreetMessageIfPersonalUser() {
        //given
        String account = "personal";
        String id = "123";
        String expectedMessage = "Hi, userId " + id;

        //when
        String actualMessage = new TelenorAssignmentRuleHandler().validateAndGreet(account, "", id);

        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void shouldReturnWelcomeMessageIfBusinessUser() {
        //given
        String account = "business";
        String type = "big";
        String expectedMessage = "Welcome, Business user!";

        //when
        String actualMessage = new TelenorAssignmentRuleHandler().validateAndGreet(account, type, null);

        //then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test(expected = PathNotYetImplementedException.class)
    public void shouldThrowExceptionTypeIsSmall() {
        //given
        String account = "business";
        String type = "small";
        //when
        new TelenorAssignmentRuleHandler().validateAndGreet(account, type, null);

        //then

    }
}