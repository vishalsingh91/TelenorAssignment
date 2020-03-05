package telenor.assignment.application;

import telenor.assignment.domain.TelenorAssignmentRuleHandler;

public class TelenorGreetingService {
    private TelenorAssignmentRuleHandler telenorAssignmentRuleHandler;

    public TelenorGreetingService(TelenorAssignmentRuleHandler telenorAssignmentRuleHandler) {
        this.telenorAssignmentRuleHandler = telenorAssignmentRuleHandler;
    }

    public String greetUser(String account, String type, String id) {
        return telenorAssignmentRuleHandler.validateAndGreet(account, type, id);
    }
}
