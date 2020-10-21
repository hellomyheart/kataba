package cn.hellomyheart.kataba.util;

import cn.hellomyheart.kataba.config.RedisKeyConfig;
import cn.hellomyheart.kataba.third.JedisUtil;
import org.json.JSONObject;

/**
 * @description
 * @className: TokenUtil
 * @package: cn.hellomyheart.kataba.util
 * @author: Stephen Shen
 * @date: 2020/10/21 上午11:11
 */
public class TokenUtil {
    //获取用户id
    public static int getUid(String token){
        return new JSONObject(JedisUtil.getInstance().STRINGS.
                get(RedisKeyConfig.LOGIN_TOKEN+token)).getInt("id");
    }
}
