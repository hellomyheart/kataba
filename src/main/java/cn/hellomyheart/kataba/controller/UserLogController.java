package cn.hellomyheart.kataba.controller;

import cn.hellomyheart.kataba.service.intf.UserLogService;
import cn.hellomyheart.kataba.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @className: UserLogController
 * @package: cn.hellomyheart.kataba.controller
 * @author: Stephen Shen
 * @date: 2020/10/22 上午9:18
 */
@RestController
@RequestMapping("/api/userlog/")
public class UserLogController {

    @Autowired
    private UserLogService service;

    @GetMapping("all.do")
    public ResponseResult all(){
        return service.all();
    }
}
