package lyj.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by 陆英杰
 * 2018/9/15 17:14
 */
public class Dog {
    public Dog() {
        System.out.println("Dog constructor...");
    }

    //在bean创建完成并且属性赋值完成后,来执行用@PostConstruct标注的方法(可以标注在任何方法上)
    @PostConstruct
    public void init(){
        System.out.println("dog init...");
    }

    //在容器销毁bean之前调用用@PreDestroy标注的方法
    @PreDestroy
    public void destroy(){
        System.out.println("dog destroy...");
    }
}
