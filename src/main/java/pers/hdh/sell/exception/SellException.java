package pers.hdh.sell.exception;

import pers.hdh.sell.constants.ResultEnum;

/**
 * SellException class<br/>
 *
 * @author hdonghong
 * @date 2018/04/04
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
