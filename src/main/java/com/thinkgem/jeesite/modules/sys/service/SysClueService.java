/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.SysClue;
import com.thinkgem.jeesite.modules.sys.dao.SysClueDao;

/**
 * 线索表Service
 * @author wzy
 * @version 2018-11-17
 */
@Service
@Transactional(readOnly = true)
public class SysClueService extends CrudService<SysClueDao, SysClue> {

	public SysClue get(String id) {
		return super.get(id);
	}
	
	public List<SysClue> findList(SysClue sysClue) {
		return super.findList(sysClue);
	}
	
	public Page<SysClue> findPage(Page<SysClue> page, SysClue sysClue) {
		return super.findPage(page, sysClue);
	}
	
	@Transactional(readOnly = false)
	public void save(SysClue sysClue) {
		super.save(sysClue);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysClue sysClue) {
		super.delete(sysClue);
	}
	
}