package com.ecut.controllers;

import com.ecut.generated.tables.pojos.Author;
import com.ecut.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author Amy
 * @date 2019-07-04 18:33
 * @description:
 */
@Controller
@RequestMapping("/test")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping("/index")
    public ModelAndView findAuthorById(int id) {
        ModelAndView model = new ModelAndView("/test");
        Author author = authorService.findAuthorById(id);
        model.addObject("author", author);
        return model;
    }
}
