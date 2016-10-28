<%--
    Document   : typesinfo
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
    <title>产品类型列表</title>

  </head>
  <body>

    <div id="functionbar" class="span-19 last printless">
      <div class="span-8">
        <s:form action="allTypesFind" method="post" namespace="/control/product" cssStyle="margin-bottom:0">
          <s:hidden name="query" value="true"/>
          姓名:<s:textfield label="姓名" name="type.name" tooltip="请输入产品类型名称" />
          <s:submit value="查询"/>
        </s:form>
      </div>
      <div id="menufunction"  class="span-6 last printless">
        <s:url id="addproducttypeurl" action="inputTypeSave" namespace="/control/product">
          <s:param name="parentid" value="%{parentid}"/>
        </s:url>
        <s:url id="url" action="allTypesFind" namespace="/control/product">
          <s:param name="printable" value="true"/>
          <s:param name="parentid" value="%{parentid}"/>
          <s:param name="brand.name" value="%{brand.name}"/>
          <s:param name="query" value="%{query}"/>
          <s:param name="page" value="%{page}"/>
        </s:url>
        <ul>
          <li><s:a href="%{addproducttypeurl}">添加类别</s:a></li>
          <li><s:a href="%{url}">打印</s:a></li>
          </ul>
        </div>
      </div>
      <!-- 构造翻页URL -->
    <s:url id="pageurl" action="allTypesFind" namespace="/control/product">
      <s:param name="type.name" value="%{type.name}"/>
      <s:param name="query" value="%{query}"/>
    </s:url>
    <jsp:include page="/common/page/pagingNavigateBar.jsp" flush="true"/>
     <table id="printconent" class="span-19">
      <thead>
        <tr>
          <th>代号</th>
          <th>修改</th>
          <th>详情</th>
          <th>产品类别名称</th>
          <th>创建下级分类</th>
          <th>父类</th>
          <th>meta描述</th>
        </tr>
      </thead>
      <tbody>

        <s:hidden name="parentid" tooltip="所属父id" value="%{parentid}"/>
        <s:iterator  status="index" value="pageview.records" var="type">
          <!--
          iterator的属性var貌似不用设置，在Struts2中可以直接调用domain的字段
          此处设置为prodectType在正常列表时没有问题 ；
          在查询某个name like时不能 得到子分类个数 ；
          貌似和我在查询时传入参数productType.name生成的productType对象与此变量冲突所致？
          -->
          <s:url id="typeediturl" action="inputTypeUpdate" namespace="/control/product">
            <s:param name="typeid" value="typeid"/>
          </s:url>

          <s:url id="typefindurl" action="typeFind" namespace="/control/product">
            <s:param name="typeid" value="typeid"/>
          </s:url>
          <s:url id="subtypelisturl" action="allTypesFind" namespace="/control/product">
            <s:param name="parentid" value="typeid"/>
          </s:url>
          <s:url id="typeaddurl" action="inputTypeSave" namespace="/control/product">
            <s:param name="parentid" value="typeid"/>
          </s:url>
          <tr class="oddcolor${index.index%2}">
            <td><s:property escape="false" value="typeid" /></td>
            <td><s:a href="%{typeediturl}">编辑</s:a></td>
            <td><s:a href="%{typefindurl}">详情</s:a></td>
              <td>
              <s:a href="%{subtypelisturl}"><s:property escape="false" value="name"/></s:a>
              <s:if test="childtypes.size() > 0"><code>(有${childtypes.size()}个子类)</code></s:if>
              </td>
              <td><s:a href="%{typeaddurl}">新增子类别</s:a></td>
            <td><s:property escape="false" value="parent.name" default="-"/></td>
            <td><s:property escape="false" value="note"/></td>
          </tr>
        </s:iterator>
      </tbody>
    </table>
  </body>
</html>
