/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.SysWxVisitor;
import com.thinkgem.jeesite.modules.sys.dao.SysWxVisitorDao;

/**
 * 游客信息Service
 * @author wzy
 * @version 2018-11-17
 */
@Service
@Transactional(readOnly = true)
public class SysWxVisitorService extends CrudService<SysWxVisitorDao, SysWxVisitor> {

	public SysWxVisitor get(String id) {
		return super.get(id);
	}
	
	public List<SysWxVisitor> findList(SysWxVisitor sysWxVisitor) {
		return super.findList(sysWxVisitor);
	}
	
	public Page<SysWxVisitor> findPage(Page<SysWxVisitor> page, SysWxVisitor sysWxVisitor) {
		return super.findPage(page, sysWxVisitor);
	}
	
	@Transactional(readOnly = false)
	public void save(SysWxVisitor sysWxVisitor) {
		super.save(sysWxVisitor);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysWxVisitor sysWxVisitor) {
		super.delete(sysWxVisitor);
	}
	
}