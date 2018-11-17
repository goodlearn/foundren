/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.SysKeeper;
import com.thinkgem.jeesite.modules.sys.dao.SysKeeperDao;

/**
 * 监护人信息Service
 * @author wzy
 * @version 2018-11-17
 */
@Service
@Transactional(readOnly = true)
public class SysKeeperService extends CrudService<SysKeeperDao, SysKeeper> {

	public SysKeeper get(String id) {
		return super.get(id);
	}
	
	public List<SysKeeper> findList(SysKeeper sysKeeper) {
		return super.findList(sysKeeper);
	}
	
	public Page<SysKeeper> findPage(Page<SysKeeper> page, SysKeeper sysKeeper) {
		return super.findPage(page, sysKeeper);
	}
	
	@Transactional(readOnly = false)
	public void save(SysKeeper sysKeeper) {
		super.save(sysKeeper);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysKeeper sysKeeper) {
		super.delete(sysKeeper);
	}
	
}