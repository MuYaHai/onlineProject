package com.cn.dao;

import com.cn.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: MuYaHai
 * Date: 2019/12/1, Time: 20:44
 */
public interface UserRepository extends JpaRepository<User,String> {

    public User findByUsernameAndPassword(String username,String password);
}
