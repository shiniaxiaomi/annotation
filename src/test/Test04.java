package test;

import lyj.config.MainConfigOfPropertyValues;
import lyj.model.People;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 陆英杰
 * 2018/9/15 11:21
 */

/**
 * DESC: 测试类
 *      1.test01:拿到配置文件中的信息
 */
public class Test04 {

    //读取注解配置类
    AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);


    //关闭容器,达到销毁bean的目的
    @Test
    public void test01(){
        //从容器中拿到bean
        People people = (People) annotationConfig.getBean("people");
        System.out.println(people);

        //获取配置文件中的值
        String property = annotationConfig.getEnvironment().getProperty("people.desc");
        System.out.println(property);
    }

}
