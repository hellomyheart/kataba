package cn.hellomyheart.kataba.mapper;

import cn.hellomyheart.kataba.entity.AlbumLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description
 * @className: AlbumLogMapper
 * @package: cn.hellomyheart.kataba.mapper
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:17
 */
public interface AlbumLogMapper extends BaseMapper<AlbumLog> {
    @Select("select al.* from t_albumlog al inner join t_album a on a.id=al.aid where a.uid=#{uid}")
    List<AlbumLog> all(int uid);
}
