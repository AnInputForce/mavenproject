<%--
    Document   : addProductType
    Created on : 2011-8-24, 15:22:05
    Author     : Kang.Cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品类型添加</title>
  </head>
  <body>
    <div style="width: 350px;">
    <s:form action="manage_productTypeAdd" method="post" namespace="/control/product/type">

      <s:hidden name="parentid" tooltip="所属父id" value="%{parentid}"/>
      <s:textfield label="姓名" name="productType.name" tooltip="请输入产品类型名称" />
      <s:textarea label="谷歌描述" tooltip="请添加搜索引擎meta描述" name="productType.note" cols="35" rows="5" />
      <s:submit value="提交"/>
    </s:form>
    </div>
  </body>
</html>
