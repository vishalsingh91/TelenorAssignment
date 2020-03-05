package telenor.assignment.infrastructure.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import telenor.assignment.application.TelenorGreetingService;
import telenor.assignment.domain.exception.PathNotYetImplementedException;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TelenorGreetingController.class)

public class TelenorGreetingControllerTest {
    @MockBean
    TelenorGreetingService telenorGreetingService;
    @Autowired
    private MockMvc mockMvc;
    private static final String API_BASE_PATH = "/greeting";

    @Test
    public void shouldReturnGreetingMessageIfAccountIsPersonal() throws Exception {
        String expectedString = "Hi, userId 123";
        given(telenorGreetingService.greetUser("personal", null, "123"))
                .willReturn(expectedString);
        mockMvc.perform(get(API_BASE_PATH + "?account=personal&id=123")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedString));
    }

    @Test
    public void shouldThrowExceptionIfIdIsNotAPositiveNumber() throws Exception {

        mockMvc.perform(get(API_BASE_PATH + "?account=business&id=-123")
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldThrowExceptionIfAccountIsAnythingElseApartFromPersonalOrBusiness() throws Exception {

        mockMvc.perform(get(API_BASE_PATH + "?account=xyz&id=123")
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldThrowExceptionIfTypeIsAnythingElseApartFromSmallOrBig() throws Exception {

        mockMvc.perform(get(API_BASE_PATH + "?account=personal&type=xyz")
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnGreetingMessageIfAccountIsBusinessAndTypeIsBig() throws Exception {
        String expectedString = "Welcome, Business user!";
        given(telenorGreetingService.greetUser("business", "big", null))
                .willReturn(expectedString);
        mockMvc.perform(get(API_BASE_PATH + "?account=business&type=big")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedString));
    }

    @Test
    public void shouldThrowExceptionIfAccountIsBusinessAndTypeIsSmall() throws Exception {
        given(telenorGreetingService.greetUser("business", "small", null))
                .willThrow(new PathNotYetImplementedException("Path Not implemented yet"));
        mockMvc.perform(get(API_BASE_PATH + "?account=business&type=small")
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }
}
