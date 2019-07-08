package com.ecut.test.controllers;

import com.ecut.test.generated.tables.pojos.Author;
import com.ecut.test.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Amy
 * @date 2019-07-04 18:33
 * @description: 作者信息相关操作的controller
 */
@Controller
@RequestMapping("/test")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/author",method = RequestMethod.POST)
    public ModelAndView addAuthor(int id, String firstName, String lastName) {
        ModelAndView model = new ModelAndView("/add");
        Boolean result  = authorService.insertAuthor(id,firstName,lastName);
        model.addObject("result", result);
        return model;
    }

    @RequestMapping(value = "/author_id",method = RequestMethod.DELETE)
    public ModelAndView deleteAuthorById(int id) {
        ModelAndView model = new ModelAndView("/add");
        Boolean result  = authorService.delete(id);
        model.addObject("result", result);
        return model;
    }

    @RequestMapping(value = "/author_id" ,method = RequestMethod.GET)
    public ModelAndView findAuthorById(int id) {
        ModelAndView model = new ModelAndView("/query");
        Author author = authorService.findAuthorById(id);
        model.addObject("author", author);
        return model;
    }


    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("/list");
        List<Author> authors = authorService.listAuthors();
        model.addObject("authors", authors);
        return model;
    }

}
