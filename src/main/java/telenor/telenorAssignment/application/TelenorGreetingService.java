package telenor.telenorAssignment.application;

import telenor.telenorAssignment.domain.TelenorAssignmentRuleHandler;

import javax.validation.constraints.Positive;
import java.util.Optional;

public class TelenorGreetingService {
    private TelenorAssignmentRuleHandler telenorAssignmentRuleHandler;

    public TelenorGreetingService(TelenorAssignmentRuleHandler telenorAssignmentRuleHandler) {
        this.telenorAssignmentRuleHandler = telenorAssignmentRuleHandler;
    }

    public String greetUser(String account, String type, String id) {
        return telenorAssignmentRuleHandler.validateAndGreet(account, type, id);
    }
}
