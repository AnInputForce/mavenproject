<%--
    Document   : inputinfomation
    Created on : 2012-3-30, 23:13:50
    Author     : Kang.Cunhua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品信息添加</title>

    <script charset="utf-8" src="<s:url value="/editor/kindeditor.js"/>"></script>
    <script>
      var editor;
      KindEditor.ready(function(K) {
        editor = K.create('#contenteditor');
      });
    </script>
  </head>
  <body>
    <div class="span-15">
      <s:form name="form" action="executeInfomationSave" method="post" namespace="/control/product" enctype="multipart/form-data">
        <fieldset>
          <legend>产品信息添加</legend>
          <div><div class="span-2">货号：</div><s:textfield label="货号" name="infomation.code" tooltip="请输入产品货号" /></div>
          <div><div class="span-2">名称：</div><s:textfield label="名称" name="infomation.name" tooltip="请输入产品名称" /></div>
          <div><div class="span-2">类型：</div>
            <s:textfield label="类型" name="infomation.type.typeid" tooltip="请输入产品类型" />
            <s:url id="selecttypeurl" action="selecttypeInfomationSave" namespace="/control/product"/>
            <s:submit value="请选择..." onClick="javaScript:winOpen(${selecttypeurl},'列表',600,400)" />
            <input type="button" value="请选择..." onClick="javaScript:window.open('${selecttypeurl}','列表',600,400)" >
          </div>
          <div>
            <div class="span-2">品牌：</div>
            <s:select name="infomation.brand.code" tooltip="请选择产品品牌" list="brands"
                      listKey="code"
                      listValue="name"
                      headerKey="0" headerValue="--请选择品牌--"
                      />
          </div>
          <div><div class="span-2">型号：</div><s:textfield label="型号" name="infomation.model" tooltip="请输入产品型号" /></div>
          <div><div class="span-2">底价：</div><s:textfield label="底价" name="infomation.baseprice" tooltip="请输入产品底价" />元</div>
          <div><div class="span-2">市场价：</div><s:textfield label="市场价" name="infomation.markprice" tooltip="请输入产品市场价" />元</div>
          <div><div class="span-2">销售价：</div><s:textfield label="销售价" name="infomation.sellprice" tooltip="请输入产品销售价" />元</div>
          <div><div class="span-2">重量：</div><s:textfield label="重量" name="infomation.weight" tooltip="请输入产品货号" /> 克</div>
          <div><div class="span-2">产品简介：</div>
            <textarea id="contenteditor" name="content" style="width:700px;height:300px;">
            &lt;strong&gt;产品简介&lt;/strong&gt;
            </textarea>
          </div>
          <div><div class="span-2">购买说明：</div><s:textfield label="购买说明" name="infomation.buyexplain" tooltip="请输入产品购买说明" /></div>
          <div><div class="span-2">上架：</div><s:checkbox label="上架" name="infomation.visible" tooltip="请选择产品上架与否" value="true" /></div>

          <div><div class="span-2">上架日期：</div><s:textfield label="上架日期" name="infomation.createdate" tooltip="请输入产品上架日期" /></div>
          <div><div class="span-2">人气指数：</div><s:textfield label="人气指数" name="infomation.clickcount" tooltip="请输入产品人气指数" value="1" /></div>
          <div><div class="span-2">销售量：</div><s:textfield label="销售量" name="infomation.sellcount" tooltip="请输入产品销售量" /></div>
          <div><div class="span-2">推荐：</div><s:checkbox label="推荐" name="infomation.commend" tooltip="请选择产品推荐与否" value="true" /></div>
          <div><div class="span-2">性别要求：</div>
            <s:select name="infomation.sexrequest" tooltip="请选择产品性别要求"
                      list="#@java.util.LinkedHashMap@{'NONE':'男女不限','MAN':'男','WONMEN':'女'}"  />
          </div>
          <div><div class="span-2">样式：</div><s:textfield label="样式" name="infomation.styles" tooltip="请输入产品样式" /></div>


          <div><div class="span-2"></div><s:submit value="提交"/></div>

        </fieldset>
      </s:form>
    </div>
  </body>
</html>
