package com.cn.dao;

import com.cn.pojo.Key;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: MuYaHai
 * Date: 2019/12/1, Time: 22:24
 */
public interface KeyRepository extends JpaRepository<Key,String> {
    public Key findByKey(String key);
}
