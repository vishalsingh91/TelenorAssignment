package telenor.telenorAssignment.domain;

import telenor.telenorAssignment.domain.exception.PathNotYetImplementedException;

public class TelenorAssignmentRuleHandler {
    public String validateAndGreet(String account, String type, String id) {

        if ("business".equals(account) && "small".equals(type)) {
            throw new PathNotYetImplementedException("Path not implemented yet");
        }
        return "personal".equals(account) ? "Hi, userId " + id : "Welcome, Business user!";
    }
}
