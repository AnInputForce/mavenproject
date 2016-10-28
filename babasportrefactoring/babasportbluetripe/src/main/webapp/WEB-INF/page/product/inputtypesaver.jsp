<%--
    Document   : inputtypesaver
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
    <div class="span-15">
      <s:form action="executeTypeSave" method="post" namespace="/control/product">
        <fieldset>
          <legend>
            <s:if test="parentid == null">
              父ID：[无]
            </s:if>
            <s:else>
              父ID：[${parentid}]
            </s:else>
          </legend>
          <s:hidden name="parentid" tooltip="所属父id" value="%{parentid}"/>
          <div><div class="span-2">姓名：</div><s:textfield label="姓名" name="type.name" tooltip="请输入产品类型名称" /></div>
          <div><div class="span-2">谷歌描述：</div><s:textarea label="谷歌描述" tooltip="请添加搜索引擎meta描述" name="type.note" cols="35" rows="5" /></div>
          <s:submit value="提交"/>
        </s:form>
      </fieldset>
    </div>
  </body>
</html>
