package lyj.AOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by 陆英杰
 * 2018/9/15 11:21
 */

/**
 * DESC: 测试类
 *      1. test01:测试AOP
 */
public class Test07 {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext annotationConfig = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
//        MathCalculate mathCalculate = annotationConfig.getBean(MathCalculate.class);
        MathCalculate mathCalculate = (MathCalculate) annotationConfig.getBean("mathCalculate");
        mathCalculate.div(8,2);
//        mathCalculate.div(8,0);//让其抛出异常

        String[] beanDefinitionNames = annotationConfig.getBeanDefinitionNames();
        for(String s:beanDefinitionNames){
            System.out.println(s+":"+annotationConfig.getBean(s).getClass());
        }

    }
}
