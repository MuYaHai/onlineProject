package com.cn.dao;

import com.cn.pojo.Advice;
import com.cn.pojo.Result;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: MuYaHai
 * Date: 2019/12/1, Time: 22:17
 */
public interface AdviceRepository extends JpaRepository<Advice,String> {
    public Advice findByIpadd(String ip);
}
