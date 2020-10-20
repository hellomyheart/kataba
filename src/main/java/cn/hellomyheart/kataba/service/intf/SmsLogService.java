package cn.hellomyheart.kataba.service.intf;

import cn.hellomyheart.kataba.dto.SmsCodeDto;
import cn.hellomyheart.kataba.vo.ResponseResult;
/**
 * @description
 * @className: SmsLogService
 * @package: cn.hellomyheart.kataba.service.intf
 * @author: Stephen Shen
 * @date: 2020/10/20 上午11:28
 */
public interface SmsLogService {

    /**
     * 发送注册验证码
     * @param phone
     * @return
     */
    ResponseResult sendRCode(String phone);

    /**
     * 验证验证码
     * @param dto
     * @return
     */
    ResponseResult checkRCode(SmsCodeDto dto);
}
