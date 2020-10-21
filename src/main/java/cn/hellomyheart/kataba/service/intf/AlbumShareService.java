package cn.hellomyheart.kataba.service.intf;

import cn.hellomyheart.kataba.dto.AlbumShareDto;
import cn.hellomyheart.kataba.vo.ResponseResult;

/**
 * @description
 * @className: AlbumShareService
 * @package: cn.hellomyheart.kataba.service.intf
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:27
 */
public interface AlbumShareService {

    /**
     * 创建
     * @param token
     * @param dto
     * @return
     */
    ResponseResult save(String token, AlbumShareDto dto);

    /**
     * 修改 停止分享
     * @param id
     * @return
     */
    ResponseResult stopShare(int id);
}
