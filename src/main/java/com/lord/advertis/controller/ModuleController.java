package com.lord.advertis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lord.advertis.common.PageSize;
import com.lord.advertis.common.ResultAjax;
import com.lord.advertis.domain.Category;
import com.lord.advertis.domain.Module;
import com.lord.advertis.service.CategoryService;
import com.lord.advertis.service.ModuleService;
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
 * 模块管理
 * Created by on 2017/10/31.
 */
@Controller
@RequestMapping(value = "/module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;

	/**
	 * 
	 * @Title: findAll
	 * @Description: 模块列表
	 * @param model
	 * @return
	 * @author Lord 
	 * @date 2017年6月1日 上午8:43:18
	 */
	@GetMapping(value="")
	public String findAll(Model model){
		Page<?> page = PageHelper.startPage(PageSize.ONE.getSize(), PageSize.TEN.getSize(), true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Module> list = moduleService.findAll();
		map.put("total", page.getTotal());
		map.put("list", list);
		model.addAttribute("moudles", map);
		return "module_list";
	}
	
	
	/**
	 * 
	 * @Title: categoryFindOne
	 * @Description: 查询模块详情
	 * @param id	主键id
	 * @return
	 * @author Lord 
	 * @date 2017年6月1日 上午8:44:33
	 */
	@GetMapping(value= "{id}")
	@ResponseBody
	public ResultAjax<Module> moduleFindOne(@PathVariable("id") Integer id){
		return ResultUtil.success(moduleService.findById(id));
	}
	
	/**
	 * 
	 * @Title: moduleAdd
	 * @Description: 新增模块信息
	 * @param module	模块信息实体
	 * @param bindingResult
	 * @return	
	 * @author Lord 
	 * @date 2017年6月1日 上午8:45:23
	 */
	@PostMapping(value="add")
	@ResponseBody
	public ResultAjax<Module> moduleAdd(Module module, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtil.success(moduleService.insert(module));
	}
	  
	/**
	 * 
	 * @Title: categoryUpdate
	 * @Description: 修改模块信息
	 * @param module	模块信息实体
	 * @param bindingResult
	 * @return
	 * @author Lord 
	 * @date 2017年6月1日 上午8:46:02
	 */
	@PutMapping(value="edit")
	@ResponseBody
	public ResultAjax<Module> moduleUpdate(@Valid Module module, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtil.error(-3, bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtil.success(moduleService.update(module));
	}
	
	/**
	 * 
	 * @Title: categoryDelete
	 * @Description: 删除模块信息
	 * @param id	主键id
	 * @return
	 * @author Lord 
	 * @date 2017年6月1日 上午8:46:36
	 */
	@DeleteMapping(value="delete/{id}")
	@ResponseBody
	public ResultAjax<Module> moduleDelete(@PathVariable("id") Integer id){
		return ResultUtil.success(moduleService.delete(id));
	}
}
