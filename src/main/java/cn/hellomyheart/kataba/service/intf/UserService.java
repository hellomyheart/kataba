package cn.hellomyheart.kataba.service.intf;

import cn.hellomyheart.kataba.entity.User;
import cn.hellomyheart.kataba.vo.ResponseResult;

import java.util.List;

/**
 * @description
 * @className: UserService
 * @package: cn.hellomyheart.kataba.service.intf
 * @author: Stephen Shen
 * @date: 2020/10/19 下午3:46
 */
public interface UserService {
    public ResponseResult<List<User>> all();
}
