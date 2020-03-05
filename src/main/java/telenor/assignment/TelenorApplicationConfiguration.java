package telenor.assignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import telenor.assignment.application.TelenorGreetingService;
import telenor.assignment.domain.TelenorAssignmentRuleHandler;

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
