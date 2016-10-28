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

    <s:url id="url" action="allTypesFind" namespace="/control/product"/>
    <s:url id="urlmanage" action="inputTypeSave" namespace="/control/product"/>
    <s:url id="urlbrandsave" action="inputBrandSave" namespace="/control/product"/>
    <s:url id="urlallbrandsfind" action="allBrandsFind" namespace="/control/product"/>

    <s:url id="urluploadfile" action="inputUploadFileSave" namespace="/control/upload"/>
    <s:url id="urlallInfomationsfind" action="allInfomationsFind" namespace="/control/product"/>
    <s:url id="urlInfomationsave" action="inputInfomationSave" namespace="/control/product"/>




    <s:a href="%{url}">产品类型列表</s:a>
    <s:a href="%{urlmanage}">产品类型添加</s:a>
    <s:a href="%{urlallbrandsfind}">产品品牌列表</s:a>
    <s:a href="%{urlbrandsave}">产品品牌添加</s:a>

    <s:a href="%{urluploadfile}">文件上传</s:a>

    <s:a href="%{urlallInfomationsfind}">产品列表</s:a>
    <s:a href="%{urlInfomationsave}">产品添加</s:a>

  </body>
</html>
