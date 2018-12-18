package me.loveqi.miaoshaproject.controller.viewobject;

/**
 * Description: UserVO 类，真正与前端交互的类。
 *
 * @author loveqi
 * @date 2018-12-18 00:22
 */
public class UserVO {

    private Integer id;

    private String name;

    private Byte gender;

    private Integer age;

    private String telphone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
