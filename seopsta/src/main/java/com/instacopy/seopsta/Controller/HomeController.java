package com.instacopy.seopsta.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@Controller
public class HomeController {
//    @GetMapping("/")
//    public String home(@RequestParam(name="name", required = false, defaultValue = "YuInseop")String name, Model model){
//        model.addAttribute("name", name);
//        return "index";
//    }
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/getauth")
    public @ResponseBody String auth(HttpServletRequest req){
        return req.getSession().getAttribute("token").toString();
    }
}
