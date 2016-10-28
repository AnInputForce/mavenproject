<%--
    Document   : index
    Created on : 2010-12-10, 20:58:18
    Author     : kang.cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-grid-tags" prefix="sj"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>HomePage!</h1>

        <s:url id="url" action="list" namespace="/control/product/type"/>
        <s:url id="url_jquery" action="jqueryJgrid" namespace="/control/product/type"/>
        <s:a href="%{url}">产品类型列表</s:a>
        <s:url id="tturl" action="jsontable" namespace="/control/product/type"/>
        <s:a href="%{tturl}">json文件测试</s:a>
        <s:a href="%{url_jquery}">jqueryJgrid页面</s:a>

    </body>
</html>
