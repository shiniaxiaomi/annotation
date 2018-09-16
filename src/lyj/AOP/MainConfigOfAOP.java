package lyj.AOP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by 陆英杰
 * 2018/9/16 10:35
 */

/**
 * AOP:[动态代理]
 *      指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *
 * 1. 导入AOP模块:Spring AOP(spring-aspects)
 * 2. 定义一个业务逻辑类(MathCalculate); 在业务逻辑运行的时候将日志进行打印(方法之前,方法之后,方法异常,xxx)
 * 3. 定义一个日志切面类(LogAspects); 切面类里面的方法需要动态感知业务逻辑类的方法运行
 *      通知方法:
 *          前置通知(@Before): logStart:在目标方法(div)运行之前运行
 *          后置通知(@After): logEnd:在目标方法(div)运行结束之后运行
 *          返回通知(@AfterReturning): logReturn:在目标方法(div)正常返回之后运行
 *          异常通知(@AfterThrowing): logException:在目标方法(div)出现异常以后运行
 *          环绕通知(@Around): 动态代理,手动推进目标方法运行(joinPoint.procced())
 * 4. 给切面类的目标方法标注何时何地运行(通知注解)
 * 5. 将切面类和业务逻辑类(目标方法所在类)都加入到容器中
 * 6. 必须告诉spring哪个是切面类(即在切面类上要标注@Aspect注解)
 * [7]. 给配置类中加@EnableAspectJAutoProxy [开启基于注解的aop模式] ---很重要
 *
 * 三步:
 *      1). 将业务逻辑和切面类都加入到容器中,告诉spring那个是切面类
 *      2). 在切面类上的的每一个通知方法上标注通知注解,告诉spring何时何地运行(切入点表达式)
 *      3). 开启基于注解的aop模式[@EnableAspectJAutoProxy]
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    //将业务逻辑类加入到容器中
    @Bean
    public MathCalculate mathCalculate(){
        return new MathCalculate();
    }

    //切面类加入到容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}
