package cn.hellomyheart.kataba.controller;

import cn.hellomyheart.kataba.dto.SmsCodeDto;
import cn.hellomyheart.kataba.service.intf.SmsLogService;
import cn.hellomyheart.kataba.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @className: SmsController
 * @package: cn.hellomyheart.kataba.controller
 * @author: Stephen Shen
 * @date: 2020/10/20 上午9:25
 */
@RestController
@RequestMapping("/api/sms")
public class SmsController {

    @Autowired
    private SmsLogService smsLogService;

    //发送短信验证码
    @PostMapping("/senmsgcode/{phone}")
    public ResponseResult sendMsgCode(@PathVariable String phone){
        return smsLogService.sendRCode(phone);
    }

    //校验短信验证码
    @PostMapping("/checkmsgcode.do")
    public ResponseResult checkMsgCode(@RequestBody SmsCodeDto dto){
        return smsLogService.checkRCode(dto);
    }


}
