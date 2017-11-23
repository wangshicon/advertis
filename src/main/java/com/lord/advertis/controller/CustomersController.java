package com.lord.advertis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lord.advertis.common.PageSize;
import com.lord.advertis.common.ResultAjax;
import com.lord.advertis.domain.Customers;
import com.lord.advertis.service.CustomersService;
import com.lord.advertis.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 客户意向管理
 * Created by on 2017/11/3.
 */
@Controller
@RequestMapping(value = "/manager/customers")
public class CustomersController {
	
	@Autowired
	private CustomersService customersService;

	/**
	 * 
	 * @Title: findAll
	 * @Description: 客户意向管列表
	 * @param model
	 * @return
	 * @author Lord 
	 * @date 2017年11月3日 上午11:26:18
	 */
	@GetMapping(value="")
	public String findAll(Model model){
		Page<?> page = PageHelper.startPage(PageSize.ONE.getSize(), PageSize.TEN.getSize(), true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Customers> list = customersService.findAll();
		map.put("total", page.getTotal());
		map.put("list", list);
		model.addAttribute("customers", map);
        model.addAttribute("page", PageSize.ONE.getSize());
		return "manager/customers_list";
	}

    /**
     *
     * @Title: findPage
     * @Description: 客户意向管列表分页
     * @param model
     * @param pageNum 当前页码
     * @return
     * @author Lord
     * @date 2017年11月3日 上午11:26:18
     */
    @GetMapping(value="page")
    public String findPage(Integer pageNum, Model model) {
        Page<?> page = PageHelper.startPage(pageNum, PageSize.TEN.getSize(), true);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Customers> list = customersService.findAll();
        map.put("total", page.getTotal());
        map.put("list", list);
        model.addAttribute("customers", map);
        model.addAttribute("page", pageNum);
        return "manager/customers_list";
    }

	/**
	 * 
	 * @Title: customersFindOne
	 * @Description: 查询客户意向详情
	 * @param id	主键id
	 * @return
	 * @author Lord 
	 * @date 2017年11月3日 上午11:26:18
	 */
	@GetMapping(value= "{id}")
	@ResponseBody
	public ResultAjax<Customers> customerFindOne(@PathVariable("id") Integer id){
		return ResultUtil.success(customersService.findById(id));
	}
	
	/**
	 * 
	 * @Title: customersAdd
	 * @Description: 新增客户意向信息
	 * @param customers	客户意向信息实体
	 * @param bindingResult
	 * @return	
	 * @author Lord 
	 * @date 2017年11月3日 上午11:26:18
	 */
	@PostMapping(value="add")
	@ResponseBody
	public ResultAjax<Customers> customerAdd(Customers customers, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtil.success(customersService.insert(customers));
	}
	  
	/**
	 * 
	 * @Title: categoryUpdate
	 * @Description: 修改客户意向信息
	 * @param customers	客户意向信息实体
	 * @param bindingResult
	 * @return
	 * @author Lord 
	 * @date 2017年11月3日 上午11:26:18
	 */
	@PutMapping(value="edit")
	@ResponseBody
	public ResultAjax<Customers> customerUpdate(@Valid Customers customers, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtil.error(-3, bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtil.success(customersService.update(customers));
	}
	
	/**
	 * 
	 * @Title: customersDelete
	 * @Description: 删除客户意向信息
	 * @param id	主键id
	 * @return
	 * @author Lord 
	 * @date 2017年11月3日 上午11:26:18
	 */
	@DeleteMapping(value="/delete/{id}")
	@ResponseBody
	public ResultAjax<Customers> customersDelete(@PathVariable("id") Integer id){
		return ResultUtil.success(customersService.delete(id));
	}
}
