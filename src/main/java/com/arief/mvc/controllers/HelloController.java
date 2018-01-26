package com.arief.mvc.controllers;

import com.arief.mvc.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.support.SessionFlashMapManager;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/three")
    public RedirectView viewThree(WebRequest webRequest){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(webRequest.getContextPath());
        return redirectView;
    }


    @ModelAttribute(value = "arief")
    public Person person(){
        Person p = new Person();
        p.setId(1);
        p.setName("Arief");

        return p;
    }


    @RequestMapping("/jsp-two")
    public String jspTwo(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("redirect","this is redirect attributes");
        return "redirect:/mvc/four";
    }

    @RequestMapping("/four")
    public String viewFour(Model model,@RequestParam("redirect")String s){
        model.addAttribute("val",s);
        return "pages/four";
    }

    @RequestMapping("/two")
    public View viewTwo(){
        View view = new View() {
            public String getContentType() {
                return "text/html";
            }

            public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
                httpServletResponse.getWriter().write("<h1>Hello World</h1>");
            }
        };
        return view;
    }


    @RequestMapping("/one")
    public ModelAndView viewOne(WebRequest webRequest){
        ModelAndView mav = new ModelAndView();
        mav.addObject("contextPath",webRequest.getContextPath());
        mav.setViewName("pages/one");
        return mav;
    }
}
