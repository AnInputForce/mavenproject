<%--
    Document   : typeinfo
    Created on : 2011-9-13, 17:52:16
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
      <s:if test="type != null" >
        <div><div class="span-2">父ID：</div><s:textfield name="parentid" tooltip="所属id" value="%{type.parent.typeid}" disabled="true" /></div>
        <div><div class="span-2">父类：</div><s:textfield name="parentname" tooltip="所属id" value="%{type.parent.name}" disabled="true" /></div>
        <div><div class="span-2">ID：</div><s:textfield name="type.typeid" tooltip="所属id" value="%{typeid}" disabled="true" /></div>
        <div><div class="span-2">姓名：</div><s:textfield name="type.name"  label="姓名" tooltip="请输入产品类型名称" disabled="true" /></div>
        <div><div class="span-2">谷歌描述：</div><s:textarea  name="type.note" label="谷歌描述" tooltip="请添加搜索引擎meta描述" rows="5"  disabled="true" /></div>
      </s:if>
    </div>
  </body>
</html>

