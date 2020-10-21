package cn.hellomyheart.kataba.controller;

import cn.hellomyheart.kataba.config.SystemConfig;
import cn.hellomyheart.kataba.service.intf.AlbumLogService;
import cn.hellomyheart.kataba.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @className: AlbumLogController
 * @package: cn.hellomyheart.kataba.controller
 * @author: Stephen Shen
 * @date: 2020/10/21 下午3:10
 */
@RestController
@RequestMapping("/api/albumlog/")
public class AlbumLogController {
    @Autowired
    private AlbumLogService service;

    @GetMapping("all.do")
    public ResponseResult all(HttpServletRequest request){
        return service.queryAll(request.getHeader(SystemConfig.TOKEN_HEADER));
    }
}
