package cn.hellomyheart.kataba.service.intf;

import cn.hellomyheart.kataba.vo.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @description
 * @className: OssService
 * @package: cn.hellomyheart.kataba.service.intf
 * @author: Stephen Shen
 * @date: 2020/10/22 上午9:25
 */
public interface OssService {
    ResponseResult upload(String token, MultipartFile file) throws IOException;
}
