package test;

import lyj.config.MyConfig02;
import lyj.model.Person;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 陆英杰
 * 2018/9/15 11:21
 */

/**
 * DESC: 测试类
 *      1.test01:从ioc容器中取两次bean,可以用来测试@Scope(单例和多例)的作用域
 *      2.test02:测试懒加载
 *      2.test03:打印ioc容器中所有bean的id名称
 */
public class Test02 {

    //读取注解配置类
    AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(MyConfig02.class);

    //打印ioc容器中所有类型为Person的bean的id名称
    public void showBean(){
//        String[] beanDefinitionNames = annotationConfig.getBeanNamesForType(Person.class);
        String[] beanDefinitionNames = annotationConfig.getBeanDefinitionNames();
        System.out.println("ioc容器中所有的bean如下:");
        for (String name:beanDefinitionNames){
            System.out.println("===>ioc里有:"+name);
        }
    }

    //从ioc容器中取两次bean,可以用来测试@Scope(单例和多例)的作用域
    @Test
    public void test01(){
        //读取注解配置类,传入自定义配置类的全类名
        Person person = (Person) annotationConfig.getBean("person");
        Person person2 = (Person) annotationConfig.getBean("person");
        System.out.println(person==person2);
    }

    //测试懒加载
    @Test
    public void test02(){
        System.out.println("ioc容器初始化完成...");
        Person person = (Person) annotationConfig.getBean("person");//当获取的时候才会进行初始化bean
    }

    //打印ioc容器中所有类型为Person的bean的id名称
    @Test
    public void test03(){
        showBean();
    }
}
