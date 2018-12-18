package me.loveqi.miaoshaproject.controller;

import me.loveqi.miaoshaproject.controller.viewobject.UserVO;
import me.loveqi.miaoshaproject.service.UserService;
import me.loveqi.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: User请求控制器，用于分发用户请求的操作。
 *
 * @author loveqi
 * @date 2018-12-17 23:52
 */
@Controller("user")
@RequestMapping("/user")
public class UserController {

    /**
     * user业务层对象
     */
    @Autowired
    private UserService userService;

    /**
     * 根据用户的id将对应的用户对象查询出来并返回给前端
     *
     * @param id 用户id
     * @return 查询出的对应的用户对象
     */
    @RequestMapping("/get")
    @ResponseBody
    public UserVO getUser(@RequestParam(name = "id") Integer id) {
        // 调用 service 服务获取对应id 的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);

        // 将核心领域模型用户对象转化为可供UI使用的 ViewObject 并返回
        return convertFromModel(userModel);
    }

    /**
     * 类型转换方法，将核心领域模型用户对象转化为可供UI使用的ViewObject用户对象
     *
     * @param userModel 核心领域模型用户对象
     * @return ViewObject用户对象
     */
    private UserVO convertFromModel(UserModel userModel) {

        // 判断 userModel 是否为空
        if (userModel == null) {
            // 若为空则直接返回 null
            return null;
        }

        // 若不为空进行以下操作
        // 创建一个新的VO用户对象
        UserVO userVO = new UserVO();

        // 使用 spring 工具类提供的 beanUtils 将 userModel 的属性 copy 到 用户 VO 对象里面去
        BeanUtils.copyProperties(userModel, userVO);

        // 将用户 VO 对象返回
        return userVO;
    }

}
