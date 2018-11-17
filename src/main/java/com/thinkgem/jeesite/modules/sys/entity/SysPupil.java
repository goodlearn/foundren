/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 被监护人信息Entity
 * @author wzy
 * @version 2018-11-17
 */
public class SysPupil extends DataEntity<SysPupil> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String lostinfo;		// 丢失详情
	private String examinestate;		// 审核状态
	private String switchstate;		// 开关状态
	private String wxswitchstate;		// 微信开关状态
	
	public SysPupil() {
		super();
	}

	public SysPupil(String id){
		super(id);
	}

	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="丢失详情长度必须介于 0 和 255 之间")
	public String getLostinfo() {
		return lostinfo;
	}

	public void setLostinfo(String lostinfo) {
		this.lostinfo = lostinfo;
	}
	
	@Length(min=1, max=64, message="审核状态长度必须介于 1 和 64 之间")
	public String getExaminestate() {
		return examinestate;
	}

	public void setExaminestate(String examinestate) {
		this.examinestate = examinestate;
	}
	
	@Length(min=1, max=64, message="开关状态长度必须介于 1 和 64 之间")
	public String getSwitchstate() {
		return switchstate;
	}

	public void setSwitchstate(String switchstate) {
		this.switchstate = switchstate;
	}
	
	@Length(min=1, max=64, message="微信开关状态长度必须介于 1 和 64 之间")
	public String getWxswitchstate() {
		return wxswitchstate;
	}

	public void setWxswitchstate(String wxswitchstate) {
		this.wxswitchstate = wxswitchstate;
	}
	
}