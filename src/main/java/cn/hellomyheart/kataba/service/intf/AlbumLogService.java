package cn.hellomyheart.kataba.service.intf;

import cn.hellomyheart.kataba.vo.ResponseResult;

/**
 * @description
 * @className: AlbumLogService
 * @package: cn.hellomyheart.kataba.service.intf
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:19
 */
public interface AlbumLogService {

    /**
     * 查询
     * @param aid
     * @return
     */
    ResponseResult query(int aid);


    /**
     * 查询所有
     * @param token
     * @return
     */
    ResponseResult queryAll(String token);
}
