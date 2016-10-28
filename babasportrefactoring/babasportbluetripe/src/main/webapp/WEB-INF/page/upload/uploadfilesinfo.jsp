<%--
    Document   : brandsinfo
    Created on : 2011-9-15, 16:07:23
    Author     : Kang.Cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品品牌列表</title>
    <script type="text/javascript" language="javascript" charset="utf-8">
      function selectall(allobj,items) {
        var state = allobj.checked;
        //alert (state);
        if (items.length){
          for ( var i = 0; i < items.length; i++) {
            items[i].checked = state;
          }
        } else{
          items.checked = state;
        }
      }
      function deleSelect()
      {
        //var delValue="";
        var flag=false;
        var de= document.getElementsByName("selectedids");

        for(i=0;i<de.length;i++) {
          if(de[i].checked){
            //delValue+=","+de[i].value;
            flag = true;
            break;
          }
        }
        if(!flag) {
          alert("至少你要选择一个待删除记录");
          return false;
        }else{
          if(!confirm("确定删除?")) {
            return false;
          }
        }
      }
//      function checkqueryname(){
//        var oldnametmp = document.getElementsByName("uploadFile.oldname");
//        alert (oldnametmp);
//        if ((oldnametmp == null) ||  (oldnametmp == "" )) {
//          return false;
//        }else{
//          return true;
//        }
//
//      }

    </script>

  </head>
  <body>

    <div id="functionbar" class="span-19 last printless">
      <div class="span-8">
        <s:form action="allUploadFilesFind" method="post" namespace="/control/upload" cssStyle="margin-bottom:0">
          <s:hidden name="query" value="true"/>
          姓名:<s:textfield label="姓名" name="uploadFile.oldname" tooltip="请输入上传文件名称"/>
          <s:submit value="查询" />
        </s:form>
      </div>
      <div id="menufunction"  class="span-6 last printless">
        <s:url id="adduploadfileurl" action="inputUploadFileSave" namespace="/control/upload" />
        <s:url id="printurl" action="allUploadFilesFind" namespace="/control/upload">
          <s:param name="printable" value="true"/>
          <s:param name="uploadfile.filepath" value="%{uploadfile.filepath}"/>
          <s:param name="query" value="%{query}"/>
          <s:param name="page" value="%{page}"/>
        </s:url>
        <ul>
          <li><s:a href="%{adduploadfileurl}">上传文件</s:a></li>
          <li><s:a href="%{printurl}">打印</s:a></li>
        </ul>
      </div>
    </div>
    <!-- 构造翻页URL -->

    <s:url id="pageurl" action="allUploadFilesFind" namespace="/control/upload">
      <s:param name="uploadfile.id" value="%{uploadfile.id}"/>
      <s:param name="query" value="%{query}"/>
    </s:url>
    <jsp:include page="/common/page/pagingNavigateBar.jsp" flush="true"/>
    <s:form name="uploadfilesdelete" action="UploadFilesDelete" method="post" namespace="/control/upload">
      <table id="printconent" class="span-19">
        <thead>
          <tr>
            <th style="text-align: left">
              <s:checkbox name="all" value="true" onclick="javascript:selectall(this,this.form.selectedids)"/>
              编号
            </th>
            <!-- <th>修改</th>
            <th>详情</th> -->
            <th>原文件名</th>
            <th>文件路径</th>
            <th>上传时间</th>
          </tr>
        </thead>
        <tbody>
          <s:iterator  status="index" value="pageview.records" var="uploadfile">
            <s:url id="uploadfileediturl" action="inputUploadFileUpdate" namespace="/control/upload">
              <s:param name="id" value="id"/>
            </s:url>
            <s:url id="uploadfilefindurl" action="uploadFileFind" namespace="/control/upload">
              <s:param name="id" value="code"/>
            </s:url>
            <s:url id="uploadfileaddurl" action="inputUploadFileSave" namespace="/control/upload" />
            <tr class="oddcolor${index.index%2}">
              <td><s:checkbox name="selectedids" value="true" fieldValue="%{id}" />
                <s:property escape="false" value="id" />
              </td>
              <!-- <td><s:a href="%{uploadfileediturl}">编辑</s:a></td>
              <td><s:a href="%{uploadfilefindurl}">详情</s:a></td> -->
              <td><s:property escape="false" value="oldname" /></td>
              <td><s:property escape="false" value="filepath" /></td>
              <td><s:property escape="false" value="uploadtime" /></td>

            </tr>
          </s:iterator>
        </tbody>
      </table>
      <s:submit name="del" value="删除"   onclick="return deleSelect()"/>
    </s:form>
  </body>
</html>