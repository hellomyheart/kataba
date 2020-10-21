package cn.hellomyheart.kataba.service.impl;

import cn.hellomyheart.kataba.dto.AlbumDto;
import cn.hellomyheart.kataba.dto.AlbumUpdateDto;
import cn.hellomyheart.kataba.entity.Album;
import cn.hellomyheart.kataba.entity.AlbumLog;
import cn.hellomyheart.kataba.mapper.AlbumLogMapper;
import cn.hellomyheart.kataba.mapper.AlbumMapper;
import cn.hellomyheart.kataba.service.intf.AlbumService;
import cn.hellomyheart.kataba.util.TokenUtil;
import cn.hellomyheart.kataba.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @description
 * @className: AlbumServiceImpl
 * @package: cn.hellomyheart.kataba.service.impl
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:35
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumLogMapper albumLogMapper;


    @Override
    //开启事务
    @Transactional
    public ResponseResult save(String token, AlbumDto dto) {
        //获取用户ID
        int uid = TokenUtil.getUid(token);
        //实例化相册对象
        Album album = new Album(uid, dto.getTitle(), dto.getInfo(), dto.getType(), new Date());
        //新增相册
        if (albumMapper.insert(album) > 0) {
            //实例化日志
            AlbumLog albumLog = new AlbumLog(album.getId(), uid + "-创建相册", 1, new Date());
            albumLogMapper.insert(albumLog);
            return ResponseResult.ok();
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult update(String token, AlbumUpdateDto dto) {
        if (albumMapper.updateTitle(dto)>0){
            //实例化日志
            AlbumLog albumLog=new AlbumLog(dto.getId(),"修改相册",2,new Date());
            albumLogMapper.insert(albumLog);
            return ResponseResult.ok();
        }
       return ResponseResult.fail();
    }

    @Override
    public ResponseResult query(String token) {
        int uid = TokenUtil.getUid(token);
        QueryWrapper<Album> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("uid",uid);
        queryWrapper.orderByDesc("ctime");
        return ResponseResult.ok(albumMapper.selectList(queryWrapper));
    }
}
