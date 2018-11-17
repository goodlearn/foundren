/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.entity.SysPupil;
import com.thinkgem.jeesite.modules.sys.dao.SysPupilDao;

/**
 * 被监护人信息Service
 * @author wzy
 * @version 2018-11-17
 */
@Service
@Transactional(readOnly = true)
public class SysPupilService extends CrudService<SysPupilDao, SysPupil> {

	public SysPupil get(String id) {
		return super.get(id);
	}
	
	public List<SysPupil> findList(SysPupil sysPupil) {
		return super.findList(sysPupil);
	}
	
	public Page<SysPupil> findPage(Page<SysPupil> page, SysPupil sysPupil) {
		return super.findPage(page, sysPupil);
	}
	
	@Transactional(readOnly = false)
	public void save(SysPupil sysPupil) {
		super.save(sysPupil);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysPupil sysPupil) {
		super.delete(sysPupil);
	}
	
}