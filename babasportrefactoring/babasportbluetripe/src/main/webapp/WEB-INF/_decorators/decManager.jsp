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
    <link rel="stylesheet" href="<s:url value="/css/screen.css"/>" type="text/css" media="screen, projection" />
    <!--[if IE]>
      <link rel="stylesheet" href="<s:url value="/css/ie.css"/>" type="text/css" media="screen, projection" />
    <![endif]-->
    <link rel="stylesheet" href="<s:url value="/css/style.css"/>" type="text/css" media="screen, projection" />
    <sx:head debug="true"/>
    <decorator:head />
    <title><decorator:title default="默认标题：测试" /></title>
    <script language="javascript">
      function codefans(){
        var box=document.getElementById("divmsg");
        box.style.display="none";
      }
      setTimeout("codefans()",3000);//3秒
    </script>
  </head>
  <body>
    <div class="container showgrid">
      <div id="head" class="span-24">
        <div id="logo" class="span-16">logo</div>
        <div id="welcome" class="span-8 last">
          <ul>
            <li>欢迎光临！</li>
            <li>帮助</li>
            <li>退出</li>
          </ul>
        </div>
      </div>
      <div id="left" class="span-5 row">
        <p>menu</p>
        <s:url id="url_alltypesfind" action="allTypesFind" namespace="/control/product" />
        <s:url id="url_allbrandsfind" action="allBrandsFind" namespace="/control/product"/>
        <s:url id="url_alluploadfilesfind" action="allUploadFilesFind" namespace="/control/upload"/>

        <sx:tree id="root" label="管理菜单" showRootGrid="false">
          <sx:treenode id="order" label="订单管理">
            <sx:treenode id="orderdeal" label="订单处理" />
          </sx:treenode>
          <sx:treenode id="product" label="产品管理">
            <sx:treenode id="type" label="<a href='%{url_alltypesfind}'>产品类别管理</a>" />
            <sx:treenode id="brand" label="<a href='%{url_allbrandsfind}'>产品品牌管理</a>" />
          </sx:treenode>
          <sx:treenode id="uploadfile" label="文件管理">
            <sx:treenode id="file" label="<a href='%{url_alluploadfilesfind}'>文件列表</a>" />
          </sx:treenode>
          <sx:treenode id="exitSystem" label="退出系统" />
        </sx:tree>
      </div>
      <div id="right" class="span-19 last row">
        <h3 id="printtitle" ><decorator:title/></h3>
        <s:if test="hasFieldErrors() || hasActionErrors() || hasActionMessages()">
          <div id="divmsg" class="span6">
            <s:actionerror/>
            <s:actionmessage/>
            <s:fielderror/>
          </div>
        </s:if>
        <decorator:body />   <!-- 这里的内容由引用模板的子页面来替换 -->

      </div>

      <div id="foot" class="span-24">
        <p style="text-align:center;">copyright&copy;1982-<SCRIPT language="javascript" type="text/javascript">document.write(new Date().getFullYear());</SCRIPT></p>
      </div>
    </div>
    <!--    s:debug/>-->
  </body>
</html>