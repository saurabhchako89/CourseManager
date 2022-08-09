package com.poc.learnspringboot.courses.controller;

import com.poc.learnspringboot.courses.model.Course;
import com.poc.learnspringboot.courses.model.User;
import com.poc.learnspringboot.courses.service.CourseService;
import com.poc.learnspringboot.courses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseManagerController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listCourses", courseService.listAll());
        model.addAttribute("users", userService.listAll());
        return "index";
    }

    @RequestMapping("/newCourse")
    public String showNewCoursePage(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);

        return "new_course";
    }

    @RequestMapping("/newUser")
    public String showNewUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "new_user";
    }

    @RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);

        return "redirect:/";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/";
    }

    @RequestMapping("/updateCourse/{id}")
    public ModelAndView updateCourse(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("update_course");
        Course course = courseService.get(id);
        mav.addObject("course", course);

        return mav;
    }

    @RequestMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable(name = "id") int id) {
        courseService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/updateUser/{id}")
    public ModelAndView updateUser(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("update_user");
        User user = userService.get(id);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
