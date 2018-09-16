package lyj.config;

import lyj.model.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by 陆英杰
 * 2018/9/16 0:10
 */

/**
 * Profile:
 *      spring为我们提供的可以根据当前环境,动态的计划和切换一系列组件的功能
 *
 * 比如:
 *      开发环境,测试环境,生产环境
 *      数据源:(/A),(/B),(/C)
 *
 * @Profile: 指定组件在哪个环境的情况下才能被注册到容器中;不指定,任何环境下都能注册这个组件
 *      1). 加入环境标志@Profile注解后的bean,只有这个环境被激活的时候才能注册到容器中;默认是default环境[@Profile("default")]
 *      2). 写在配置类上,只有是指定的环境的时候,整个配置里面的所有配置才能开始生效(但是能不能生效还要取决于他们自身还有什么限制条件)
 *
 * 如何切换环境(有3种方法):
 *      1). 使用命令行动态参数: -Dspring.profiles.active=test
 *      2). 使用代码的方式:
 *          a. 使用无参构造器创建annotationConfig对象 ===>[AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext();]
 *          b. 设置需要激活的环境 ===>[annotationConfig.getEnvironment().setActiveProfiles("test","dev");//激活两个环境]
 *          c. 注册主配置类 ===>[annotationConfig.register(MainConfigOfProfile.class);]
 *          d. 启动刷新容器 ===>[annotationConfig.refresh();]
 */
//写在配置类上,只有是指定的环境的时候,整个配置里面的所有配置才能开始生效(但是能不能生效还要取决于他们自身还有什么限制条件)
@Profile("test")
@Configuration
public class MainConfigOfProfile {

    //在dev环境中生效
    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSource_Dev(){
        return new DataSource("devDataSource");
    }

    //在test环境中生效
    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSource_Test(){
        return new DataSource("testDataSource");
    }

    //在prod环境中生效
    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSource_Prod(){
        return new DataSource("prodDataSource");
    }
}
