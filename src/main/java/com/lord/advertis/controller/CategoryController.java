package com.lord.advertis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.lord.advertis.common.PageSize;
import com.lord.advertis.common.ResultAjax;
import com.lord.advertis.domain.Category;
import com.lord.advertis.service.CategoryService;
import com.lord.advertis.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 *
 * 分类管理
 * Created by on 2017/10/31.
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	/**
	 * 
	 * @Title: findAll
	 * @Description: 分类列表 
	 * @param model
	 * @return
	 * @author Lord 
	 * @date 2017年6月1日 上午8:43:18
	 */
	@GetMapping(value="")
	public String findAll(Model model){
		Page<?> page = PageHelper.startPage(PageSize.ONE.getSize(), PageSize.TEN.getSize(), true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Category> list = categoryService.findAll();
		map.put("total", page.getTotal());
		map.put("list", list);
		model.addAttribute("categorys", map);
		return "category_list";
	}
	
	
	/**
	 * 
	 * @Title: categoryFindOne
	 * @Description: 查询分类详情
	 * @param id	主键id
	 * @return
	 * @author Lord 
	 * @date 2017年6月1日 上午8:44:33
	 */
	@GetMapping(value= "{id}")
	@ResponseBody
	public ResultAjax<Category> categoryFindOne(@PathVariable("id") Integer id){
		return ResultUtil.success(categoryService.findById(id));
	}
	
	/**
	 * 
	 * @Title: categoryAdd
	 * @Description: 新增分类信息
	 * @param category	分类信息实体
	 * @param bindingResult
	 * @return	
	 * @author Lord 
	 * @date 2017年6月1日 上午8:45:23
	 */
	@PostMapping(value="add")
	@ResponseBody
	public ResultAjax<Category> categoryAdd(Category category, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtil.success(categoryService.insert(category));
	}
	  
	/**
	 * 
	 * @Title: categoryUpdate
	 * @Description: 修改分类信息
	 * @param category	分类信息实体
	 * @param bindingResult
	 * @return
	 * @author Lord 
	 * @date 2017年6月1日 上午8:46:02
	 */
	@PutMapping(value="edit")
	@ResponseBody
	public ResultAjax<Category> categoryUpdate(@Valid Category category, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtil.error(-3, bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtil.success(categoryService.update(category));
	}
	
	/**
	 * 
	 * @Title: categoryDelete
	 * @Description: 删除分类信息
	 * @param id	主键id
	 * @return
	 * @author Lord 
	 * @date 2017年6月1日 上午8:46:36
	 */
	@DeleteMapping(value="/delete/{id}")
	@ResponseBody
	public ResultAjax<Category> categoryDelete(@PathVariable("id") Integer id){
		return ResultUtil.success(categoryService.delete(id));
	}
}
