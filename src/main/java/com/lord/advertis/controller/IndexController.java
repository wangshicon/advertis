package com.lord.advertis.controller;

import com.lord.advertis.domain.*;
import com.lord.advertis.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *
 * 仪表盘数据
 * Created by on 2017/11/1.
 */
@Controller
public class IndexController {

    @Autowired
    private CustomersService customersService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttachmentService attachmentService;

    @GetMapping("/")
    public String index(Model model) {
        List<Module> moduleList = moduleService.findAll();
        List<Category> categoryList = categoryService.findAll();
        List<Attachment> attachmentList = attachmentService.selectByLimit(0, 8);
        model.addAttribute("home", moduleList.get(0));
        model.addAttribute("history", moduleList.get(1));
        model.addAttribute("service", moduleList.get(2));
        model.addAttribute("portfolio", moduleList.get(3));
        model.addAttribute("contact", moduleList.get(4));
        model.addAttribute("categorys", categoryList);
        model.addAttribute("attachments", attachmentList);
        return "index";
    }

    @GetMapping("/manager")
    public String manager(Model model){
        List<Customers> customersList = customersService.selectByLimit(0,4);
        List<Users> usersList = usersService.findAll();

        /*剩余统计图表展示模块*/
        model.addAttribute("customers", customersList);
        model.addAttribute("users", usersList);
        return "/manager/index";
    }
}
