<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<div id="pageNavBar">
    <ul>
        <li>总：${pageview.totalrecord}条</li>
        <li>显：${pageview.maxresult}条</li>
        <li>共:${pageview.totalpage}页</li>
        <s:iterator  begin="pageview.pageindex.startpage" end="pageview.pageindex.endpage" var="wp">
            <s:url id="pageurl" action="list" namespace="/control/product/type">
                <s:param name="page" value="#wp"/>
            </s:url>
            <li>
                <s:if test="pageview.currentpage==#wp">
                    <b>第<s:property value="#wp"/>页</b>
                </s:if>
                <s:else>
                    <s:a href="%{pageurl}">第<s:property value="#wp"/>页</s:a>
                </s:else>
            </li>
        </s:iterator>
    </ul>
</div>
