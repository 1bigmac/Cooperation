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

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>
<form method="post" action="DocumentAction!submit"  >
	<table align="center">
		<s:iterator var="transition" value="#request.transitionList"
			status="status">
			<tr>
				<td><input type="radio" name="transition" value="${transition }"/>${transition} ${id }</td>
			</tr>
		</s:iterator>
		
		<tr>
		<td>
		<input type="hidden" name="document.id" value="${id }"/>
		<input type="submit" value="提交"></input>
		<input type="button" value="返回" onclick="javascript:window.history.go(-1);"></input>
		</td>
		</tr>
	</table>
</form>
<body>
</body>
</html>
