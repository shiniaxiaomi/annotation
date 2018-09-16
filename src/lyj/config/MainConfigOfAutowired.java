package lyj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 陆英杰
 * 2018/9/15 20:37
 */

/**
 * 自动装配:
 *      spring利用依赖注入(DI),完成对ioc容器中各个组件的依赖关系赋值
 *
 * 1.@Autowired: 自动注入
 *      1). 默认优先按照类型去容器中找对应的组件
 *      2). 如果找到多个相同类型的组件,再用id去容器中查找
 *      3). 使用@Qualifier("bookDao");使用@Qualifier指定需要装配的组件的id,而不是使用属性名
 *      4). @Autowired(required = false)   可以设置不是必须要装配
 *
 * 2.spring还支持使用@Resource(JS250)[java规范的注解,所以其他框架也会支持@Resource注解;@Autowired是spring定义的,所以其他框架中是没有@Autowired注解的]
 *      @Resource:
 *          1). 可以和@Autowired一样实现自动装配功能; 默认是按照组件名称记进行装配的
 *              但是没有@Autowired(required = false) 的功能
 *
 * 3.spring中的自动装配是使用的是AutowiredAnnotationBeanPostProcessor后置处理器类进行的自动装配
 *
 * 4.自定义组件想要使用spring容器底层的一些组件(ApplicationContext,BeanFactory,xxx)
 *      自定义组件实现xxxAware接口即可: 在创建对象的时候,会调用接口对应的方法注入相关组件:Aware
 *      吧spring底层一些组件注入到自定义的bean中
 *      xxxAware:功能 使用xxxProcessor
 *          ApplicationContextAware===>ApplicationContextAwareProcessor
 *
 */

@Configuration
//设置扫描三个包
@ComponentScan(value = {"lyj.controller","lyj.dao","lyj.service","lyj.model"})
public class MainConfigOfAutowired {
}
