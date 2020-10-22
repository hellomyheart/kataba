package cn.hellomyheart.kataba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description
 * @className: OssLog
 * @package: cn.hellomyheart.kataba.entity
 * @author: Stephen Shen
 * @date: 2020/10/22 上午9:23
 */
@Data
@TableName("t_osslog")
@NoArgsConstructor
public class OssLog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private String bname;
    private String objname;
    private Integer flag;
    private Date ctime;

    public OssLog(Integer uid, String bname, String objname, Integer flag, Date ctime) {
        this.uid = uid;
        this.bname = bname;
        this.objname = objname;
        this.flag = flag;
        this.ctime = ctime;
    }
}
