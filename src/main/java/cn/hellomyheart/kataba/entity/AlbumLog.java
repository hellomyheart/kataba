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
 * @className: AlbumLog
 * @package: cn.hellomyheart.kataba.entity
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:13
 */
@Data
@TableName("t_albumlog")
@NoArgsConstructor
public class AlbumLog implements Serializable {
    private static final long serialVersionUID = -7864279120693847589L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer aid;
    private String info;
    private Integer type;
    private Date ctime;

    public AlbumLog(Integer aid, String info, Integer type, Date ctime) {
        this.aid = aid;
        this.info = info;
        this.type = type;
        this.ctime = ctime;
    }
}
