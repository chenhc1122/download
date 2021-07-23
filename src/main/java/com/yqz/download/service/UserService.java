package com.yqz.download.service;

import com.yqz.download.Mapper.UserMapper;
import com.yqz.download.pojo.Result;
import com.yqz.download.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Result regist(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            User existUser = userMapper.findUserByName(user.getUsername());
            if(existUser != null){
                //如果用户名已存在
                result.setMsg("用户名已存在");

            }else{
                userMapper.regist(user);
                //System.out.println(user.getId());
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    public Result login(User user,String username,String password) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            System.out.println("-------mybatis错误-------"+"username="+username+"---------"+"password="+password);
            Long userId= userMapper.login(username,password);
            if(userId == null){
                result.setMsg("用户名或密码错误");
            }else{
                System.out.println("-------mybatis错误-------"+"username="+user.getUsername()+"---------"+"password="+user.getPassword());
                result.setMsg("登录成功");
                result.setSuccess(true);
                user.setId(userId);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
