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
import com.thinkgem.jeesite.modules.sys.entity.SysWxVisitor;
import com.thinkgem.jeesite.modules.sys.service.SysWxVisitorService;

/**
 * 游客信息Controller
 * @author wzy
 * @version 2018-11-17
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysWxVisitor")
public class SysWxVisitorController extends BaseController {

	@Autowired
	private SysWxVisitorService sysWxVisitorService;
	
	@ModelAttribute
	public SysWxVisitor get(@RequestParam(required=false) String id) {
		SysWxVisitor entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysWxVisitorService.get(id);
		}
		if (entity == null){
			entity = new SysWxVisitor();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysWxVisitor:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysWxVisitor sysWxVisitor, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysWxVisitor> page = sysWxVisitorService.findPage(new Page<SysWxVisitor>(request, response), sysWxVisitor); 
		model.addAttribute("page", page);
		return "modules/sys/sysWxVisitorList";
	}

	@RequiresPermissions("sys:sysWxVisitor:view")
	@RequestMapping(value = "form")
	public String form(SysWxVisitor sysWxVisitor, Model model) {
		model.addAttribute("sysWxVisitor", sysWxVisitor);
		return "modules/sys/sysWxVisitorForm";
	}

	@RequiresPermissions("sys:sysWxVisitor:edit")
	@RequestMapping(value = "save")
	public String save(SysWxVisitor sysWxVisitor, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysWxVisitor)){
			return form(sysWxVisitor, model);
		}
		sysWxVisitorService.save(sysWxVisitor);
		addMessage(redirectAttributes, "保存游客信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysWxVisitor/?repage";
	}
	
	@RequiresPermissions("sys:sysWxVisitor:edit")
	@RequestMapping(value = "delete")
	public String delete(SysWxVisitor sysWxVisitor, RedirectAttributes redirectAttributes) {
		sysWxVisitorService.delete(sysWxVisitor);
		addMessage(redirectAttributes, "删除游客信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysWxVisitor/?repage";
	}

}