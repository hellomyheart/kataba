package cn.hellomyheart.kataba.service.intf;

import cn.hellomyheart.kataba.entity.UserLog;
import cn.hellomyheart.kataba.vo.ResponseResult;

/**
 * @description
 * @className: UserLogService
 * @package: cn.hellomyheart.kataba.service.intf
 * @author: Stephen Shen
 * @date: 2020/10/20 上午11:40
 */
public interface UserLogService {
    /**
     * 新增
     * @param userLog
     * @return
     */
    ResponseResult save(UserLog userLog);

    /**
     * 查询
     * @return
     */
    ResponseResult all();
}
