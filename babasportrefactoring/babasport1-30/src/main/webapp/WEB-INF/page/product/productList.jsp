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
        <table id="printconent" style="width: 100%" >
            <thead>
                <tr style="background: #6f8ac4;">

                    <th><font color="#FFFFFF">代号</font></th>
                    <th><font color="#FFFFFF">修改</font></th>
                    <th><font color="#FFFFFF">产品类别名称</font></th>
                    <th><font color="#FFFFFF">创建下级分类</font></th>
                    <th><font color="#FFFFFF">--</font></th>
                    <th><font color="#FFFFFF">父类</font></th>
                    <th><font color="#FFFFFF">meta描述</font></th>

                </tr>
            </thead>
            <tbody>
                <s:iterator value="pageview.records" var="pv">
                    <tr style="background: #f5f5f5">
                        <td><s:property escape="false" value="#pv.typeid" /></td>
                        <td><span id="edit"/>编辑</td>
                        <td><s:property escape="false" value="#pv.name"/></td>
                        <td>新增...</td>
                        <td style="text-align: center">-</td>
                        <td style="text-align: center"><s:property escape="false" value="#pv.parent.name" default="-"/></td>
                        <td><s:property escape="false" value="#pv.note"/></td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>

    </body>
</html>
