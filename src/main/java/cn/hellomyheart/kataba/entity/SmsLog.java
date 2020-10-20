package cn.hellomyheart.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * @className: SmsLog
 * @package: cn.hellomyheart.kataba.entity
 * @author: Stephen Shen
 * @date: 2020/10/20 上午9:27
 */
@Data
@TableName("t_smslog")
public class SmsLog implements Serializable {
    private static final long serialVersionUID = -4695517863186661310L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private Integer type;
    private String content;
    private Date ctime;
}
