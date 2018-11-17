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
import com.thinkgem.jeesite.modules.sys.entity.SysClue;
import com.thinkgem.jeesite.modules.sys.service.SysClueService;

/**
 * 线索表Controller
 * @author wzy
 * @version 2018-11-17
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysClue")
public class SysClueController extends BaseController {

	@Autowired
	private SysClueService sysClueService;
	
	@ModelAttribute
	public SysClue get(@RequestParam(required=false) String id) {
		SysClue entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysClueService.get(id);
		}
		if (entity == null){
			entity = new SysClue();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysClue:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysClue sysClue, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysClue> page = sysClueService.findPage(new Page<SysClue>(request, response), sysClue); 
		model.addAttribute("page", page);
		return "modules/sys/sysClueList";
	}

	@RequiresPermissions("sys:sysClue:view")
	@RequestMapping(value = "form")
	public String form(SysClue sysClue, Model model) {
		model.addAttribute("sysClue", sysClue);
		return "modules/sys/sysClueForm";
	}

	@RequiresPermissions("sys:sysClue:edit")
	@RequestMapping(value = "save")
	public String save(SysClue sysClue, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysClue)){
			return form(sysClue, model);
		}
		sysClueService.save(sysClue);
		addMessage(redirectAttributes, "保存线索表成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysClue/?repage";
	}
	
	@RequiresPermissions("sys:sysClue:edit")
	@RequestMapping(value = "delete")
	public String delete(SysClue sysClue, RedirectAttributes redirectAttributes) {
		sysClueService.delete(sysClue);
		addMessage(redirectAttributes, "删除线索表成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysClue/?repage";
	}

}