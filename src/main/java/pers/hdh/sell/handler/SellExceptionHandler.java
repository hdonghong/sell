package pers.hdh.sell.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.hdh.sell.config.ProjectUrlConfig;
import pers.hdh.sell.exception.SellException;
import pers.hdh.sell.exception.SellerAuthorizaException;
import pers.hdh.sell.utils.ResultVoUtil;
import pers.hdh.sell.vo.ResultVo;

/**
 * ExceptionHandler class<br/>
 *
 * @author hdonghong
 * @date 2018/04/11
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    // 拦截登录异常
    @ExceptionHandler(value = SellerAuthorizaException.class)
    public ModelAndView handleAuthorizeException() {
//        return new ModelAndView("redirect:"
//                + projectUrlConfig.getWechatOpenAuthorize()
//                + "/sell/wechat/qrAuthorize?returnUrl="
//                + projectUrlConfig.getSell()
//                + "/sell/seller/login");

//      由于微信开放平台网页扫码登录需要公司注册，故增加此页面作后台测试用
        return new ModelAndView("common/login");
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVo handleSellException(SellException e) {
        return ResultVoUtil.error(e.getCode(), e.getMessage());
    }


}
