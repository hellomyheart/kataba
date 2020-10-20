package cn.hellomyheart.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * @className: UserLog
 * @package: cn.hellomyheart.kataba.entity
 * @author: Stephen Shen
 * @date: 2020/10/20 上午9:18
 */
@Data
@TableName("t_userlog")
@NoArgsConstructor
public class UserLog  implements Serializable {
    private static final long serialVersionUID = 5097537409169661198L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer type;
    private String content;
    private Date ctime;
    public UserLog(Integer uid, Integer type, String content, Date ctime) {
        this.uid = uid;
        this.type = type;
        this.content = content;
        this.ctime = ctime;
    }
}
