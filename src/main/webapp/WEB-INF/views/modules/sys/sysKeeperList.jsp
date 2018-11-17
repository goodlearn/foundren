<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>监护人信息管理</title>
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
		<li class="active"><a href="${ctx}/sys/sysKeeper/">监护人信息列表</a></li>
<%-- 		<shiro:hasPermission name="sys:sysKeeper:edit"><li><a href="${ctx}/sys/sysKeeper/form">监护人信息添加</a></li></shiro:hasPermission>--%>
 	</ul>
	<form:form id="searchForm" modelAttribute="sysKeeper" action="${ctx}/sys/sysKeeper/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>电话：</label>
				<form:input path="phone" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>被监护人：</label>
				<form:input path="pupilId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>电话</th>
				<th>被监护人姓名</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sys:sysKeeper:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysKeeper">
			<tr>
				<td><a href="${ctx}/sys/sysKeeper/form?id=${sysKeeper.id}">
					${sysKeeper.name}
				</a></td>
				<td>
					${sysKeeper.phone}
				</td>
				<td>
					${sysKeeper.sysPupil.name}
				</td>
				<td><a href="${ctx}/sys/sysKeeper/form?id=${sysKeeper.id}">
					<fmt:formatDate value="${sysKeeper.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${sysKeeper.remarks}
				</td>
				<shiro:hasPermission name="sys:sysKeeper:edit"><td>
    				<a href="${ctx}/sys/sysKeeper/form?id=${sysKeeper.id}">修改</a>
					<a href="${ctx}/sys/sysKeeper/delete?id=${sysKeeper.id}" onclick="return confirmx('确认要删除该监护人信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>