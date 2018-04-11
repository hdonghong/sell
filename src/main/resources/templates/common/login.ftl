<html>
<#include "./header.ftl">
<#--
    由于微信开放平台网页扫码登录需要公司注册，故增加此页面作后台测试用
-->
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/sell/seller/login" method="get">
                <div class="form-group">
                    <label for="exampleInputEmail1">Openid</label><input type="text" class="form-control" name="openid" />
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>
</div>

</body>

</html>