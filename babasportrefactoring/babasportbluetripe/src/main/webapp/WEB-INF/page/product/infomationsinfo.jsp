<%--
    Document   : infomationsinfo
    Created on : 2012-3-16, 14:32:37
    Author     : Kang.Cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品信息列表</title>
  </head>
  <body>
    <div id="functionbar" class="span-19 last printless">
      <div class="span-8">
        <s:form action="allInfomationsFind" method="post" namespace="/control/product" cssStyle="margin-bottom:0">
          <s:hidden name="query" value="true"/>
          名称:<s:textfield label="名称" name="infomation.name" tooltip="请输入产品信息名称"/>
          <s:submit value="查询"/>
        </s:form>
      </div>
      <div id="menufunction"  class="span-6 last printless">
        <s:url id="addproductinfomationurl" action="inputInfomationSave" namespace="/control/product" />
        <s:url id="url" action="allInfomationsFind" namespace="/control/product">
          <s:param name="printable" value="true"/>
          <s:param name="imfomation.name" value="%{imfomation.name}"/>
          <s:param name="query" value="%{query}"/>
          <s:param name="page" value="%{page}"/>
        </s:url>
        <ul>
          <li><s:a href="%{addproductbrandurl}">添加产品信息</s:a></li>
          <li><s:a href="%{url}">打印</s:a></li>
        </ul>
      </div>
    </div>
    <!-- 构造翻页URL -->

    <s:url id="pageurl" action="allBrandsFind" namespace="/control/product">
      <s:param name="imfomation.name" value="%{imfomation.name}"/>
      <s:param name="query" value="%{query}"/>
    </s:url>
    <jsp:include page="/common/page/pagingNavigateBar.jsp" flush="true"/>

    <table id="printconent" class="span-19">
      <thead>
        <tr>
          <th>编号</th>
          <th>名称</th>
          <th>修改</th>
          <th>详情</th>
          <th>品牌</th>
        </tr>
      </thead>
      <tbody>

        <s:iterator  status="index" value="pageview.records" var="infomation">
          <s:url id="infomationediturl" action="inputInfomationUpdate" namespace="/control/product">
            <s:param name="id" value="id"/>
          </s:url>
          <s:url id="infomationfindurl" action="infomationFind" namespace="/control/product">
            <s:param name="id" value="id"/>
          </s:url>
          <s:url id="brandaddurl" action="inputInfomationSave" namespace="/control/product" />
          <tr class="oddcolor${index.index%2}">
            <td><s:property escape="false" value="code" /></td>
            <td><s:property escape="false" value="name"/></td>
            <td><s:a href="%{infomationediturl}">编辑</s:a></td>
            <td><s:a href="%{infomationfindurl}">详情</s:a></td>
            <td><s:property escape="false" value="brand.name" /></td>
          </tr>
        </s:iterator>
      </tbody>
    </table>
  </body>
</html>
