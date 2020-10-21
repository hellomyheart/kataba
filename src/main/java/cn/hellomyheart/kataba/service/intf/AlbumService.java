package cn.hellomyheart.kataba.service.intf;

import cn.hellomyheart.kataba.dto.AlbumDto;
import cn.hellomyheart.kataba.dto.AlbumUpdateDto;
import cn.hellomyheart.kataba.vo.ResponseResult;

/**
 * @description
 * @className: AlbumService
 * @package: cn.hellomyheart.kataba.service.intf
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:21
 */
public interface AlbumService {
    /**
     * 新建
     * @param token
     * @param dto
     * @return
     */
    ResponseResult save(String token, AlbumDto dto);

    /**
     * 修改
     * @param token
     * @param dto
     * @return
     */
    ResponseResult update(String token, AlbumUpdateDto dto);

    /**
     * 查询
     * @param token
     * @return
     */
    ResponseResult query(String token);
}
