package telenor.telenorAssignment.application;

import telenor.telenorAssignment.domain.TelenorAssignmentRuleHandler;

public class TelenorGreetingService {
    private TelenorAssignmentRuleHandler telenorAssignmentRuleHandler;

    public TelenorGreetingService(TelenorAssignmentRuleHandler telenorAssignmentRuleHandler) {
        this.telenorAssignmentRuleHandler = telenorAssignmentRuleHandler;
    }

    public String greetUser(String account, int id, String type) {
        return telenorAssignmentRuleHandler.validateAndGreet(account, id, type);
    }
}
