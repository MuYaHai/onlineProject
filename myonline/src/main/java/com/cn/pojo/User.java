package com.cn.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: MuYaHai
 * Date: 2019/12/1, Time: 21:20
 */
@Data
@ToString
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    @Id
    private long id;
    @Column(name="reg_time")
    private String regTime;
    private String username;
    private String password;
    @Column(name="keynum")
    private String key;
    private String age;
    private String remember;

}
