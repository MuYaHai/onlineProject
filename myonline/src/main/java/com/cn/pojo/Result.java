package com.cn.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: MuYaHai
 * Date: 2019/12/1, Time: 21:20
 */
@Data
@ToString
public class Result implements Serializable {
    private boolean flag;//执行结果，true为执行成功 false为执行失败
    private String message;//返回结果信息
    private Object data;//返回数据

    public Result() {
    }

    public Result(boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }
}
