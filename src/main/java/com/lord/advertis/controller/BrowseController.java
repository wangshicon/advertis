package com.lord.advertis.controller;

import com.lord.advertis.common.ResultAjax;
import com.lord.advertis.domain.Browse;
import com.lord.advertis.utils.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.lord.advertis.consts.Brows.BROWS_AMOUNT;

/**
 *
 * 浏览量统计
 * Created by on 2017/11/17.
 */
@Controller
@RequestMapping(value = "/manager/browse")
public class BrowseController {

    /**
     *
     * @Title: browseAdd
     * @Description: 新增浏览量
     * @param browse	访问量统计实体
     * @return
     * @author Lord
     * @date 2017年11月17日 上午11:01:23
     */
    @PostMapping(value="add")
    @ResponseBody
    public ResultAjax<Browse> browseAdd(Browse browse){
        Integer todayNum = browse.getNumber();
        todayNum++;
        BROWS_AMOUNT = todayNum;
        return ResultUtil.success();
    }

}
