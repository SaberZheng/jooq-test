package com.ecut.controllers;

import com.ecut.generated.tables.pojos.Author;
import com.ecut.services.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Amy
 * @date 2019-07-04 18:33
 * @description: 作者信息相关操作的controller
 * Api注解用在类上，说明该类的作用。
 * ApiOperation注解来给API增加方法说明。
 * ApiImplicitParams用在方法上包含一组参数说明。
 *      paramType：参数放在哪个地方
 *          header-->请求参数的获取：@RequestHeader
 *          query-->请求参数的获取：@RequestParam
 *          path（用于restful接口）-->请求参数的获取：@PathVariable
 *          body（不常用）
 *          form（不常用）
 *      name：参数名
 *      dataType：参数类型
 *      required：参数是否必须传
 *      value：参数的意思
 *      defaultValue：参数的默认值
 * ApiModel描述一个Model的信息（一般用在请求参数无法使用@ApiImplicitParam注解进行描述的时候）
 */
@Api(value = "AuthorController 操作作者信息的controller")
@Controller
@RequestMapping("/test")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/addAuthor")
    @ApiOperation(value = "增加作者", notes = "ID，名字，姓氏")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "作者ID", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "firstName", value = "名字", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "lastName", value = "姓氏", required = true, dataType = "String")
    })    public ModelAndView addAuthor(int id, String firstName, String lastName) {
        ModelAndView model = new ModelAndView("/add");
        Boolean result = authorService.insertAuthor(id, firstName, lastName);
        model.addObject("result", result);
        return model;
    }


    @RequestMapping("/deleteAuthor")
    @ApiOperation(value = "删除作者", notes = "根据ID删除作者")
    @ApiImplicitParam(paramType="query", name = "id", value = "作者ID", required = true, dataType = "int")
    public ModelAndView deleteAuthorById(int id) {
        ModelAndView model = new ModelAndView("/del");
        Boolean result = authorService.delete(id);
        model.addObject("result", result);
        return model;
    }

    @RequestMapping("/findAuthorById")
    @ApiOperation(value = "获取作者信息", notes = "根据ID获取作者信息")
    @ApiImplicitParam(paramType="query", name = "id", value = "作者ID", required = true, dataType = "int")
    public ModelAndView findAuthorById(int id) {
        ModelAndView model = new ModelAndView("/query");
        Author author = authorService.findAuthorById(id);
        model.addObject("author", author);
        return model;
    }


    @RequestMapping("/listAuthors")
    @ApiOperation(value = "获取所有作者信息", notes = "获取所有作者信息")
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("/list");
        List<Author> authors = authorService.listAuthors();
        model.addObject("authors", authors);
        return model;
    }

}
