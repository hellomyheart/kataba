package cn.hellomyheart.kataba.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description
 * @className: SmsCodeDto
 * @package: cn.hellomyheart.kataba.dto
 * @author: Stephen Shen
 * @date: 2020/10/20 上午11:24
 */
@Data
public class SmsCodeDto implements Serializable {

    private static final long serialVersionUID = 8768615790784835165L;

    private String phone;
    private int code;
}
