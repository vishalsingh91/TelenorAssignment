package telenor.telenorAssignment.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import telenor.telenorAssignment.application.TelenorGreetingService;
import telenor.telenorAssignment.domain.ValuesAllowed;

import javax.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/greeting")
public class TelenorGreetingController {
    private TelenorGreetingService telenorGreetingService;

    @Autowired
    public TelenorGreetingController(TelenorGreetingService telenorGreetingService) {
        this.telenorGreetingService = telenorGreetingService;
    }
    @GetMapping(value = "/{account}/{id}")
    public ResponseEntity greetUserWithoutType(
            @ValuesAllowed(propName = "account", values = {"personal", "business"}) @PathVariable(required = false) String account,
            @PathVariable("id") @Positive int id) {

        String greet = telenorGreetingService.greetUser(account, id, null);

        return ResponseEntity.ok().body(greet);
    }

    @GetMapping(value = "/{account}/{id}/{type}")
    public ResponseEntity greetUser(
            @ValuesAllowed(propName = "account", values = {"personal", "business"}) @PathVariable(required = false) String account,
            @PathVariable("id") @Positive int id,
            @ValuesAllowed(propName = "type", values = {"small", "big",}) @PathVariable(required = false) String type) {

        String greet = telenorGreetingService.greetUser(account, id, type);

        return ResponseEntity.ok().body(greet);
    }
}
