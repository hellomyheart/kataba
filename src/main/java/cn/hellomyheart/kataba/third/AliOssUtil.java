package cn.hellomyheart.kataba.third;

import cn.hellomyheart.kataba.util.DateUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.Bucket;
import cn.hellomyheart.kataba.config.SystemConfig;

import java.io.ByteArrayInputStream;

/**
 * @description
 * @className: AliOssUtil
 * @package: cn.hellomyheart.kataba.third
 * @author: Stephen Shen
 * @date: 2020/10/22 上午9:35
 */
public class AliOssUtil {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static final String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
    private static final String accessKeyId = "LTAI4GGEDdAHoscQnVrZk3Ta";
    private static final String accessKeySecret = "U7l8jYLfl4ALq1xTySDa8x4RoATUjF";
    public static final String BucketName = "zzjava-2004";
    private static OSS ossClient;
    static {
        // 创建OSSClient实例
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }
    //创建存储空间
    public static boolean createBucket(String name){
        Bucket b=ossClient.createBucket(name);
        return b!=null;
    }
    //上传内容
    public static String uploadByte(String bucket,String objname,byte[] data){
        ossClient.putObject(bucket,objname,new ByteArrayInputStream(data));
        return getUrl(bucket, objname);
    }
    //删除文件
    public static boolean delObj(String bucketName,String objname){
        ossClient.deleteObject(bucketName, objname);
        return true;
    }
    //删除存储空间
    public static boolean delBlu(String bucketName){
        ossClient.deleteBucket(bucketName);
        return true;
    }


    //创建访问地址
    public static String getUrl(String bucket,String objname){
        return ossClient.generatePresignedUrl(bucket,objname, DateUtil.addTime(SystemConfig.OSS_TIME,1)).toString();
    }
}
