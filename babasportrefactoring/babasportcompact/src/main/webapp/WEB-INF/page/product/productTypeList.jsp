<%--
    Document   : productList
    Created on : 2011-1-3, 0:11:08
    Author     : kang.cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="description" content="记述">
    <meta name="author" content="作者">

    <title>产品类型列表</title>

  </head>
  <body>

    <div id="functionbar" class="printaction">
      <div>
        <s:form action="list_list" method="post" namespace="/control/product/type">
          <s:hidden name="query" value="true"/>
          <s:textfield label="姓名" name="productType.name" tooltip="请输入产品类型名称" cssStyle="float:left;diaplay:inline;margin-left:10px" />
          <s:submit value="查询"/>
        </s:form>
      </div>
      <div id="menufunction"  class="printaction">
        <s:url id="addproducttypeurl" action="manage_addUI" namespace="/control/product/type">
          <s:param name="parentid" value="%{parentid}"/>
        </s:url>
        <s:url id="url" action="list_list" namespace="/control/product/type">
          <s:param name="printable" value="true"/>
          <s:param name="parentid" value="%{parentid}"/>
        </s:url>
        <s:url id="readurl" action="list_readUI" namespace="/control/product/type"/>
        <ul>
          <li><s:a href="%{addproducttypeurl}">添加类别</s:a></li>
          <li><s:a href="%{url}">打印</s:a></li>
        </ul>
      </div>
    </div>

    <jsp:include page="/common/page/pagingNavigateBar.jsp" flush="true"/>

    <table id="printconent" style="width: 100%" >
      <thead>
        <tr style="background: #6f8ac4;">

          <th><font color="#FFFFFF">代号</font></th>
          <th><font color="#FFFFFF">修改</font></th>
          <th><font color="#FFFFFF">产品类别名称</font></th>
          <th><font color="#FFFFFF">创建下级分类</font></th>
          <th><font color="#FFFFFF">父类</font></th>
          <th><font color="#FFFFFF">meta描述</font></th>

        </tr>
      </thead>
      <tbody>

        <s:hidden name="parentid" tooltip="所属父id" value="%{parentid}"/>
        <s:iterator  status="index" value="pageview.records" var="productType">
          <s:url id="typeediturl" action="manage_editUI" namespace="/control/product/type">
            <s:param name="typeid" value="typeid"/>
          </s:url>
          <s:url id="subtypelisturl" action="list_list" namespace="/control/product/type">
            <s:param name="parentid" value="typeid"/>
          </s:url>
          <s:url id="typeaddurl" action="manage_addUI" namespace="/control/product/type">
            <s:param name="parentid" value="typeid"/>
          </s:url>
          <tr class="oddcolor${index.index%2}">
            <td><s:property escape="false" value="typeid" /></td>
            <td><s:a href="%{typeediturl}">编辑</s:a></td>
            <td><s:a href="%{subtypelisturl}"><s:property escape="false" value="name"/></s:a></td>
            <td><s:a href="%{typeaddurl}">新增子类别</s:a></td>
            <td><s:property escape="false" value="parent.name" default="-"/></td>
            <td><s:property escape="false" value="note"/></td>
          </tr>
        </s:iterator>
      </tbody>
    </table>
    <jsp:include page="/common/page/pagingNavigateBar.jsp" flush="true"/>
  </body>
</html>
