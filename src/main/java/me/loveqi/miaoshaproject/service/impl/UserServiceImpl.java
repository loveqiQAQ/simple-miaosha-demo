package me.loveqi.miaoshaproject.service.impl;

import me.loveqi.miaoshaproject.dao.UserDOMapper;
import me.loveqi.miaoshaproject.dao.UserPasswordDOMapper;
import me.loveqi.miaoshaproject.dataobject.UserDO;
import me.loveqi.miaoshaproject.dataobject.UserPasswordDO;
import me.loveqi.miaoshaproject.service.UserService;
import me.loveqi.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: userService接口的实现类，用于给 UserService 定义的方法的具体实现
 *
 * @author loveqi
 * @date 2018-12-17 23:55
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 注入 userDataObject 查询对象
     */
    @Autowired
    private UserDOMapper userDOMapper;

    /**
     * 注入 userPasswordDataObject 查询对象
     */
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    /**
     * 给 userService 定义的通过用户id获取用户对象并且将对应用户的对象返回给用户请求控制器的方法的具体实现
     *
     * @param id 用户id
     * @return 核心领域模型用户对象
     */
    @Override
    public UserModel getUserById(Integer id) {

        // 调用 userDOMapper 获取到对应的用户 dataObject
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);

        // 判断 userDO 是否为空
        if (userDO == null) {

            // 如果为空直接返回 null
            return null;
        }

        // 如果不为空执行以下操作
        // 通过用户id获取对应的用户加密密码信息
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(id);

        // 将 UserDataObject 和 UserPasswordDataObject 组合转化为核心领域模型用户对象并返回
        return convertFromDataObject(userDO, userPasswordDO);

    }

    /**
     * 类型转换方法，将 UserDataObject 和 UserPasswordDataObject 组合转化为核心领域模型用户对象
     *
     * @param userDO 用户DataObject
     * @param userPasswordDO 用户密码DataObject
     * @return 核心领域模型用户对象
     */
    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPasswordDO) {

        // 判断 userDO 是否为空
        if (userDO == null) {
            // 如果为空直接返回 null
            return null;
        }

        // 如果不为空执行以下操作
        // 创建一个新的核心领域模型用户对象
        UserModel userModel = new UserModel();
        // 使用 spring 工具类提供的 beanUtils 将 userDO 的属性 copy 到核心领域模型用户对象里面去
        BeanUtils.copyProperties(userDO, userModel);

        // 判断 userPasswordDO 是否为空
        if (userPasswordDO != null) {
            // 如果不为空，给核心领域模型用户对象里的加密密码属性设置上 userPasswordDO 里加密密码属性的值
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }

        // 将核心领域模型用户对象返回
        return userModel;
    }

}
