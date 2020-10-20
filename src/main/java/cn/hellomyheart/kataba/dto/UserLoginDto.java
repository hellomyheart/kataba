package cn.hellomyheart.kataba.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description
 * @className: UserLoginDto
 * @package: cn.hellomyheart.kataba.dto
 * @author: Stephen Shen
 * @date: 2020/10/20 上午9:21
 */
@Data
public class UserLoginDto implements Serializable {
    private static final long serialVersionUID = -5526446838546754523L;
    /**
     *  nickname or phone
     */
    private String name;

    /**
     * password
     */
    private String password;
}
