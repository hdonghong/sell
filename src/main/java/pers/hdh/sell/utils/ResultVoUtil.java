package pers.hdh.sell.utils;

import pers.hdh.sell.vo.ResultVo;

/**
 * ResultVoUtil class<br/>
 * http返回的最外层对象的工具类
 * @author hdonghong
 * @date 2018/04/03
 */
public class ResultVoUtil {

    public static ResultVo success(Object data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
