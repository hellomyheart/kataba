package cn.hellomyheart.kataba.service.intf;

import cn.hellomyheart.kataba.dto.UserDto;
import cn.hellomyheart.kataba.dto.UserLoginDto;
import cn.hellomyheart.kataba.entity.User;
import cn.hellomyheart.kataba.vo.ResponseResult;

import java.util.List;

/**
 * @description
 * @className: UserService
 * @package: cn.hellomyheart.kataba.service.intf
 * @author: Stephen Shen
 * @date: 2020/10/19 下午3:46
 */
public interface UserService {

    /**
     * 查询所有用户
     *
     * @return
     */
    ResponseResult all();


    /**
     * 校验手机
     */
    ResponseResult checkPhone(String phone);

    /**
     * 校验昵称
     * @param nickName
     * @return
     */
    ResponseResult checkNickName(String nickName);

    /**
     * 注册
     * @param dto
     * @return
     */
    ResponseResult register(UserDto dto);

    /**
     * 登录
     * @param dto
     * @return
     */
    ResponseResult login(UserLoginDto dto);

    /**
     * 找回密码
     * @param phone
     * @return
     */
    ResponseResult findPass(String phone);


}
