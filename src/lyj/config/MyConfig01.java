package lyj.config;

import lyj.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


/**
 * Created by 陆英杰
 * 2018/9/15 11:30
 */


//配置类==配置文件
//告诉spring这是一个配置文件,spring会吧这个配置类当做bean放入ioc容器中
@Configuration
//注解要扫描哪个包下的所有注解,还可以通过excludeFilters来排除那些注解;excludeFilters传入的是一个@ComponentScan.Filter注解(可以传入多个,以数组的形式);
//Filter可以配置要过滤的是注解还是其他类;Filter也可以配置自定义的过滤规则(使用type = FilterType.CUSTOM)
@ComponentScan(value = "lyj",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)}
        )
public class MyConfig01 {

    //给ioc容器放入一个bean;类型为返回值的类型;id默认是用方法名作为id;也可以在@Bean("person")指定id
    @Bean
    public Person person(){
        return new Person("张三",20);
    }


}
