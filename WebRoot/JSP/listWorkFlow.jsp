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
<base target="_self" />
<title>My JSP 'WorkFlow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.tabfont01 {
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">
	
</script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
	function sousuo() {
		window
				.open(
						"gaojisousuo.jsp",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0,");
	}
		function showDialogForEdit(id){
			window.showModalDialog('EmployeeAction!updateEmployerDialog?employee.id='+id,'','dialogWidth=450px;dialogHeight=350px;');
	}
	function sou1(url) {
			 	window.showModalDialog(url,'','dialogWidth=450px;dialogHeight=350px;');
	 }
	function selectAll() {
		var obj = document.fom.elements;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				obj[i].checked = true;
			}
		}
	}

	function unselectAll() {
		var obj = document.fom.elements;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}

	function link() {
		document.getElementById("fom").action = "JSP/yuangong.jsp";
		document.getElementById("fom").submit();
	}

	function deleteChose() {
		document.getElementById("fom").action = "WorkFlowAction!deleteWorkFlow";
		document.getElementById("fom").submit();
	}
</SCRIPT>

</head>

<body class="ContentBody">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
				<form name="fom" id="fom" method="post" action="" target="mainFrame">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" background="images/nav04.gif">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="24"><img src="images/ico07.gif" width="20"
											height="18" /></td>
										<td width="519"><select name="select2">
												<option>按录入时间</option>
												<option>按注销时间</option>
										</select> <input name="textfield" type="text" size="12"
											readonly="readonly" /> <span class="newfont06">至</span> <input
											name="textfield" type="text" size="12" readonly="readonly" />
											<input name="Submit" type="button" class="right-button02"
											value="查 询" /></td>
										<td width="679" align="left"><a href="#"
											onclick="sousuo()"> <input name="Submit" type="button"
												class="right-button07" value="高级搜索" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
								</table></td>
						</tr>
					</table>
					<table id="subtree1" style="DISPLAY: " width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<table width="95%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="20"><span class="newfont07">选择：<a
												href="#" class="right-font08" onclick="selectAll();">全选</a>-<a
												href="#" class="right-font08" onclick="unselectAll();">反选</a>
										</span> 
										<input name="Submit" type="button" class="right-button08" value="删除所选流程信息" onclick="deleteChose();" /> 
										<input	name="Submit" type="button" class="right-button08" value="添加流程信息" onclick="window.location.href='JSP/submitDocument.jsp'" />
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">
												<tr>
													<td height="20" colspan="15" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title">
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														流程详细列表 &nbsp;</td>
												</tr>
												<tr>
													<td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
													<td width="9%" height="20" align="center" bgcolor="#EEEEEE">
														流程编号</td>
													<td width="18%" align="center" bgcolor="#EEEEEE">流程名称</td>
													<td width="18%" align="center" bgcolor="#EEEEEE">流程定义文件</td>
													<td width="15%" align="center" bgcolor="#EEEEEE">流程图片信息</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">操作</td>
												</tr>
												<s:iterator var="workflow" value="#request.workFlowLists">
													<tr>
														<td bgcolor="#FFFFFF"><input type="checkbox"
															name="delid" value="${workflow.id }" /></td>
														<td height="20" bgcolor="#FFFFFF"><a
															href="WorkFlowAction!edit?workFlow.id=${workflow.id }">${workflow.id
																}</a></td>
														<td bgcolor="#FFFFFF"><a
															href="WorkFlowAction!edit?workFlow.id=${workflow.id}">${workflow.name}
																|<s:property
																	value="#workflow.processDefinition.lastIndexOf('\\\\')" /></a>
														</td>
														<s:set var="num"
															value="#workflow.processDefinition.lastIndexOf('\\\\')" />
														<td bgcolor="#FFFFFF">
														<s:set var="process"	value="#workflow.processDefinition.substring((#num+1))" />
														<a href="javascript:window.showModalDialog('upload/${process}','','dialogWidth=800px;dialogHeight=500px;location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0;');">
														${process }</a>
														</td>
														<s:set var="number"
															value="#workflow.processDefinition.lastIndexOf('\\\\')" />
														<td bgcolor="#FFFFFF">
														<s:set var="image"	value="#workflow.processImage.substring((#num+1))" />
														<a href="javascript:window.showModalDialog('upload/${image}','','dialogWidth=800px;dialogHeight=500px;location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0;');">
															${image }
														</a>
														</td>

														<td bgcolor="#FFFFFF">
															 <a	href="JSP/submitDocument.jsp?id=${workflow.id}"
															>编辑(修改)</a>
															<a href="WorkFlowAction!deleteWorkFlow?delid=${workflow.id }">删除</a></td>
													</tr>
												</s:iterator>
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table>
				</form></td>
		</tr>
	</table>

	<table width="95%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<td height="33"><s:set var="pageCount"
				value="(#request.totalSize-1)/10+1" />
			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0" class="right-font08">
				<tr>
					<td width="50%">共 <span class="right-text09">${pageCount}</span>
						页 | 第 <span class="right-text09">${requestScope.currentIndex}</span>
						页</td>
					<td width="49%" align="right">[ <a
						href="WorkFlowActon!listWorkFlow?index=1" target="mainFrame"
						class="right-font08">首页</a> | <a
						href="WorkFlowAction!listWorkFlow?<s:if test='(#request.currentIndex-1)< 0'>index=1</s:if><s:else >index=${requestScope.currentIndex-1 }</s:else>"
						class="right-font08">上一页</a> | <s:if
							test='(#request.currentIndex+1)<=#pageCount'>
							<a
								href="WorkFlowAction!listWorkFlow?index=${requestScope.currentIndex+1 }"
								class="right-font08">下一页</a>
						</s:if> <s:else></s:else> | <a
						href="WorkFlowAction!listWorkFlow?index=${pageCount }"
						class="right-font08">末页</a>] 转至：</td>
					<td width="1%">
						<table width="20" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="1%"><input name="index" type="text"
									class="right-textfield03" size="1" /></td>
								<td width="87%"><input name="Submit23222" type="submit"
									class="right-button06" value=" " /></td>
							</tr>
						</table></td>
				</tr>
			</table></td>
	</table>
	<br>

</body>
</html>
