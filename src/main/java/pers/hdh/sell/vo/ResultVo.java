package pers.hdh.sell.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * ResultVo class<br/>
 * http返回的最外层对象
 * @author hdonghong
 * @date 2018/04/03
 */
@Data
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID = -8730161854744420763L;

    /** 状态码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;
}
