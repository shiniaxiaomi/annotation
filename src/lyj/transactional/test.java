package lyj.transactional;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 陆英杰
 * 2018/9/16 15:31
 */
public class test {

    @Test
    public void test(){

        AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = (UserService) annotationConfig.getBean("userService");
        userService.insert();//执行插入sql

    }
}
