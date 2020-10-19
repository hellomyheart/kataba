package cn.hellomyheart.kataba.core.type;

/**
 * @description 状态码
 * @className: RType
 * @package: cn.hellomyheart.kataba.core.type
 * @author: Stephen Shen
 * @date: 2020/10/19 下午3:38
 */
public enum RType {
    成功(1),失败(2),登录失败(3);
    private int val;

    public  int getVal(){
        return val;
    }

    private  RType(int val){
        this.val=val;
    }
}
