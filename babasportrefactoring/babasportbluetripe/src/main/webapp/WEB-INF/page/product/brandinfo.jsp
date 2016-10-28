<%--
    Document   : brandinfo
    Created on : 2011-9-15, 18:43:35
    Author     : Kang.Cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品类型详情</title>
  </head>
  <body>
    <div class="span-19 ">
      <s:if test="brand != null" >

        <div><div class="span-2">ID：</div><s:textfield name="brand.code" tooltip="所属id" value="%{code}" disabled="true" /></div>
        <div><div class="span-2">姓名：</div><s:textfield name="brand.name"  label="姓名" tooltip="产品品牌名称" disabled="true" /></div>
        <div><div class="span-2">logo：</div><img src="<s:url value="%{brand.logopath}"/>"  /></div>
        </s:if>
    </div>
  </body>
</html>

