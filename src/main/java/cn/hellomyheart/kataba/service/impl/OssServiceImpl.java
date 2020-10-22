package cn.hellomyheart.kataba.service.impl;

import cn.hellomyheart.kataba.entity.OssLog;
import cn.hellomyheart.kataba.mapper.OssLogMapper;
import cn.hellomyheart.kataba.service.intf.OssService;
import cn.hellomyheart.kataba.third.AliOssUtil;
import cn.hellomyheart.kataba.util.StrUtil;
import cn.hellomyheart.kataba.util.TokenUtil;
import cn.hellomyheart.kataba.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @description
 * @className: OssServiceImpl
 * @package: cn.hellomyheart.kataba.service.impl
 * @author: Stephen Shen
 * @date: 2020/10/22 上午9:28
 */
@Service
public class OssServiceImpl implements OssService {

    @Autowired
    private OssLogMapper logMapper;


    @Override
    public ResponseResult upload(String token, MultipartFile file) throws IOException {
        int uid = TokenUtil.getUid(token);
        if (!file.isEmpty()) {

            String fillname = rename(file.getOriginalFilename());
            String url = AliOssUtil.uploadByte(AliOssUtil.BucketName, fillname, file.getBytes());
            if (StrUtil.checkNoEmpty(url)) {
                //持久化
                OssLog ossLog = new OssLog(uid, AliOssUtil.BucketName, fillname, 1, new Date());
                logMapper.insert(ossLog);
                return ResponseResult.ok();
            }
        }
        return ResponseResult.fail();
    }

    /**
     * 文件名的处理
     *
     * @param f
     * @return
     */
    private String rename(String f) {
        if (f.length() > 50) {
            f = f.substring(f.length() - 50);
        }
        //重命名
        return UUID.randomUUID().toString().replaceAll("-", "") + "_" + f;
    }
}
