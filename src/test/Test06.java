package test;

import lyj.config.MainConfigOfProfile;
import lyj.model.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 陆英杰
 * 2018/9/15 11:21
 */

/**
 * DESC: 测试类
 *      1. test01:使用命令行动态参数切换环境: -Dspring.profiles.active=test
 *      2. test02:使用代码切换环境
 */
public class Test06 {


    //使用命令行动态参数切换环境: -Dspring.profiles.active=test
    @Test
    public void test01(){
        AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        String[] beanDefinitionNames = annotationConfig.getBeanNamesForType(DataSource.class);
        System.out.println("ioc容器中所有的bean如下:");
        for (String name:beanDefinitionNames){
            System.out.println("===>ioc里有:"+name);
        }
    }


    //使用代码切换环境
    @Test
    public void test02(){
        //1.使用无参构造器创建一个AnnotationConfigApplicationContext对象
        AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        annotationConfig.getEnvironment().setActiveProfiles("dev");//激活环境,可以激活多个环境("test","dev")
        //3.注册主配置类
        annotationConfig.register(MainConfigOfProfile.class);
        //4.启动刷新容器
        annotationConfig.refresh();


        String[] beanDefinitionNames = annotationConfig.getBeanNamesForType(DataSource.class);
        System.out.println("ioc容器中所有的bean如下:");
        for (String name:beanDefinitionNames){
            System.out.println("===>ioc里有:"+name);
        }
    }

}
