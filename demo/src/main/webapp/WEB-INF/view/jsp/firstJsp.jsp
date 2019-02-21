<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <base href="<%=basePath%>">
    <title>天行健，重卡车联服务领导者！</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>

  <body>
	<div style="width:100%; height:640px;">
		<div class="BG">
			<div class="BG_1">
				<div style="width:264px; height:190px;  margin:auto; margin-top:80px;">
					<form id="loginForm" name="loginForm" method="post" action="system/login.do">
						<input type="text" name="name" value=""/>
						<input type="text" name="password" value=""/>
					</form>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
