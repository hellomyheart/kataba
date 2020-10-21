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
 * @className: Album
 * @package: cn.hellomyheart.kataba.entity
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:12
 */
@Data
@TableName("t_album")
@NoArgsConstructor
public class Album implements Serializable {
    private static final long serialVersionUID = 8894388232085700975L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private String title;
    private String info;
    private Integer type;
    private Date ctime;

    public Album(Integer uid, String title, String info, Integer type, Date ctime) {
        this.uid = uid;
        this.title = title;
        this.info = info;
        this.type = type;
        this.ctime = ctime;
    }
}
