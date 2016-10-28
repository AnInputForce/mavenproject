<%-- 
    Document   : struts2_tag_tree
    Created on : 2011-1-14, 1:46:05
    Author     : kang.cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>menu!</h1>
        <sx:tree id="root" label="Root">
            <sx:treenode id="child1" label="<b>Child 1</b>" />
            <sx:treenode id="subchild1" label="SubChild 1">
                <sx:treenode id="subchild2" label="SubChild 2" />
                <sx:treenode id="subchild3" label="SubChild 3" />
            </sx:treenode>
            <sx:treenode id="subchild1" label="SubChild 1">
                <sx:treenode id="subchild2" label="SubChild 2" />
                <sx:treenode id="subchild3" label="SubChild 3" />
            </sx:treenode>
            <sx:treenode id="subchild1" label="SubChild 1">
                <sx:treenode id="subchild2" label="SubChild 2" />
                <sx:treenode id="subchild3" label="SubChild 3" />
            </sx:treenode>
            <sx:treenode id="subchild1" label="SubChild 1">
                <sx:treenode id="subchild2" label="SubChild 2" />
                <sx:treenode id="subchild3" label="SubChild 3" />
            </sx:treenode>
            <sx:treenode id="subchild1" label="SubChild 1">
                <sx:treenode id="subchild2" label="SubChild 2" />
                <sx:treenode id="subchild3" label="SubChild 3" />
            </sx:treenode>
            <sx:treenode id="child2" label="<b>child 2</b>" />
        </sx:tree>
    </body>
</html>
