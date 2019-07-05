package com.ecut.controllers;

import com.ecut.generated.tables.pojos.Author;
import com.ecut.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @RequestMapping("/addAuthor")
    public ModelAndView addAuthor(int id, String firstName, String lastName) {
        ModelAndView model = new ModelAndView("/add");
        Boolean result = authorService.insertAuthor(id, firstName, lastName);
        model.addObject("result", result);
        return model;
    }

    @RequestMapping("/deleteAuthor")
    public ModelAndView deleteAuthorById(int id) {
        ModelAndView model = new ModelAndView("/add");
        Boolean result = authorService.delete(id);
        model.addObject("result", result);
        return model;
    }

    @RequestMapping("/findAuthorById")
    public ModelAndView findAuthorById(int id) {
        ModelAndView model = new ModelAndView("/query");
        Author author = authorService.findAuthorById(id);
        model.addObject("author", author);
        return model;
    }


    @RequestMapping("/listAuthors")
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("/list");
        List<Author> authors = authorService.listAuthors();
        model.addObject("authors", authors);
        return model;
    }

}
