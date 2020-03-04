package telenor.telenorAssignment.domain;

import org.apache.commons.lang3.StringUtils;
import telenor.telenorAssignment.domain.exception.PathNotYetImplementedException;

public class TelenorAssignmentRuleHandler {
    public String validateAndGreet(String account, int id, String type) {
        String greet;
        if(!StringUtils.isEmpty(account) && account.equals("personal")) {
            greet = "Hi, userId " + id;
        }else {
            if(!StringUtils.isEmpty(type) && type.equals("small")){
                throw new PathNotYetImplementedException("Path not implemented yet");
            }else {
                greet = "Welcome, Business user!";
            }
        }
        return greet;
    }
}
