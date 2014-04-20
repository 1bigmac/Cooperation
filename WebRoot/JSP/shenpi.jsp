<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>My JSP 'shenpi.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body><s:debug></s:debug>
	<form action="DocumentAction!approve">
		<table align="center">
			<tr>
				<td nowrap align="right" width="15%">审批意见${param.id }:</td>
				<td nowrap><input type="text" name="idea">
				
				</td>
				<td nowrap>是否回退</td>
				<td nowrap><input type="radio" name="back" value="1">是 <input
					type="radio" name="back" value="0" />否</td>
			</tr>
			<tr>
		
				<td>	</td>
				<td><input type="hidden" name="document.id" value="${param.id }"></td>
				<td><input type="submit" value="提交"> 
				<input type="button" value="返回"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>
