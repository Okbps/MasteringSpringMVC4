package masterSpringMvc.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Aspire on 02.04.2017.
 */
@Controller
public class LoginController {
    @RequestMapping( "/login")
    public String authenticate(){
        return "login";
    }
}
