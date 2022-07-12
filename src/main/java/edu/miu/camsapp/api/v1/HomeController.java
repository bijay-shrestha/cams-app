package edu.miu.camsapp.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
@Controller
public class HomeController {

    @GetMapping(value = {"", "/", "/spebank/home"})
    public String displayHomePage(){
        return "public/home";
    }
}
