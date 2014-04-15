<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" rev="stylesheet" href="css/style.css"
	type="text/css" media="all" />


<script type="text/javascript">
	function tishi() {
		var a = confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
		if (a != true)
			return false;
		window
				.open(
						"冲突页.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}

	function check() {
		document.getElementById("aa").style.display = "";
	}

	function go() {
		document.getElementById('form').action = "WorkFlowAction!addWorkFlow";
		document.getElementById('form').submit();
		window.self.close();
	}
</script>
</head>

<body class="ContentBody">

	<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr></tr>
		<tr align="center">
			<td class="TablePanel">添加公文</td>
		</tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
					<legend>公文信息</legend>
					<s:form action="DocumentAction!addDocument" method="post"
						enctype="multipart/form-data" id="form">
						<div class="MainDiv">
							<legend>请选中流程</legend>
						<s:iterator var="workflow" value="#request.workFlows">
								<input type="radio" name="workflowId" value="${workflow.id}">${ workflow.name}
						</s:iterator>
							<table width="99%" border="0" cellpadding="0" cellspacing="0"
								class="CContent">
								<tr>
									<td align="right" >公文名称:</td>
									<td >
										<input type="hidden" name="document.id" value="${document.id }" /> 
										<input name='document.title' type="text" class="text" style="width: 154px" value="${document.title}"/>
										 <span class="red">*</span>
									</td>
									<td align="right">公文描述:</td>
									<td>
									<input name='document.description' type="text" style="width: 154px" value="${document.description }">
									</td>
								</tr>
								<tr>
									<td align="right" >添加公文附件</td>
									<td >
										<input name="uploadFiles" type="file" />
									</td>
								</tr>
							</table>
							<div>
								<table align="center">
									<tr>
										<td><input type="submit" value="提交" onclick="">
										</td>
										<td><input type="button" value="返回"
											onclick="window.history.go(-1);">
										</td>
									</tr>
								</table>
							</div>
						</div>
					</s:form>
					<br />
				</fieldset>
			</TD>
		</TR>
	</TABLE>

</body>
</html>
