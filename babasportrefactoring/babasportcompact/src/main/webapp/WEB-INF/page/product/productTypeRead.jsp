<%--
    Document   : ProductTypeRead
    Created on : 2011-8-24, 15:22:05
    Author     : Kang.Cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品类型查询</title>
  </head>
  <body>
    <div style="width: 350px;">
      <s:form action="list_list" method="post" namespace="/control/product/type">
        <s:hidden name="query" value="true"/>
        <s:textfield label="姓名" name="productType.name" tooltip="请输入产品类型名称" />
        <s:submit value="提交"/>
      </s:form>
    </div>
  </body>
</html>
