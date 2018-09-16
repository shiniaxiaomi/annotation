package test;

import lyj.config.MainConfigOfAutowired;
import lyj.dao.BookDao;
import lyj.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 陆英杰
 * 2018/9/15 11:21
 */

/**
 * DESC: 测试类
 *      1.test01:拿到配置文件中的信息
 */
public class Test05 {

    //读取注解配置类
    AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);


    @Test
    public void test01(){
        BookService bookService = (BookService) annotationConfig.getBean("bookService");
        BookDao bookDao = (BookDao) annotationConfig.getBean("bookDao");
        System.out.println(bookService.getBookDao()==bookDao);//判断是否是一样的,如果是一样的,则表示自动注入成功
    }

}
