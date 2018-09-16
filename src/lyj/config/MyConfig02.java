package lyj.config;

import lyj.model.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


/**
 * Created by 陆英杰
 * 2018/9/15 11:30
 */


//配置类==配置文件
//告诉spring这是一个配置文件,spring会吧这个配置类当做bean放入ioc容器中
@Configuration
//如果将@Conditional放在类上,则表示满足当前条件买这个类中配置的所有bean注册才会生效
@Conditional(MyCondition.class)
//快速导入一个bean,bean的名称默认为类的全类名,这个注解只能标注在类和接口上
//也可以自定义导入的规则(实现ImportSelector接口即可)
@Import({Person.class,MyImportSelector.class})
public class MyConfig02 {

    @Lazy   //设置懒加载(只有在获取bean的时候才会初始化bean)
    @Scope(value = "singleton")   //单例,默认;(value = "prototype":多例)
    @Bean
    public Person person(){
        System.out.println("给ioc容器中初始化了一个Person...");
        return new Person("张三",20);
    }

    /**
     * @Conditional({Condition}) : 按照一定的条件进行判断,满足条件给容器中注册bean
     * 要传一个用于条件判断的Condition类
     * 判断当前是什么系统,如果是window系统,则注册该bean
     */
    @Conditional(MyCondition.class)
    @Bean("lisi")
    public Person person01(){
        System.out.println("李四");
        return new Person("李四",20);
    }

}
