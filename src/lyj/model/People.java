package lyj.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by 陆英杰
 * 2018/9/15 20:10
 */


public class People {

    /**
     * 使用@Value赋值
     *  1.基本数值
     *  2.可以写SpEL:#{20-2}  可以运行得到结果后赋值
     *  3.可以写${}   取出配置文件中的值(在运行环境)
     */

    @Value("张三")
    private String name;

    @Value("#{20-2}")
    private int age;

    @Value("${people.desc}")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                '}';
    }
}
