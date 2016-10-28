<%@page pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<div id="pageNavBar" class="printless">
  <ul>
    <li>总：${pageview.totalrecord}条</li>
    <li>显：${pageview.maxresult}条</li>
    <li>共:${pageview.totalpage}页</li>
    <s:iterator  begin="pageview.pageindex.startpage" end="pageview.pageindex.endpage" var="wp">
      <li>
        <s:if test="pageview.currentpage==#wp">
          <b>第<s:property value="#wp"/>页</b>
        </s:if>
        <s:else>
          <s:a href="%{(#pageurl.indexOf('?') > -1)?
               (#pageurl.concat(\"&page=\").concat(#wp).replace(\"&amp;\", \"&\")):
               (#pageurl.concat(\"?page=\").concat(#wp).replace(\"&amp;\", \"&\"))}">
            第<s:property value="#wp"/>页
          </s:a>
        </s:else>
      </li>
    </s:iterator>
  </ul>
</div>
