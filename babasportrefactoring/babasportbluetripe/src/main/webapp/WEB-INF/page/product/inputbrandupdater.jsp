<%--
    Document   : inputbrandupdater
    Created on : 2011-9-15, 18:43:18
    Author     : Kang.Cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品品牌编辑</title>
  </head>
  <body>
    <div class="span-19 ">
      <s:form action="executeBrandUpdate" method="post" namespace="/control/product" enctype="multipart/form-data">
        <fieldset>
          <legend>当前ID：[${brand.code}]</legend>
          <s:if test="brand != null" >
            <s:hidden name="brand.code" tooltip="所属id" value="%{brand.code}" />
            <s:hidden name="brand.logopath" tooltip="所属id" value="%{brand.logopath}" />

            <div><div class="span-2">姓名：</div><s:textfield label="姓名" name="brand.name" tooltip="请输入产品类型名称" /></div>
            <div><div class="span-2">上传logo：</div><s:file label="上传图片" name="doc" tooltip="请添加logo路径" /></div>
            <div><div class="span-2">当前logo：</div><img src="<s:url value="%{brand.logopath}"/>"  width="50px"/></div>



            <div class="span-6"><s:submit value="提交"/></div>
          </s:if>
        </fieldset>
      </s:form>
    </div>
  </body>
</html>
