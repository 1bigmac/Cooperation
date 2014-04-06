<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>项目管理系统</title>
		<link rel="stylesheet" rev="stylesheet" href="css/style.css"
			type="text/css" media="all" />
		<script src="js/Calendar.js">  </script>
		<script type="text/javascript">
/*调取日历*/
        var c = new Calendar("c");
        document.write(c);
    </script>

		<script language="JavaScript" type="text/javascript">
		
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

</script>
		<style type="text/css">
<!--
.atten {
	font-size: 12px;
	font-weight: normal;
	color: #F00;
}
-->
</style>
	</head>

	<s:debug></s:debug>

	<body class="ContentBody">
		<form action="ModuleAction!addModule" method="post" name="form"
			target="mainFrame">
			<div class="MainDiv">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title">
							模块信息录入
						</th>
					</tr>
					<tr>
						<td class="CPanel">
							<table border="0" cellpadding="0" cellspacing="0"
								style="width: 100%">
								<tr>
									<td align="left">
										<input type="button" name="Submit2" value="返回" class="button"
											onclick="window.history.go(-1);" />
									</td>
								</tr>
								<TR>
									<TD width="100%">
										<fieldset style="height: 100%;">
											<legend>
												模块信息
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">
												<tr>
													<td nowrap align="right" width="15%">
														模块编号:
													</td>

													<td width="35%">
														<input name='module.id' type="text" class="text"
															style="width: 154px" value="" readonly />
														<span class="red">*</span>
													</td>
												</tr>


												<tr>
													<td nowrap="nowrap" align="right">
														模块名称:
													</td>
													<td>
														<input class="text" name='module.name'
															style="width: 154px" value="" />
													</td>
													<td align="right">
														模块路径:
													</td>
													<td>
														<input class="text" name='module.url'
															value="" style="width: 154px"
															onfocus="c.showMoreDay = false;c.show(this);" />
													</td>
												</tr>
												<tr>
													<td align="right">
														唯一标识:
													</td>
													<td>
														<input class="text" name='module.sn'
															style="width: 154px" value="" />
													</td>
													<td align="right">
														主模块id:
													</td>
													<td>
														<input class="text" name='pid'
															style="width: 154px" value="${param.pid }" />
													</td>
												</tr>
											</table>
											<br />
										</fieldset>
									</TD>
								</TR>
							</TABLE>
						</td>
					</tr>
					<TR>
						<TD colspan="2" align="center" height="50px">
							<input type="submit" name="Submit" value="保存" class="button"
								onclick="" />

							<input type="button" name="Submit2" value="返回" class="button"
								onclick="window.history.go(-1);" />
						</TD>
					</TR>
				</TABLE>
			</div>
		</form>
	</body>
</html>
