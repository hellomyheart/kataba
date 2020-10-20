package cn.hellomyheart.kataba;

import cn.hellomyheart.kataba.util.EncryptUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KatabaApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void t1(){
        String key= EncryptUtil.createAESKey();
        System.out.println(key);
        String pass="123456";
        String mw=EncryptUtil.aesenc(key,pass);
        System.out.println(mw);
        System.out.println(EncryptUtil.aesdec(key,mw));
    }
}
