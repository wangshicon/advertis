package com.lord.advertis.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lord.advertis.common.PageSize;
import com.lord.advertis.common.ResultAjax;
import com.lord.advertis.domain.Attachment;
import com.lord.advertis.domain.Category;
import com.lord.advertis.service.AttachmentService;
import com.lord.advertis.service.CategoryService;
import com.lord.advertis.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 附件管理
 * Created by on 2017/11/6.
 */
@Controller
@RequestMapping(value = "/manager/attachment")
public class AttachmentController {

	@Autowired
	private Environment environment;

	@Autowired
	private AttachmentService attachmentService;

	@Autowired
	private CategoryService categoryService;

	/**
	 * 
	 * @Title: findAll
	 * @Description: 附件列表
	 * @param model
	 * @return
	 * @author Lord 
	 * @date 2017年11月6日 上午9:46:18
	 */
	@GetMapping(value="")
	public String findAll(Model model){
		Page<?> page = PageHelper.startPage(PageSize.ONE.getSize(), PageSize.TEN.getSize(), true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Attachment> list = attachmentService.findAll();
		List<Category> categories = categoryService.findAll();
		map.put("total", page.getTotal());
		map.put("list", list);
		model.addAttribute("attachments", map);
		model.addAttribute("categorys", categories);
		model.addAttribute("cid", 0);
		return "manager/attachment_list";
	}

	/**
	 *
	 * @Title: findByCid
	 * @Description: 根据分类查询附件列表
	 * @param model
	 * @param cid 分类id
	 * @return
	 * @author Lord
	 * @date 2017年11月10日 上午9:46:18
	 */
	@GetMapping(value= "category/{cid}")
	public String findByCid(Model model, @PathVariable("cid") Integer cid){
		Page<?> page = PageHelper.startPage(PageSize.ONE.getSize(), PageSize.TEN.getSize(), true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Attachment> list = attachmentService.findByCategoryId(cid);
		List<Category> categories = categoryService.findAll();
		map.put("total", page.getTotal());
		map.put("list", list);
		model.addAttribute("attachments", map);
		model.addAttribute("categorys", categories);
		model.addAttribute("cid", cid);
		return "manager/attachment_list";
	}

	/**
	 *
	 * @Title: gallery
	 * @Description: 图片墙
	 * @param model
	 * @return
	 * @author Lord
	 * @date 2017年11月6日 上午9:51:18
	 */
	@GetMapping(value="gallery")
	public String gallery(Model model){
		Page<?> page = PageHelper.startPage(PageSize.ONE.getSize(), PageSize.TEN.getSize(), true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Attachment> list = attachmentService.findAll();
		map.put("total", page.getTotal());
		map.put("list", list);
		model.addAttribute("attachments", map);
		return "manager/gallery";
	}
	
	/**
	 * 
	 * @Title: attachmentFindOne
	 * @Description: 查询附件详情
	 * @param id	主键id
	 * @return
	 * @author Lord 
	 * @date 2017年11月6日 上午10:00:36
	 */
	@GetMapping(value= "{id}")
	@ResponseBody
	public ResultAjax<Attachment> attachmentFindOne(@PathVariable("id") Integer id){
		return ResultUtil.success(attachmentService.findById(id));
	}
	
	/**
	 * 
	 * @Title: attachmentAdd
	 * @Description: 新增附件信息
	 * @param files	 文件集合
	 * @param categoryId 分类id
	 * @return
	 * @author Lord 
	 * @date 2017年11月8日 上午11:24:36
	 */
	@PostMapping(value="upload")
	@ResponseBody
	public ResultAjax<Attachment> attachmentAdd(@RequestParam("fileList") MultipartFile[] files, @RequestParam("categoryId") Integer categoryId, HttpServletRequest request){
		String realPath = environment.getProperty("attach.realpath");	// 物理文件存储地址
		String filePath = environment.getProperty("attach.filepath");	// 附件访问地址
		if(attachmentService.uploadFile(files, categoryId, realPath, filePath) <= 0){
			return ResultUtil.error(-2, "上传失败！");
		}
		return ResultUtil.success();
	}
	  
	/**
	 * 
	 * @Title: attachmentUpdate
	 * @Description: 修改附件信息
	 * @param attachment	附件信息实体
	 * @param bindingResult
	 * @return
	 * @author Lord 
	 * @date 2017年11月6日 上午9:56:36
	 */
	@PutMapping(value="edit")
	@ResponseBody
	public ResultAjax<Attachment> attachmentUpdate(@Valid Attachment attachment, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return ResultUtil.error(-3, bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtil.success(attachmentService.update(attachment));
	}
	
	/**
	 * 
	 * @Title: attachmentDelete
	 * @Description: 删除附件信息
	 * @param id	主键id
	 * @return
	 * @author Lord 
	 * @date 2017年11月6日 上午9:55:36
	 */
	@DeleteMapping(value="delete/{id}")
	@ResponseBody
	public ResultAjax<Attachment> attachmentDelete(@PathVariable("id") Integer id){
		return ResultUtil.success(attachmentService.delete(id));
	}
}
