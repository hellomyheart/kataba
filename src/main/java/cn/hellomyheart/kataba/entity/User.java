package cn.hellomyheart.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description
 * @className: User
 * @package: cn.hellomyheart.kataba.entity
 * @author: Stephen Shen
 * @date: 2020/10/19 下午3:42
 */
@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private String nickname;
    private String password;
    /**
     * 标记位 1有效  2无效
     */
    private int flag;
}
