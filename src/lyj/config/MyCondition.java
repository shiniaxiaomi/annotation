package lyj.config;

import lyj.model.Person;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by 陆英杰
 * 2018/9/15 14:09
 */

public class MyCondition implements Condition {
    /**
     * @param conditionContext ：判断条件能使用的上下文(环境)
     * @param annotatedTypeMetadata : 注解信息
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        //1.能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2.能获取到类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //3.获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //4.获取到bean定义的注册类(可以直接使用registry来注册一个bean,也可以删除一个bean)
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        //获取当前是什么系统
        String property = environment.getProperty("os.name");
        /**
         * 判断条件:如果是window系统, 则条件成立,表示可以注册该bean
         */
        if(property.contains("Windows")){
            return true;
        }

        return false;
    }
}
