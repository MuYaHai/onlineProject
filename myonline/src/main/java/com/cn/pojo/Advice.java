package com.cn.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: MuYaHai
 * Date: 2019/12/1, Time: 22:09
 */
@Data
@Entity
@Table(name = "tb_advice")
public class Advice implements Serializable {
    @Id
    private long id;
    private String text;
    private String name;
    private String sex;
    @Column(name="add_time")
    private String addTime;
    private String ipadd;
}
