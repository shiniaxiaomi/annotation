package lyj.AOP;

/**
 * Created by 陆英杰
 * 2018/9/16 10:44
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 日志切面类
 */
@Aspect //告诉spring当前类是一个切面类
public class LogAspects {

    //抽取公共的切入点表达式
    //1. 本类引用,只需要写方法名即可[pointCut()]
    //2. 其他类要使用这个切入点,只需写入这个的具体方法名[lyj.AOP.LogAspects.pointCut()]
    @Pointcut("execution(* lyj.AOP.MathCalculate.*(..))")
    public void pointCut(){}

    //@Before 在目标方法之前切入切点表达式(指定在哪个方法切入)
    //直接指定要切入哪个方法
    @Before("execution(public int lyj.AOP.MathCalculate.div(..))")
    public void logStart(JoinPoint joinPoint){
        //可以通过JoinPoint类来拿到所有的目标办法的信息
        //JoinPoint参数必须写在第一个位置
        System.out.println(""+joinPoint.getSignature().getName()+"开始运行...参数列表是:{"+ Arrays.asList(joinPoint.getArgs())+"}");
    }

    //本类引用,直接使用抽取的公共的切入点["pointCut()"]
    //使用本类中的公共切入点
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"结束运行...");
    }

    //若在其他类中使用公共的切入点,就可以这样使用[value = "lyj.AOP.LogAspects.pointCut()"]
    //如果要接收返回值信息,要在 @AfterReturning的注解上配置[returning = "result"],然后在参数中加上result入参即可使用
    @AfterReturning(value = "lyj.AOP.LogAspects.pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(""+joinPoint.getSignature().getName()+"正常返回...,返回结果:"+result);
    }

    //如果要接收异常信息,要在 @AfterThrowing的注解上配置[throwing = "exception"],然后在参数中加上exception入参即可使用
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(""+joinPoint.getSignature().getName()+"异常...异常信息是:{"+exception+"}");
    }
}
