package com.cn.service;

import com.cn.dao.AdviceRepository;
import com.cn.dao.KeyRepository;
import com.cn.dao.UserRepository;
import com.cn.pojo.Advice;
import com.cn.pojo.Key;
import com.cn.pojo.Result;
import com.cn.pojo.User;
import com.cn.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author: MuYaHai
 * Date: 2019/12/1, Time: 22:01
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AdviceRepository adviceRepository;
    @Autowired
    KeyRepository keyRepository;

    public Result login(String username,String password) {
        User loginUser = userRepository.findByUsernameAndPassword(username, password);
        if (loginUser != null) {
            Result result = new Result();
            result.setMessage("登录成功");
            result.setFlag(true);
            result.setData(loginUser);
            return result;
        }
        return new Result(false,"用户名或密码错误",loginUser);
    }

    public Result advice(Advice advice, String ip) {
        Advice advice1  = adviceRepository.findByIpadd(ip);
        if (advice1 != null) {
            return new Result(false, "您已提交过了，切勿重复提交",advice1);
        }
        advice.setIpadd(ip);
        try {
            String date = DateUtils.parseDate2String(new Date());
            advice.setAddTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Advice save = adviceRepository.save(advice);
        if (save == null) {
            return new Result(false, "提交失败，请稍后再试！", null);
        }
        return new Result(true,"提交成功，请勿重复提交",advice);
    }

    public Result register(User user) {
        Key byKey = keyRepository.findByKey(user.getKey());
        if (byKey != null && "0".equals(byKey.getStatus())) {
            byKey.setStatus("1");
            keyRepository.save(byKey);
            try {
                user.setRegTime(DateUtils.parseDate2String(new Date()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            userRepository.save(user);
            return new Result(true, "注册成功！", user);
        }
        return new Result(false,"无效key，注册失败！",null);
    }

    public Result getUserName(String id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            return new Result(true, "", user);
        }
        return new Result(false, "", null);
    }
}
