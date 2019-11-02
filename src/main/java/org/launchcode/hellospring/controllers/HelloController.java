package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller

public class HelloController {
    @RequestMapping(value="")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name==null) {
            name = "World";
        }
        return "Hello " + name;
    }
    @RequestMapping(value= "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Say my Name, Say my Name'/>" +
                "</form>";
        return html;
    }
//    this is what is handling the post request. The one above it, helloForm is setting up the post request
    @RequestMapping(value= "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");

        return "Hello " + name;
    }

@RequestMapping(value = "hello/{name}")
@ResponseBody
public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;

}

    @RequestMapping(value="goodbye")
    public String goodbye() {
        return "redirect:/";
    }
}
