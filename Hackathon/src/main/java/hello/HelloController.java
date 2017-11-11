package hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/testAccounts")
    public String accounts() {
        String key = "?key=ed95127f97dc07879ad65c2d8d331501";
        String baseurl = "http://api.reimaginebanking.com/enterprise/accounts";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(baseurl+key, String.class);

        System.out.println(result);
        return result;
    }
}