<%--
  Document  : decManager
  Created on : 2011-1-11, 16:45:28
  Author   : kang.cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <link href="<s:url value="/style/manager.css"/>" rel="stylesheet" type="text/css"/>
    <sx:head debug="true"/>
    <decorator:head />
    <title><decorator:title default="默认标题：测试" /></title>
  </head>
  <body id="page-home">

    <div id="head">
      <div id="logo"></div>
      <div id="welcome" class="navigatemenu" >
        <ul>
          <li>欢迎光临！</li>
          <li>帮助</li>
          <li>退出</li>
        </ul>
      </div>
    </div>
    <div id="left">
      <p>menu</p>
      <s:url id="menuProductType" action="list_list" namespace="/control/product/type"/>
      <sx:tree id="root" label="管理菜单" showRootGrid="false">
        <sx:treenode id="order" label="订单管理">
          <sx:treenode id="orderdeal" label="订单处理" />
        </sx:treenode>
        <sx:treenode id="product" label="产品管理">
          <sx:treenode id="productType" label="<a href='%{menuProductType}'>产品类别管理</a>" />
        </sx:treenode>
        <sx:treenode id="exitSystem" label="退出系统" />
      </sx:tree>
    </div>
    <div id="right">
      <h3 id="printtitle"><decorator:title/></h3>
      <decorator:body />   <!-- 这里的内容由引用模板的子页面来替换 -->
    </div>
    <div id="foot">
      <p style="text-align:center;">copyright&copy;1982-<SCRIPT language="javascript" type="text/javascript">document.write(new Date().getFullYear());</SCRIPT></p>
    </div>
  </body>
</html>