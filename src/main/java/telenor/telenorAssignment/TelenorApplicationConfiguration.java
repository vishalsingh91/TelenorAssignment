package telenor.telenorAssignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import telenor.telenorAssignment.application.TelenorGreetingService;
import telenor.telenorAssignment.domain.TelenorAssignmentRuleHandler;

@Configuration
public class TelenorApplicationConfiguration {
    private TelenorGreetingService telenorGreetingService;

    public TelenorApplicationConfiguration() {
        this.telenorGreetingService = new TelenorGreetingService(new TelenorAssignmentRuleHandler());
    }

    @Bean(name = "telenorGreetingService")
    public TelenorGreetingService telenorGreetingService() {
     return  telenorGreetingService;
    }
}
