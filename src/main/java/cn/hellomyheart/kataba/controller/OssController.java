package cn.hellomyheart.kataba.controller;

import cn.hellomyheart.kataba.config.SystemConfig;
import cn.hellomyheart.kataba.service.intf.OssService;
import cn.hellomyheart.kataba.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description
 * @className: OssController
 * @package: cn.hellomyheart.kataba.controller
 * @author: Stephen Shen
 * @date: 2020/10/22 上午9:01
 */
@RestController
@RequestMapping("/api/oss/")
public class OssController {

    @Autowired
    private OssService service;

    @PostMapping("upload.do")
    public ResponseResult upload(MultipartFile file, HttpServletRequest request) throws IOException {
        return service.upload(request.getHeader(SystemConfig.TOKEN_HEADER),file);
    }
}
