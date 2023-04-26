package com.uniovi.sdi.controller;

import com.uniovi.sdi.services.MarksSoapService;
import com.uniovi.sdi.wsdl.Mark;
import com.uniovi.sdi.wsdl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MarksController {
    @Autowired
    private MarksSoapService marksSoapService;

    @RequestMapping("/marks/list")
    public String getMarks(Model model, @RequestParam String dni) {
        List<Mark> marks = new ArrayList<>();
        User user = marksSoapService.getMarks(dni).getUser();
        if (user != null) {
            marks = user.getMark();
        }
        model.addAttribute("dni", dni);
        model.addAttribute("markList", marks);
        return "list";
    }
}