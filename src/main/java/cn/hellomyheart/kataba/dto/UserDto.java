package cn.hellomyheart.kataba.dto;

import lombok.Data;

/**
 * @description 用户Dto
 * @className: UserDto
 * @package: cn.hellomyheart.kataba.dto
 * @author: Stephen Shen
 * @date: 2020/10/19 下午5:38
 */
@Data
public class UserDto {
    /**
     * 手机号
     */
    private String phone;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;
}
