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
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
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
		document.getElementById("fom").action = "DocumentAction!toAddDocumentView";
		document.getElementById("fom").submit();
	}

	function deleteChose() {
		document.getElementById("fom").action = "DocumentAction!deleteDocument";
		document.getElementById("fom").submit();
	}
</SCRIPT>

</head>

<body class="ContentBody">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
				<form name="fom" id="fom" method="post" action="">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" background="images/nav04.gif">

								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="24"><img src="images/ico07.gif" width="20"
											height="18" />
										</td>
										<td width="519"><select name="select2">
												<option>按录入时间</option>
												<option>按注销时间</option>
										</select> <input name="textfield" type="text" size="12"
											readonly="readonly" /> <span class="newfont06">至</span> <input
											name="textfield" type="text" size="12" readonly="readonly" />
											<input name="Submit" type="button" class="right-button02"
											value="查 询" />
										</td>
										<td width="679" align="left"><a href="#"
											onclick="sousuo()"> <input name="Submit" type="button"
												class="right-button07" value="高级搜索" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
								</table>
							</td>
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
										</span> <input name="Submit" type="button" class="right-button08"
											value="删除所选公文信息" onclick="deleteChose();" /> <input
											name="Submit" type="button" class="right-button08"
											value="添加公文信息" onclick="link();" />
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input name="Submit" type="button" class="right-button08"
											value="我的公文"
											onclick="javascript:window.location.href='DocumentAction!listMyDocument';" />
											<input name="Submit" type="button" class="right-button08"
											value="待审公文"
											onclick="javascript:window.location.href='DocumentAction!ApprovingDocumentList;'" />
											<input name="Submit" type="button" class="right-button08"
											value="已审核公文"
											onclick="javascript:window.location.href='DocumentAction!ApprovedDocumentList'" />
										</td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" class="newfont03">

												<tr>
													<td height="20" colspan="15" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title">
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														公文详细列表 &nbsp;</td>
												</tr>
												<tr>
													<td width="6%" align="center" bgcolor="#EEEEEE">选择</td>
													<td width="9%" height="20" align="center" bgcolor="#EEEEEE">
														公文编号</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">公文标题</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">创建时间</td>
													<td width="9%" align="center" bgcolor="#EEEEEE">公文状态</td>

													<td width="10%" align="center" bgcolor="#EEEEEE">流程名称</td>
													<td width="20%" align="center" bgcolor="#EEEEEE">附件</td>
													<td width="10%" align="center" bgcolor="#EEEEEE">审批历史
													</td>

													<td width="25%" align="center" bgcolor="#EEEEEE">操作</td>
												</tr>
												<s:iterator var="document" value="#request.myDocumentList">
													<tr>
														<td bgcolor="#FFFFFF"  align="center"><input type="checkbox"
															name="delid" value="${document.id }" />
														</td>
														<td height="20" bgcolor="#FFFFFF"  align="center">${document.id}
														</td>
														<td bgcolor="#FFFFFF"  align="center">
														${document.title}
														</td>
														<td bgcolor="#FFFFFF"  align="center">${document.createTime }</td>
														<td bgcolor="#FFFFFF"  align="center">${document.status }</td>
														<td height="20" bgcolor="#FFFFFF"  align="center">${document.workFlow.name}</td>

														<s:set var="num" value="#document.doc.lastIndexOf('\\\\')" />
														<s:set var="doc" value="#document.doc.substring((#num+1))" />
														<td height="20" bgcolor="#FFFFFF"  align="center">
														<a href="DocumentAction!download?document.doc=${document.doc }">
														${doc}
														</a>
														</td>
														<td height="20" bgcolor="#FFFFFF"  align="center"><a
															href="DocumentAction!approveHistoryList?document.id=${document.id }">查看</a>
														</td>
														<td bgcolor="#FFFFFF" align="center"> 
															<s:if test="#request.type=='document'">
																	&nbsp;|&nbsp;
																	<s:if test="#document.status=='新建'">
																	<a href="DocumentAction!edit?document.id=${document.id }">编辑	</a> 
																	<a href="javascript:window.location.href='DocumentAction!submitView?document.id=${document.id }'">提交</a>&nbsp;|&nbsp;
																	<a href="DocumentAction!deleteDocument?delid=${document.id }">删除</a>
																	</s:if> 
															</s:if>
															<s:elseif test="#request.type=='approvingDocument'">
																<a href="JSP/shenpi.jsp?id=${document.id }">审批</a>&nbsp;|&nbsp;
																<a href="javascript:window.location.href='DocumentAction!submitView?document.id=${document.id }'">提交</a>
															</s:elseif>
															<s:elseif test="#request.type == 'finishDocument'">
																<a href="DocumentAction!deleteDocument?delid=${document.id }">删除</a>
															</s:elseif>
														</td>
													</tr>
												</s:iterator>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</form>
			</td>
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
						href="PersonActon!listMyDocument?index=1" target="mainFrame"
						class="right-font08">首页</a> | <a
						href="DocumentAction!listMyDocument?<s:if test='(#request.currentIndex-1)< 0'>index=1</s:if><s:else >index=${requestScope.currentIndex-1 }</s:else>"
						class="right-font08">上一页</a> | <s:if
							test='(#request.currentIndex+1)<=#pageCount'>
							<a
								href="DocumentAction!listMyDocument?index=${requestScope.currentIndex+1 }"
								class="right-font08">下一页</a>
						</s:if> <s:else></s:else> | <a
						href="DocumentAction!listMyDocument?index=${pageCount }"
						class="right-font08">末页</a>] 转至：</td>
					<td width="1%">
						<table width="20" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="1%"><input name="index" type="text"
									class="right-textfield03" size="1" />
								</td>
								<td width="87%"><input name="Submit23222" type="submit"
									class="right-button06" value=" " />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</table>
	<br>
	<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr></tr>
		<tr align="center">
			<td class="TablePanel">添加流程</td>
		</tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
					<legend>流程信息</legend>
					<form action="" method="post" enctype="multipart/form-data"
						name="form" target="sypost">
						<div class="MainDiv">
							<table width="99%" border="0" cellpadding="0" cellspacing="0"
								class="CContent">

								<tr>
									<td align="right">添加流程定义</td>
									<td align="center"><input name="xxx" type="file" />
									</td>
									<td align="center">&nbsp;</td>
								</tr>
								<tr>
									<td align="right">添加流程图片</td>
									<td align="center"><input name="xxx" type="file" />
									</td>
									<td align="center">&nbsp;</td>
								</tr>
							</table>
						</div>
					</form>
					<br />
				</fieldset>
			</TD>
		</TR>
	</TABLE>

</body>
</html>
