package me.loveqi.miaoshaproject.service;

import me.loveqi.miaoshaproject.service.model.UserModel;

/**
 * Description: userService 接口，用于定义控制器请求过来的详细用户逻辑的处理方法
 *
 * @author loveqi
 * @date 2018-12-17 23:54
 */
public interface UserService {

    /**
     * 通过用户id获取用户对象并且将对应用户的对象返回给用户请求控制器的方法
     *
     * @param id 用户id
     * @return 核心领域模型用户对象
     */
    UserModel getUserById(Integer id);

}
