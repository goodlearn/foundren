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
import com.thinkgem.jeesite.modules.sys.entity.SysKeeper;
import com.thinkgem.jeesite.modules.sys.service.SysKeeperService;

/**
 * 监护人信息Controller
 * @author wzy
 * @version 2018-11-17
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysKeeper")
public class SysKeeperController extends BaseController {

	@Autowired
	private SysKeeperService sysKeeperService;
	
	@ModelAttribute
	public SysKeeper get(@RequestParam(required=false) String id) {
		SysKeeper entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysKeeperService.get(id);
		}
		if (entity == null){
			entity = new SysKeeper();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysKeeper:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysKeeper sysKeeper, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysKeeper> page = sysKeeperService.findPage(new Page<SysKeeper>(request, response), sysKeeper); 
		model.addAttribute("page", page);
		return "modules/sys/sysKeeperList";
	}
	
	@RequiresPermissions("sys:sysKeeper:view")
	@RequestMapping(value = "reqform")
	public String reqform(SysKeeper sysKeeper, HttpServletRequest request,Model model) {
		String addPupilId = request.getParameter("addPupilId");
		sysKeeper.setPupilId(addPupilId);
		model.addAttribute("sysKeeper", sysKeeper);
		return "modules/sys/sysAddKeeperForm";
	}

	@RequiresPermissions("sys:sysKeeper:view")
	@RequestMapping(value = "form")
	public String form(SysKeeper sysKeeper, Model model) {
		model.addAttribute("sysKeeper", sysKeeper);
		return "modules/sys/sysKeeperForm";
	}

	@RequiresPermissions("sys:sysKeeper:edit")
	@RequestMapping(value = "save")
	public String save(SysKeeper sysKeeper, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysKeeper)){
			return form(sysKeeper, model);
		}
		sysKeeperService.save(sysKeeper);
		addMessage(redirectAttributes, "保存监护人信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysKeeper/?repage";
	}
	
	@RequiresPermissions("sys:sysKeeper:edit")
	@RequestMapping(value = "delete")
	public String delete(SysKeeper sysKeeper, RedirectAttributes redirectAttributes) {
		sysKeeperService.delete(sysKeeper);
		addMessage(redirectAttributes, "删除监护人信息成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysKeeper/?repage";
	}

}