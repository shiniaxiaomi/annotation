package lyj.config;

import lyj.model.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by 陆英杰
 * 2018/9/15 20:10
 */

//使用@PropertySource读取外部配置文件中的key/value保存在运行的环境变量中
@PropertySource(value = "classpath:/people.properties")
@Configuration
public class MainConfigOfPropertyValues {


    @Bean
    public People people(){
        return new People();
    }

}
