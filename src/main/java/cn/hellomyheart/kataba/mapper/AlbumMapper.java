package cn.hellomyheart.kataba.mapper;

import cn.hellomyheart.kataba.dto.AlbumUpdateDto;
import cn.hellomyheart.kataba.entity.Album;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
 * @description
 * @className: AlbumMapper
 * @package: cn.hellomyheart.kataba.mapper
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:16
 */
public interface AlbumMapper extends BaseMapper<Album> {
    @Update("update t_album set title=#{title},info=#{info} where id=#{id}")
    int updateTitle(AlbumUpdateDto dto);
}
