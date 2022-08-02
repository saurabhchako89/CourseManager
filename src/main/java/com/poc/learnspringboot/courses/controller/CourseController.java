package com.poc.learnspringboot.courses.controller;

import com.poc.learnspringboot.courses.model.Course;
import com.poc.learnspringboot.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Course> listCourses = service.listAll();
        model.addAttribute("listCourses", listCourses);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewCoursePage(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);

        return "new_course";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("course") Course course) {
        service.save(course);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCoursePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_course");
        Course course = service.get(id);
        mav.addObject("course", course);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCourse(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
