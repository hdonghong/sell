# Spring Boot微信购物系统
> 基于Spring Boot、微信特性和Redis等核心技术栈，实现一个从下单、接单到结单完整购物流程，包含买家端与卖家端前后台功能的微信购物系统。本项目采用前后端分离，由Vue打造的买家端（借自Mooc某收费课程），FreeMarker构成的卖家端，API采用RESTful风格，应用部署上线涉及Nginx、Tomcat、Redis、Mysql等。
为方便开发，应用部署环境已配置在VM中，点击右方获取虚拟机【-> [密码：grw1][1]】，在本地安装即可。

## 技术
*   Spring Boot
*   微信授权登录
*   微信模板消息推送
*   微信支付与退款
*   WebSocket
*   Redis分布式锁
*   Redis缓存
*   Token认证
*   其它：日志(slf4j+logback)/注解常量/自定义异常/自定义切面/单元测试代码编写 等

## 功能模块
*   买家端（手机端）
    *   下单
    *   查询订单
    *   取消订单
    *   支付订单
*   卖家端（PC端）
    *   类目增删
    *   商品上下架
    *   接单
    *   查询订单
    *   取消订单
*   功能演示 -> [传送门][2]

## 项目配置
### 1.前端
前端代码位于VM的`/opt/code/sell_fe_buyer`目录下，打开前端代码里面的`config/index.js`文件`build`节点下的`sellUrl` `openidUrl` `wechatPayUrl` 配置自己的项目地址。（最好配置为域名地址而不是ip地址，可使用netapp作内网穿透）
**linux下相关命令：**

    cd /opt/code/sell_fe_buyer/config
    vim index.js
    
    # 配置项目地址，并保存退出
    
    cd .. 
    npm run build
    cp -r dist/* /opt/data/wwwroot/sell/

### 2.后端
修改项目 `src/main/resources/application-dev.yml` 与 `application-prod.yml` 文件，请将里面的mysql ,redis配置为自己的地址，微信配置见下表

| 配置项  | 说明 |
| ------------- | ------------- |
| mpAppId  | 微信公众平台AppId，可通过申请测试号获取 |
| mpAppSecret  | 微信公众平台AppSecret，可通过申请测试号获取 |
| openAppId  | 微信开放平台AppId，需要企业资质，个人无法获取 |
| openAppSecrect  | 微信开放平台AppSecret，需要企业资质，个人无法获取 |
| mchId  | 微信支付Id，需要企业资质，个人无法获取 |
| mchKey  | 微信支付密钥，需要企业资质，个人无法获取 |
| keyPath  | 微信支付文件路径，需要企业资质，个人无法获取 |
| notifyUrl  | 微信支付异步回调地址 |
| templateId  | 微信模板消息Id，可通过申请测试号获取 |


### 3.微信账号说明
*   微信授权与微信模板消息消息推送，个人可以申请微信测试号进行开发调试。
*   微信支付退款与微信，微信网页扫码登录，需要企业资质，个人不能申请。
*   申请微信测试号 -> [传送门][3]

### 4.相关文档
*   虚拟机说明文档 -> [传送门][4]
*   SQL文档 -> [传送门][5]
*   API文档 -> [传送门][6]
*   功能演示文档 -> [传送门][7]
*   微信公众平台文档 -> [传送门][8]
*   微信开放平台文档 -> [传送门][9]

## 项目部署
*   在Nginx设置如下代理

        location /sell/ {
              proxy_pass http://127.0.0.1:8080/;
        }
        # 保存退出后刷新配置
        nginx -s reload
     
*   打包项目

    	# 项目主目录下
    	mvn clean package -Dmaven.test.skip=true
    	
*   linux下运行项目

        # 启动命令（[]中内容表示可选）
        java -jar [-Dserver.port=自选端口] [-Dspring.profiles.active=prod] jar包名
        
        # 后台启动
        nohup java -jar jar包名 &

## 最后
各位大佬，项目若是对您有一丝帮助还望给个star，这将给予我莫大的鼓舞，感谢各位。另外哪个地方出错也请指出，哪个问题想讨论，可提issue可寄邮件给我。（项目学习自某Mooc收费视频）

  [1]: https://pan.baidu.com/s/1APzfHmSRV_fPk07TkelDFA
  [2]: https://github.com/hdonghong/sell/tree/master/other/doc/show.md
  [3]: https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login
  [4]: https://github.com/hdonghong/sell/tree/master/other/doc/VM.md
  [5]: https://github.com/hdonghong/sell/tree/master/other/doc/SQL.md
  [6]: https://github.com/hdonghong/sell/tree/master/other/doc/API.md
  [7]: https://github.com/hdonghong/sell/tree/master/other/doc/show.md
  [8]: https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
  [9]: https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&lang=zh_CN&token=7080b04f0b3bfac25e563c47068b897a81bc7e56