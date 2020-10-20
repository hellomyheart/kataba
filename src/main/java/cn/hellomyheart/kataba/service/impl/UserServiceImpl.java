package cn.hellomyheart.kataba.service.impl;

import cn.hellomyheart.kataba.config.RedisKeyConfig;
import cn.hellomyheart.kataba.dto.UserDto;
import cn.hellomyheart.kataba.dto.UserLoginDto;
import cn.hellomyheart.kataba.entity.User;
import cn.hellomyheart.kataba.entity.UserLog;
import cn.hellomyheart.kataba.mapper.UserLogMapper;
import cn.hellomyheart.kataba.mapper.UserMapper;
import cn.hellomyheart.kataba.service.intf.UserService;
import cn.hellomyheart.kataba.third.JedisUtil;
import cn.hellomyheart.kataba.third.JwtUtil;
import cn.hellomyheart.kataba.util.EncryptUtil;
import cn.hellomyheart.kataba.util.StrUtil;
import cn.hellomyheart.kataba.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private UserLogMapper userLogMapper;

    @Value("${kataba.passkey")
    private String passkey;

    @Override
    public ResponseResult all() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return ResponseResult.ok(userMapper.selectList(queryWrapper));
    }

    @Override
    public ResponseResult checkPhone(String phone) {
        if (StrUtil.checkNoEmpty(phone)) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("phone", phone);
            if (userMapper.selectOne(queryWrapper) != null) {
                //存在 不可用
                return ResponseResult.fail();
            } else {
                //不存在 可用
                return ResponseResult.ok();
            }
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult checkNickName(String nickName) {
        if (StrUtil.checkNoEmpty(nickName)) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("nickname", nickName);
            if (userMapper.selectOne(queryWrapper) != null) {
                //存在 不可用
                return ResponseResult.fail();
            } else {
                //不存在 可用
                return ResponseResult.ok();
            }
        }
        return ResponseResult.fail();
    }

    /**
     * 注册
     *
     * @param dto
     * @return
     */
    @Override
    public ResponseResult register(UserDto dto) {

        //校验用户名是否可用
        User user = userMapper.selectByNamePhone(dto.getNickname(), dto.getPhone());
        if (user == null) {
            //密码 密文 AES
            dto.setPassword(EncryptUtil.aesenc(passkey, dto.getPassword()));
            //User对象
            user = new User(dto.getPhone(), dto.getNickname(), dto.getPassword(), 1);
            if (userMapper.insert(user) > 0) {
                //记录日志
                UserLog userLog = new UserLog(user.getId(), 1, "注册新用户", new Date());
                userLogMapper.insert(userLog);
                return ResponseResult.ok();
            }
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult login(UserLoginDto dto) {
        //如何实现 10分钟 登录失败3次 锁定账号2小时
        //1.校验
        User user = userMapper.selectByName(dto.getName());
        if (user != null) {
            if (EncryptUtil.aesenc(passkey, dto.getPassword()).equals(user.getPassword())) {
                //2.密码一致
                //3.生成令牌
                String token = JwtUtil.createToken(user.getPhone());
                //4.存储令牌
                //记录令牌 对应的用户
                JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.LOGIN_TOKEN + token, RedisKeyConfig.LOGIN_TIME, new JSONObject(user).toString());
                //记录登录过的账号信息
                JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.LOGIN_USER + user.getId(), RedisKeyConfig.LOGIN_TIME, token);
                //5.返回
                return ResponseResult.ok(token);
            }
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult findPass(String phone) {
        return null;
    }
}
