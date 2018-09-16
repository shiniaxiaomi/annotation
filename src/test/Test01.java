package test;

import lyj.config.MyConfig01;
import lyj.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 陆英杰
 * 2018/9/15 11:21
 */

/**
 * DESC: 测试类
 *      1.test02:读取注解配置类
 *      2.test03:打印ioc容器中所有bean的id名称
 */
public class Test01 {

    //读取注解配置类
    AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(MyConfig01.class);

    //打印ioc容器中所有bean的id名称
    public void showBean(){
        String[] beanDefinitionNames = annotationConfig.getBeanDefinitionNames();
        System.out.println("ioc容器中所有的bean如下:");
        for (String name:beanDefinitionNames){
            System.out.println("===>ioc里有:"+name);
        }
    }


    @Test
    //读取注解配置类
    public void test02(){
        //读取注解配置类,传入自定义配置类的全类名
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig01.class);
        Person person = (Person) annotationConfigApplicationContext.getBean("person");
        System.out.println(person);

        //通过类型获取ioc容器中类型匹配的bean的名称
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
    }

    //打印ioc容器中所有bean的id名称
    @Test
    public void test03(){
        showBean();
    }
}
