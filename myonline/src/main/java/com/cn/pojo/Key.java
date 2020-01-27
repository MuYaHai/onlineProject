package com.cn.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: MuYaHai
 * Date: 2019/12/1, Time: 22:22
 */
@Data
@Entity
@Table(name = "tb_key")
public class Key implements Serializable {
    @Id
    private long id;
    @Column(name="keynum")
    private String key;
    @Column(name="reg_time")
    private String regTime;
    private String status;
}
