package cn.hellomyheart.kataba.controller;

import cn.hellomyheart.kataba.config.SystemConfig;
import cn.hellomyheart.kataba.dto.AlbumDto;
import cn.hellomyheart.kataba.dto.AlbumUpdateDto;
import cn.hellomyheart.kataba.service.intf.AlbumService;
import cn.hellomyheart.kataba.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @className: AlbumController
 * @package: cn.hellomyheart.kataba.controller
 * @author: Stephen Shen
 * @date: 2020/10/21 下午3:08
 */
@RestController
@RequestMapping("/api/album/")
public class AlbumController {
    @Autowired
    private AlbumService service;

    @PostMapping("save.do")
    public ResponseResult save(@RequestBody AlbumDto dto, HttpServletRequest request){
        return service.save(request.getHeader(SystemConfig.TOKEN_HEADER),dto);
    }
    @PutMapping("update.do")
    public ResponseResult update(@RequestBody AlbumUpdateDto dto, HttpServletRequest request){
        return service.update(request.getHeader(SystemConfig.TOKEN_HEADER),dto);
    }
    @GetMapping("update.do")
    public ResponseResult query(HttpServletRequest request){
        return service.query(request.getHeader(SystemConfig.TOKEN_HEADER));
    }
}
