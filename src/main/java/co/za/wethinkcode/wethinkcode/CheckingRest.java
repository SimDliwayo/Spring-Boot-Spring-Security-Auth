package co.za.wethinkcode.wethinkcode;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckingRest {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome Home Sim";
    }
}
