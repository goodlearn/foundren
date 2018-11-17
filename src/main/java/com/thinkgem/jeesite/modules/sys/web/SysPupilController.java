/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.SysPupil;
import com.thinkgem.jeesite.modules.sys.service.SysPupilService;

/**
 * 被监护人信息Controller
 * @author wzy
 * @version 2018-11-17
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysPupil")
public class SysPupilController extends BaseController {

	@Autowired
	private SysPupilService sysPupilService;
	
	@ModelAttribute
	public SysPupil get(@RequestParam(required=false) String id) {
		SysPupil entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysPupilService.get(id);
		}
		if (entity == null){
			entity = new SysPupil();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysPupil:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysPupil sysPupil, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysPupil> page = sysPupilService.findPage(new Page<SysPupil>(request, response), sysPupil); 
		model.addAttribute("page", page);
		return "modules/sys/sysPupilList";
	}

	@RequiresPermissions("sys:sysPupil:view")
	@RequestMapping(value = "form")
	public String form(SysPupil sysPupil, Model model) {
		model.addAttribute("sysPupil", sysPupil);
		return "modules/sys/sysPupilForm";
	}

	@RequiresPermissions("sys:sysPupil:edit")
	@RequestMapping(value = "save")
	public String save(SysPupil sysPupil, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysPupil)){
			return form(sysPupil, model);
		}
		sysPupilService.save(sysPupil);
		addMessage(redirectAttributes, "保存被监护人信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysPupil/?repage";
	}
	
	@RequiresPermissions("sys:sysPupil:edit")
	@RequestMapping(value = "delete")
	public String delete(SysPupil sysPupil, RedirectAttributes redirectAttributes) {
		sysPupilService.delete(sysPupil);
		addMessage(redirectAttributes, "删除被监护人信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysPupil/?repage";
	}

}