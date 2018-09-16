package test;

import lyj.config.ConfigOfLifeCycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 陆英杰
 * 2018/9/15 11:21
 */

/**
 * DESC: 测试类
 *      1.test01:关闭容器,达到销毁bean的目的
 */
public class Test03 {

    //读取注解配置类
    AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(ConfigOfLifeCycle.class);


    //关闭容器,达到销毁bean的目的
    @Test
    public void test01(){
        System.out.println("==========关闭容器===========");
        annotationConfig.close();//关闭容器时,bean会调用destroy方法
    }

}
