<%--
    Document   : inputbrandsaver
    Created on : 2011-9-15, 18:42:53
    Author     : Kang.Cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品品牌添加</title>
  </head>
  <body>
    <div class="span-15">
      <s:form action="executeBrandSave" method="post" namespace="/control/product" enctype="multipart/form-data">
        <fieldset>
          <legend>产品品牌添加</legend>
          <div><div class="span-2">姓名：</div><s:textfield label="姓名" name="brand.name" tooltip="请输入产品类型名称" /></div>
          <div><div class="span-2">logo路径：</div><s:file label="上传图片" name="doc" tooltip="请添加logo路径" /></div>
          <s:submit value="提交"/>
        </s:form>
      </fieldset>
    </div>
  </body>
</html>
