package cn.hellomyheart.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @description
 * @className: AlbumShare
 * @package: cn.hellomyheart.kataba.entity
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:14
 */
@Data
@TableName("t_albumshare")
public class AlbumShare {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer aid;
    private Integer uid;
    private String title;
    private String aurl;
    private String acode;
    private Integer type;
    private Integer flag;
    private Date ctime;
}
