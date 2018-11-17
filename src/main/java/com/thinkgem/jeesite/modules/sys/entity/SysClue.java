/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 线索表Entity
 * @author wzy
 * @version 2018-11-17
 */
public class SysClue extends DataEntity<SysClue> {
	
	private static final long serialVersionUID = 1L;
	private String pupilId;		// 被监护人编号
	
	public SysClue() {
		super();
	}

	public SysClue(String id){
		super(id);
	}

	@Length(min=1, max=64, message="被监护人编号长度必须介于 1 和 64 之间")
	public String getPupilId() {
		return pupilId;
	}

	public void setPupilId(String pupilId) {
		this.pupilId = pupilId;
	}
	
}