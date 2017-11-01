package com.lord.advertis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lord.advertis.common.PageSize;
import com.lord.advertis.domain.Customers;
import com.lord.advertis.service.BrowseService;
import com.lord.advertis.service.CustomersService;
import com.lord.advertis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private BrowseService browseService;

    @GetMapping("/")
    public String index(Model model) {

        List<Customers> customersList = customersService.selectByLimit(0,4);

        model.addAttribute("customers", customersList);
        return "index";
    }
}
