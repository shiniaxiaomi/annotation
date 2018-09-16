package lyj.config;

/**
 * Created by 陆英杰
 * 2018/9/15 16:48
 */

import lyj.model.Car;
import lyj.model.Cat;
import lyj.model.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

/**
 * DESC: 用于测试bean的生命周期
 *
 * 初始化: 对象创建完成,并赋值好,调用初始化方法
 * 销毁:
 *      单实例: 容器关闭是调用销毁方法
 *      多实例: 容器不会管理这个bean的消亡
 */
@Configuration
public class ConfigOfLifeCycle {

    //让MyBeanPostProcessor后置处理器放到ioc容器中,这样这个后置处理器才可以工作
    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    //可以指定bean的init方法和destroy方法
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

    //实现了InitializingBean,DisposableBean接口
    @Bean()
    public Cat cat(){
        return new Cat();
    }

    //标注@PostConstruct和@PreDestroy注解
    @Bean
    public Dog dog(){
        return new Dog();
    }

}
