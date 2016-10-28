<%-- 
    Document   : decPerPrintView
    Created on : 2011-1-13, 16:05:36
    Author     : kang.cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title><decorator:title /></title>
        <decorator:head />
        <link href="<s:url value="/style/printaction.css"/>" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="window.print();">
        <decorator:body />
    </body>
</html>