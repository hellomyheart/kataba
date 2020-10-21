package cn.hellomyheart.kataba.service.impl;

import cn.hellomyheart.kataba.mapper.AlbumLogMapper;
import cn.hellomyheart.kataba.service.intf.AlbumLogService;
import cn.hellomyheart.kataba.util.TokenUtil;
import cn.hellomyheart.kataba.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @className: AlbumLogServiceImpl
 * @package: cn.hellomyheart.kataba.service.impl
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:30
 */
@Service
public class AlbumLogServiceImpl implements AlbumLogService {
    @Autowired
    private AlbumLogMapper albumLogMapper;

    @Override
    public ResponseResult query(int aid) {
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult queryAll(String token) {
        int uid = TokenUtil.getUid(token);
        return ResponseResult.ok(albumLogMapper.all(uid));
    }
}
