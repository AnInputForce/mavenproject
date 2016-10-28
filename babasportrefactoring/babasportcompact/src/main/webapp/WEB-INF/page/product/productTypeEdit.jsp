<%--
    Document   : productTpyeEdit
    Created on : 2011-8-31, 12:33:15
    Author     : Kang.Cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品类型编辑</title>
  </head>
  <body>
    <s:form action="manage_productTypeEdit" method="post" namespace="/control/product/type">
      <s:if test="productType != null" >
        <s:property value="productType" />
        <s:hidden name="productType.typeid" tooltip="所属id" value="%{typeid}" />
        <s:textfield name="productType.name"  label="姓名" tooltip="请输入产品类型名称" />
        <s:textarea  name="productType.note" label="谷歌描述" tooltip="请添加搜索引擎meta描述" cols="20" rows="3"/>
        <s:submit value="提交"/>
      </s:if>
    </s:form>
  </body>
</html>

