<html>
<#include "../common/header.ftl">

<body>

    <div id="wrapper" class="toggled">
        <#-- 边栏sidebar -->
        <#include "../common/nav.ftl">

        <#-- 主题内容content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                <#--订单列表-->
                    <div class="col-md-12 column">
                        <div class="row clearfix">
                            <div class="col-md-12 column">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>订单id</th>
                                        <th>姓名</th>
                                        <th>手机号</th>
                                        <th>地址</th>
                                        <th>金额</th>
                                        <th>订单状态</th>
                                        <th>支付状态</th>
                                        <th>创建时间</th>
                                        <th colspan="2">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list orderDtoPage.content as orderDto>
                                    <tr>
                                        <td>${orderDto_index + 1}</td>
                                        <td>${orderDto.orderId}</td>
                                        <td>${orderDto.buyerName}</td>
                                        <td>${orderDto.buyerPhone}</td>
                                        <td>${orderDto.buyerAddress}</td>
                                        <td>${orderDto.orderAmount}</td>
                                        <td>${orderDto.getOrderStatusEnum().getMsg()}</td>
                                        <td>${orderDto.getPayStatusEnum().getMsg()}</td>
                                        <td>${orderDto.createTime}</td>
                                        <td>
                                            <a href="/sell/seller/order/detail?orderId=${orderDto.orderId}">详情</a>
                                        </td>
                                        <td>
                                            <#if orderDto.getOrderStatusEnum().getMsg() == "新订单">
                                                <a href="/sell/seller/order/cancel?orderId=${orderDto.orderId}">取消</a>
                                            <#else >
                                            ${orderDto.getOrderStatusEnum().getMsg()}
                                            </#if>
                                        </td>
                                    </tr>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                        </#if>

                        <#list 1..orderDtoPage.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#elseif index gte currentPage-5 && index lte currentPage+4>
                                <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>

                        <#if currentPage gte orderDtoPage.getTotalPages()>
                            <li class="disabled"><a href="#" >下一页</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                        </#if>

                        </ul>
                    </div>
                </div>



            </div>
        </div>
    </div>

    </body>

</html>
