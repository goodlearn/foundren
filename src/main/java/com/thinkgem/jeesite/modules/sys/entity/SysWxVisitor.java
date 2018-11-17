/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 游客信息Entity
 * @author wzy
 * @version 2018-11-17
 */
public class SysWxVisitor extends DataEntity<SysWxVisitor> {
	
	private static final long serialVersionUID = 1L;
	private String openId;		// 微信关联号
	private String name;		// 姓名
	private String phone;		// 电话
	private Date loginDate;		// 登录时间
	private String nickname;		// 微信名字
	private String sex;		// 性别
	private String headimgurl;		// 头像
	private Date beginLoginDate;		// 开始 登录时间
	private Date endLoginDate;		// 结束 登录时间
	
	public SysWxVisitor() {
		super();
	}

	public SysWxVisitor(String id){
		super(id);
	}

	@Length(min=0, max=100, message="微信关联号长度必须介于 0 和 100 之间")
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	@Length(min=0, max=64, message="姓名长度必须介于 0 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=64, message="电话长度必须介于 0 和 64 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	@Length(min=0, max=200, message="微信名字长度必须介于 0 和 200 之间")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Length(min=0, max=100, message="性别长度必须介于 0 和 100 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=200, message="头像长度必须介于 0 和 200 之间")
	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	
	public Date getBeginLoginDate() {
		return beginLoginDate;
	}

	public void setBeginLoginDate(Date beginLoginDate) {
		this.beginLoginDate = beginLoginDate;
	}
	
	public Date getEndLoginDate() {
		return endLoginDate;
	}

	public void setEndLoginDate(Date endLoginDate) {
		this.endLoginDate = endLoginDate;
	}
		
}