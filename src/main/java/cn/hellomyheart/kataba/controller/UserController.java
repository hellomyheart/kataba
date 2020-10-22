package cn.hellomyheart.kataba.controller;

import cn.hellomyheart.kataba.dto.UserDto;
import cn.hellomyheart.kataba.dto.UserLoginDto;
import cn.hellomyheart.kataba.service.intf.UserService;
import cn.hellomyheart.kataba.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description 用户控制器
 * @className: UserController
 * @package: cn.hellomyheart.kataba.controller
 * @author: Stephen Shen
 * @date: 2020/10/19 下午3:36
 */
@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("all.do")
    public ResponseResult all(){
        return userService.all();
    }

    //校验
    @GetMapping("checknickname.do")
    public ResponseResult checkNickname(String name){
        return userService.checkNickName(name);
    }

    @PostMapping("register.do")
    public ResponseResult save (@RequestBody UserDto dto){
        return userService.register(dto);
    }

    @PostMapping("login.do")
    public ResponseResult login(@RequestBody UserLoginDto dto){
        return userService.login(dto);
    }

}
