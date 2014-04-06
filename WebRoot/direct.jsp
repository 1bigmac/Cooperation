<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
		
%>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<title>Insert title here</title>
</head>
<body>

	<a href="${returns }">回到主题</a>
	<span id="time">2</span>秒后回到主题，请等待
	
<script language="JavaScript" type="text/javascript">
	function delayURL(url) {
		var delay = document.getElementById("time").innerHTML;
		if (delay > 0) {
			delay--;
			document.getElementById("time").innerHTML = delay;
		} else {
			window.location.href = url;
		}
		setTimeout("delayURL('" + url + "')", 1000);
	}
</script>
<script language="javascript">
	delayURL("${returns}");
</script>

</body>
</html>
