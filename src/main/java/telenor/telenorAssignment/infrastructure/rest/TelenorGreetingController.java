package telenor.telenorAssignment.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import telenor.telenorAssignment.application.TelenorGreetingService;
import telenor.telenorAssignment.domain.ValuesAllowed;

import javax.validation.constraints.Pattern;

@RestController
@Validated
@RequestMapping("/greeting")
public class TelenorGreetingController {
    private TelenorGreetingService telenorGreetingService;

    @Autowired
    public TelenorGreetingController(TelenorGreetingService telenorGreetingService) {
        this.telenorGreetingService = telenorGreetingService;
    }

    @GetMapping
    public ResponseEntity greetUser(
            @ValuesAllowed(propName = "account", values = {"personal", "business"}) @RequestParam(value = "account") String account,
            @ValuesAllowed(propName = "type", values = {"small", "big"}) @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "id", required = false) @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Only positive numbers are allowed!") String id) {

        String greet = telenorGreetingService.greetUser(account, type, id);

        return ResponseEntity.ok().body(greet);
    }
}
