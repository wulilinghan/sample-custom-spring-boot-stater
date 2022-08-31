package top.b0x0.sample.tracespringboot.logback.common;


import java.io.Serializable;

/**
 * BaseResultVo 统一响应体
 *
 * @author tanglinghan Created By 2022-5-18 17:03:10
 **/
public class ResultVo<T> implements Serializable {
    private static final long serialVersionUID = -8814699817810568310L;

    private String resultCode;

    private String resultMsg;

    private T data;

    private ResultVo() {
    }

    private ResultVo(String resultCode, String resultMsg, T data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    private ResultVo(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    private void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    private void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    private void setData(T data) {
        this.data = data;
    }

    public String getResultCode() {
        return resultCode;
    }

    public T getData() {
        return data;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public static <T> ResultVo<T> ok() {
        return new ResultVo<T>("1", "");
    }

    public static <T> ResultVo<T> ok(T data) {
        return new ResultVo<T>("1", "", data);
    }

    public static <T> ResultVo<T> ok(String code, String msg) {
        return new ResultVo<T>(code, msg);
    }

    public static <T> ResultVo<T> error(String resultMsg) {
        return new ResultVo<T>("0", resultMsg);
    }

    public static <T> ResultVo<T> error(String resultCode, String resultMsg) {
        return new ResultVo<T>(resultCode, resultMsg);
    }
}
