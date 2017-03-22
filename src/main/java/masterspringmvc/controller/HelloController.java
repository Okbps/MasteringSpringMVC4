package masterspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Aspire on 21.03.2017.
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public String Hello(){
        return "Hello world!";
    }
}
