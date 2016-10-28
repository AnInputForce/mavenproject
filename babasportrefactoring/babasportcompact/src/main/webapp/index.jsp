<%--
    Document   : index
    Created on : 2010-12-10, 20:58:18
    Author     : kang.cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>欢迎来到巴巴运动网</title>
    </head>
    <body>
        <h1>首页!</h1>

        <s:url id="url" action="list_list" namespace="/control/product/type"/>
        <s:url id="urlmanage" action="manage_addUI" namespace="/control/product/type"/>
        <s:a href="%{url}">产品类型列表</s:a>
        <s:a href="%{urlmanage}">产品类型添加</s:a>


    </body>
</html>
