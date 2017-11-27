package com.lord.advertis.controller;

import com.lord.advertis.domain.*;
import com.lord.advertis.echarts.EchartsUtil;
import com.lord.advertis.enums.ReadStatus;
import com.lord.advertis.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.lord.advertis.consts.Brows.BROWS_AMOUNT;

/**
 *
 * 主页面视图控制器
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

    @Autowired
    private BrowseService browseService;

    /**
     *
     * @Title: index
     * @Description: 前台首页控制器
     * @return
     * @author Lord
     * @date 2017年11月17日 上午11:01:23
     */
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
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
        model.addAttribute("todayNum", BROWS_AMOUNT);
        session.setAttribute("isNew", session.isNew());
        return "index";
    }


    /**
     *
     * @Title: manager
     * @Description: 后台管理仪表盘控制器
     * @return
     * @author Lord
     * @date 2017年11月17日 上午11:04:23
     */
    @GetMapping("/manager")
    public String manager(Model model){
        Integer unreadTotal = customersService.findTotalByState(ReadStatus.Unread.getValue());
        System.out.println(unreadTotal);
        List<Customers> customersList = customersService.selectByLimit(0,3);
        List<Users> usersList = usersService.findAll();
        List<Browse> browseList = browseService.findWeekCount();

        model.addAttribute("todayNum", BROWS_AMOUNT);
        model.addAttribute("unreadNum", unreadTotal);
        model.addAttribute("customers", customersList);
        model.addAttribute("users", usersList);
        model.addAttribute("barData", EchartsUtil.dataToBarOption(browseList));
        return "/manager/index";
    }
}
