package cn.hellomyheart.kataba.service.impl;

import cn.hellomyheart.kataba.entity.User;
import cn.hellomyheart.kataba.mapper.UserMapper;
import cn.hellomyheart.kataba.service.intf.UserService;
import cn.hellomyheart.kataba.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @className: UserServiceImpl
 * @package: cn.hellomyheart.kataba.service.impl
 * @author: Stephen Shen
 * @date: 2020/10/19 下午3:47
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseResult<List<User>> all() {
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return ResponseResult.ok(userMapper.selectList(queryWrapper));
    }
}
