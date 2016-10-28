<%--
    Document   : inputuploadfilesaver
    Created on : 2011-10-2, 17:10:50
    Author     : Kang.Cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传文件</title>
  </head>
  <body>
    <div class="span-15">
      <s:form action="executeUploadFileSave" method="post" namespace="/control/upload" enctype="multipart/form-data">
        <fieldset>
          <legend>上传文件</legend>
          <div><div class="span-2">文件路径：</div><s:file label="上传文件" name="doc" tooltip="请选择文件" /></div>
          <s:submit value="提交"/>
        </s:form>
      </fieldset>
    </div>
  </body>
</html>
