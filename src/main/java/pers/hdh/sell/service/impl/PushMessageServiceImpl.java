package pers.hdh.sell.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.hdh.sell.config.WechatAccountConfig;
import pers.hdh.sell.dto.OrderDto;
import pers.hdh.sell.service.PushMessageService;

import java.util.Arrays;
import java.util.List;

/**
 * PushMessageServiceImpl class<br/>
 * 消息推送
 * @author hdonghong
 * @date 2018/04/11
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig accountConfig;

    @Override
    public void orderStatus(OrderDto orderDto) {
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
        wxMpTemplateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
        wxMpTemplateMessage.setToUser(orderDto.getOrderId());

        List<WxMpTemplateData> dataList = Arrays.asList(
                new WxMpTemplateData("first", "亲，请记得收货。"),
                new WxMpTemplateData("keyword1", "微信点餐"),
                new WxMpTemplateData("keyword2", "123456789012"),
                new WxMpTemplateData("keyword3", orderDto.getOrderId()),
                new WxMpTemplateData("keyword4", orderDto.getOrderStatusEnum().getMsg()),
                new WxMpTemplateData("keyword5", "￥"+orderDto.getOrderAmount()),
                new WxMpTemplateData("remark", "欢迎再次光临！")
        );
        wxMpTemplateMessage.setData(dataList);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】 发送失败，{}", e);
        }
    }
}
