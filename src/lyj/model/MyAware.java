package lyj.model;

import lyj.dao.BookDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Created by 陆英杰
 * 2018/9/15 21:17
 */


/**
 * DESC: 为什么通过实现这些xxxAware接口就可以实现以下功能呢?
 *      解析:
 *          @Autowire原理:
 *              1.实现了这些接口的类必须要被spring扫描到ioc容器中,spring会首先创建好所有的bean(通过反射),并放入ioc容器中
 *              2.spring会把ioc容器中的bean中有注解@Autowire注解的bean挨个遍历,并通过AutowiredAnnotationBeanPostProcessor后置处理器类
 *                的inject()方法来往bean中设置属性(直接赋值,即赋值属性对象的引用),在设置完属性之后,如果你实现了xxxAware接口,然后就可以拿到对应的上下文,
 *                再自己可以做一些处理
 *
 *          所以,在通过xxxPostProcessor(后置处理器)初始化bean的时候(即设置自动注入之后),spring会接着调用这些接口的暴露出来的方法,然后因为这个类实现了该接口,
 *            那么就相当于是调用的这个类本身实现的这些方法;(主要的知识就是多态:1.继承或者实现接口 2.有方法重写 3.父类引用指向子类对象)
 *            ===>父类引用指向子类对象的理解:ApplicationContextAware app=new MyAware();  [MyAware实现了ApplicationContextAware接口]
 *
 */
@Component
public class MyAware implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware {

    @Autowired
    private BookDao bookDao;//先会自动注入这个属性,然后再进入了setApplicationContext()方法,说明是先自动注入完成,再调用接口暴露出来的方法

    private ApplicationContext applicationContext;

    //通过实现ApplicationContextAware接口,就可以通过回调拿到ApplicationContext对象,并且可以将ApplicationContext对象保存起来
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        System.out.println("传入的ioc:"+applicationContext);
    }

    //通过实现BeanNameAware接口,就可以通过回调拿到当前bean的名字
    @Override
    public void setBeanName(String beanName) {
        System.out.println("当前bean的名字:" +beanName);
    }

    //通过实现EmbeddedValueResolverAware接口,就可以通过回调拿到StringValueResolver(字符串解析器)对象
    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String s = stringValueResolver.resolveStringValue("你好${os.name}," + "计算结果为:#{20*18}");//可以获取上下文中配置文件和表达式计算
        System.out.println(s);
    }
}
