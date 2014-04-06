<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJdffsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table width="198" border="0" cellpadding="0" cellspacing="0"
		class="left-table01">
		<tr>
			<TD>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="207" height="55" background="images/nav01.gif">
							<table width="90%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="25%" rowspan="2"><img src="images/ico02.gif"
										width="35" height="35" />
									</td>
									<td width="75%" height="22" class="left-font01">
										您好，${admin.personid.name } <span class="left-font02"></span>
									</td>
								</tr>
								<tr>
									<td height="22" class="left-font01">[&nbsp; <a
										href="login.jsp" target="_top" class="left-font01">退出</a>&nbsp;]
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>

				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0"
					class="left-table03">
					<tr>
						<td>
						<s:iterator var="module" value="#session.modules">
								<s:property value="#module.name" /><br/>
								
								
									<s:iterator var="children" value="#module.modules">
										<br/>
										<s:property value="#children.name" />
									</s:iterator>
							</s:iterator></td>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="8%"><img name="img8" id="img8"
										src="images/ico04.gif" width="8" height="11" />
									</td>
									<td width="92%"><a href="javascript:" target="mainFrame"
										class="left-font03" onClick="list('8');">任务管理</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</TABLE>
				<table id="subtree8" style="DISPLAY: none" width="80%" border="0"
					align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<tr>
						<td width="9%" height="20"><img id="xiaotu20"
							src="images/ico06.gif" width="8" height="12" />
						</td>
						<td width="91%"><a href="addrenwu.jsp" target="mainFrame"
							class="left-font03" onClick="tupian('20');">创建任务</a>
						</td>
					</tr>
					<tr>
						<td width="9%" height="21"><img id="xiaotu21"
							src="images/ico06.gif" width="8" height="12" />
						</td>
						<td width="91%"><a href="listrenwu.jsp" target="mainFrame"
							class="left-font03" onClick="tupian('21');">任务信息查看</a>
						</td>
					</tr>
				</table> <!--  任务系统结束    --></TD>
		</tr>

	</table>
</body>
</html>