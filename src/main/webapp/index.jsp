<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
   <h1>所有MVC默认都是请求转发</h1> <br>
    <a href="myjsp">myjsp first</a>
    <a href="test0/5/mvc">test0 first</a>
    <a href="test0/mvc5566">test1 first</a>
    <a href="test0/66/33/33/33/mvc">test2 first</a>
     <a href="test3">test3</a>
      <form action="test4" method="post">
      	<input type="submit" value="test4 post">
      </form>
       <form action="test5" method="post">
       	<input type="text" name="name">
      	<input type="submit" value="test5 post">
      </form>
       <form action="test6" method="post">
       	<input type="text" name="name">
       	<input type="text" name="age">
      	<input type="submit" value="test6 post">
      </form>
       <a href="test7/张三">test7</a>
 //===================================================================//      
       <form action="testMethod" method="get">
       		<input type="submit" value="get">
       </form>
        <form action="testMethod" method="post">
       		<input type="submit" value="post">
       </form>
        <form action="testMethod" method="post">
        	<input type="hidden" name="_method" value="DELETE">
       		<input type="submit" value="DEL">
       </form>
        <form action="testMethod" method="post">
        	<input type="hidden" name="_method" value="PUT">
       		<input type="submit" value="PUT">
       </form>
       <a href="testMethod/params?uname=张三">params</a>
        <a href="testMethod/params2?uname=张三&uage=20">params2</a>
        <a href="testHeader">header</a>
        <a href="testCookie">testCookie</a>
        //============================================
        <form action="testObject" method="post">
        	id<input type="text" name="id">
        	name<input type="text" name="name">
        	homeaddress<input type="text" name="address.homeAddress">homeAddress
        	schooladdress<input type="text" name="address.schoolAddress">schoolAddress
			<input type="submit" value="提交">
        </form>
        <a href="testHttpServletRequest?name=张三">testHttpServletRequest</a>
        
        //返回传参  <a href="testModelAndView">modelAndView</a>
        <a href="testModel">model</a>
        <a href="testMap">map</a>
        <a href="testModelAttribute?id=1&name=zs">testModelAttribute</a>
        <form action="testModelAttribute">
        	<input type="text" name="name" value="zs">
        	<input type="hidden" name="id" value="1">
        	<input type="submit" value="提交">
        </form>
        //---------------------------------<br>
        <a href="a">a_test</a><br>
        <a href="defaults">defaults</a><br>
        <a href="forwards">forwards</a><br>
        <a href="redirects">redirects</a><br>
  </body>
</html>
