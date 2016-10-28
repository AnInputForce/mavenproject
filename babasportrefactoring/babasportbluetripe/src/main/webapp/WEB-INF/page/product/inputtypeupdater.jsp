<%--
    Document   : inputtypeupdater
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
    <div class="span-19 ">
      <s:form action="executeTypeUpdate" method="post" namespace="/control/product">
        <fieldset>
          <legend>当前ID：[${type.typeid}]
            <s:if test="type.parent == null">
              -->父ID：无
            </s:if>
            <s:else>
              -->父ID：[${type.parent.typeid}]
            </s:else>
          </legend>
          <s:if test="type != null" >
            <s:hidden name="type.typeid" tooltip="所属id" value="%{typeid}" />
            <s:hidden name="type.parent.typeid" tooltip="所属父id" value="%{type.parent.typeid}"/>
            <div><div class="span-2">姓名：</div><s:textfield name="type.name"  label="姓名" tooltip="请输入产品类型名称" /></div>
            <div><div class="span-2">谷歌描述：</div><s:textarea  name="type.note" label="谷歌描述" tooltip="请添加搜索引擎meta描述" rows="5" /></div>
            <div class="span-6"><s:submit value="提交"/></div>
          </s:if>
        </fieldset>
      </s:form>
    </div>
  </body>
</html>

