package lyj.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by 陆英杰
 * 2018/9/15 17:08
 */
public class Cat implements InitializingBean,DisposableBean {
    public Cat() {
        System.out.println("cat constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Cat destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat init...");
    }
}
