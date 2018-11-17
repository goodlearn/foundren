<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>被监护人信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/sysPupil/">被监护人信息列表</a></li>
		<shiro:hasPermission name="sys:sysPupil:edit"><li><a href="${ctx}/sys/sysPupil/form">被监护人信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysPupil" action="${ctx}/sys/sysPupil/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>审核状态：</label>
				<form:select path="examinestate" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('examineState')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>开关状态：</label>
				<form:select path="switchstate" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>微信开关：</label>
				<form:select path="wxswitchstate" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>更新时间</th>
				<th>描述信息</th>
				<th>审核状态</th>
				<th>开关状态</th>
				<th>微信开关状态</th>
				<shiro:hasPermission name="sys:sysPupil:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysPupil">
			<tr>
				<td><a href="${ctx}/sys/sysPupil/form?id=${sysPupil.id}">
					${sysPupil.name}
				</a></td>
				<td>
					<fmt:formatDate value="${sysPupil.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sysPupil.remarks}
				</td>
				<td>
					${fns:getDictLabel(sysPupil.examinestate, 'examineState', '')}
				</td>
				<td>
					${fns:getDictLabel(sysPupil.switchstate, 'yes_no', '')}
				</td>
				<td>
					${fns:getDictLabel(sysPupil.wxswitchstate, 'yes_no', '')}
				</td>
				<td>
					<shiro:hasPermission name="sys:sysKeeper:edit">
						 <a href="${ctx}/sys/sysKeeper/reqform?addPupilId=${sysPupil.id}">添加监护人</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="sys:sysPupil:edit">
    					<a href="${ctx}/sys/sysPupil/form?id=${sysPupil.id}">修改</a>
						<a href="${ctx}/sys/sysPupil/delete?id=${sysPupil.id}" onclick="return confirmx('确认要删除该被监护人信息吗？', this.href)">删除</a>
					</shiro:hasPermission>
				</td>
			
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>