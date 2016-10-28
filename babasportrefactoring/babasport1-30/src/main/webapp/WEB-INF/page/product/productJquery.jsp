<%-- 
    Document   : test
    Created on : 2011-1-9, 22:15:06
    Author     : kang.cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <sj:head jqueryui="true" jquerytheme="redmond" />
        <title>产品类型展现_JqueryJgrid方式</title>
    </head>
    <body>
        <s:url id="remoteurl" action="jsontable" namespace="/control/product/type"/>
        <sjg:grid
            id="gridtable"
            caption="测试jquery整合"
            dataType="json"
            href="%{remoteurl}"
            pager="true"
            gridModel="gridModel"
            rowList="10,15,20"
            rowNum="15"
            rownumbers="true"
            >
            <sjg:gridColumn name="typeid" index="typeid" title="编号" formatter="integer" sortable="false"/>
            <sjg:gridColumn name="name" index="name" title="名字" sortable="true"/>
            <sjg:gridColumn name="parent.name" index="parent.name" title="父类" sortable="true" />
            <sjg:gridColumn name="note" index="note" title="mete描述" sortable="false"/>
        </sjg:grid>
    </body>
</html>
