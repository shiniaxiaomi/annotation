package lyj.model;

import javafx.fxml.Initializable;

/**
 * Created by 陆英杰
 * 2018/9/15 16:46
 */
public class Car{

    public Car() {
        System.out.println("car constructor...");
    }

    //初始化方法
    public void init(){
        System.out.println("car init...");
    }

    //销毁方法
    public void destroy(){
        System.out.println("car destroy...");
    }
}
