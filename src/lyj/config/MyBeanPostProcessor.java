package lyj.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by 陆英杰
 * 2018/9/15 17:30
 */

/**
 * DESC: 自定义的bean的后置处理器:在bean的初始化前后进行处理工作
 *
 * spring底层对BeanPostProcessor的使用:
 *      后置处理器作用:
 *          1.@Autowired的自动注入,就是通过后置处器,在bean初始化好之后,通过反射将bean设置到有标注@Autowired注解的属性上
 *          2.bean的生命周期的注解功能
 *          3.bean赋值,注入组件等
 */
public class MyBeanPostProcessor implements BeanPostProcessor{
    /**
     * 在bean初始化前调用该方法
     * @param bean 刚创建的bean的实例
     * @param beanName 刚创建的bean的名字(id)
     * @return 返回刚创建的bean实例
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"的初始化前:"+"===>"+bean);
        return bean;
    }

    //在bean初始化后调用该方法
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"初始化后:"+"===>"+bean);
        return bean;
    }
}
