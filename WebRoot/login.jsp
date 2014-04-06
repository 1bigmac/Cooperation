<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.oa.model.User"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>" />
<title>项目管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="login_files/css.css" rel="stylesheet" type="text/css">
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tbody>
			<tr>
				<td height="147" background="login_files/top02.gif"><img
					src="login_files/top03.gif" width="776" height="147"></td>
			</tr>
		</tbody>
	</table>

	<table width="562" border="0" align="center" cellpadding="0"
		cellspacing="0" class="right-table03">
		<tbody>
			<tr>
				<td width="221">
					<table width="95%" border="0" cellpadding="0" cellspacing="0"
						class="login-text01">

						<tbody>
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="login-text01">
										<tbody>
											<tr>
												<td align="center"><img src="login_files/ico13.gif"
													width="107" height="97"></td>
											</tr>
											<tr>
												<td height="40" align="center">&nbsp;</td>
											</tr>

										</tbody>
									</table></td>
								<td><img src="login_files/line01.gif" width="5"
									height="292"></td>
							</tr>
						</tbody>
					</table></td>
				<td>
					<form action="UserAction!login" method="post">
						<table width="335" border="0" cellspacing="0" cellpadding="0"
							height="107">
							<tbody>
								<tr>
									<td width="31%" height="35" class="login-text02">用户名： <br>
									</td>
									<td width="69%"><input name="user.account" type="text">
									</td>
								</tr>
								<tr>
									<td height="35" class="login-text02">密 码： <br></td>
									<td><input name="user.password" type="password"></td>
								</tr>


								<tr>
									<td height="35">&nbsp;</td>
									<td><input name="Submit2" type="submit"
										class="right-button01" value="确认登陆"
										onClick="" /> <input
										name="Submit232" type="submit" class="right-button02"
										value="重 置" />
									</td>
									</td>
								</tr>
							</tbody>
						</table>
					</form></td>
			</tr>
		</tbody>
	</table>

</body>
</html>