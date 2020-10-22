package cn.hellomyheart.kataba.service.impl;

import cn.hellomyheart.kataba.entity.UserLog;
import cn.hellomyheart.kataba.mapper.UserLogMapper;
import cn.hellomyheart.kataba.service.intf.UserLogService;
import cn.hellomyheart.kataba.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @className: UserLogServiceImpl
 * @package: cn.hellomyheart.kataba.service.impl
 * @author: Stephen Shen
 * @date: 2020/10/20 下午12:50
 */
@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogMapper userLogMapper;

    @Override
    public ResponseResult save(UserLog userLog) {
        return null;
    }

    @Override
    public ResponseResult all() {
        return ResponseResult.ok(userLogMapper.selectList(null));
    }
}
