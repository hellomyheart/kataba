package cn.hellomyheart.kataba.service.impl;

import cn.hellomyheart.kataba.config.RedisKeyConfig;
import cn.hellomyheart.kataba.dto.SmsCodeDto;
import cn.hellomyheart.kataba.mapper.SmsLogMapper;
import cn.hellomyheart.kataba.service.intf.SmsLogService;
import cn.hellomyheart.kataba.third.JedisUtil;
import cn.hellomyheart.kataba.third.SmsUtil;
import cn.hellomyheart.kataba.util.NumRandomUtil;
import cn.hellomyheart.kataba.util.StrUtil;
import cn.hellomyheart.kataba.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @className: SmsLogServiceImpl
 * @package: cn.hellomyheart.kataba.service.impl
 * @author: Stephen Shen
 * @date: 2020/10/20 上午11:29
 */
@Service
public class SmsLogServiceImpl implements SmsLogService {

    @Autowired
    private SmsLogMapper smsLogMapper;

    @Override
    public ResponseResult sendRCode(String phone) {
        //生成验证码
        int code = NumRandomUtil.randomNum(6);

        //发送验证码
        if (SmsUtil.sendRCode(phone, code)) {
            //存储验证码
            JedisUtil.getInstance().STRINGS.setEx(RedisKeyConfig.SMS_RCODE + phone, RedisKeyConfig.RCODE_TIME, code + "");
            //结果返回
            return ResponseResult.ok();
        }
        return ResponseResult.fail();
    }

    @Override
    public ResponseResult checkRCode(SmsCodeDto dto) {
        if (StrUtil.checkNoEmpty(dto.getPhone())) {
            String key = RedisKeyConfig.SMS_RCODE + dto.getPhone();
            //验证码存在
            if (JedisUtil.getInstance().getJedis().exists(key)) {
                //验证码匹配
                if (dto.getCode() == Integer.parseInt(JedisUtil.getInstance().STRINGS.get(key))) {
                    return ResponseResult.ok();
                }
            }
        }
        return ResponseResult.fail();
    }
}
