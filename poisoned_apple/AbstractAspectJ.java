package tw.idv.peterannehuang.poisoned_apple;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public abstract class AbstractAspectJ {

  @AfterReturning(pointcut = "cut()", returning = "returnValue")
  public void afterMethodReturning(JoinPoint thisJoinPoint, Object returnValue) {
    System.out.println("Test:processAfterReturning");
    Signature signature = thisJoinPoint.getSignature();
    if (!MethodSignature.class.isInstance(signature)) {
      return;
    }
    MethodSignature methodSignature = MethodSignature.class.cast(signature);
    PoisonApple.write(getStackNumber(), methodSignature.getMethod(), returnValue);
  }

  @AfterThrowing(pointcut = "cut()", throwing = "e")
  public void afterMethodThrowing(JoinPoint thisJoinPoint, Throwable e) {
    System.out.println("Test:processAfterThrowing");
    Signature signature = thisJoinPoint.getSignature();
    if (!MethodSignature.class.isInstance(signature)) {
      return;
    }
    MethodSignature methodSignature = MethodSignature.class.cast(signature);
    PoisonApple.write(getStackNumber(), methodSignature.getMethod(), e);
  }

  @Before("cut()")
  public void beforeMethod(JoinPoint thisJoinPoint) {
    System.out.println("processBefore");
    Signature signature = thisJoinPoint.getSignature();
    if (!MethodSignature.class.isInstance(signature)) {
      return;
    }
    MethodSignature methodSignature = MethodSignature.class.cast(signature);
    MethodCase methodCase = new MethodCase();
    methodCase.setStackNumber(getStackNumber());
    methodCase.setMethod(methodSignature.getMethod());
    methodCase.setTarget(thisJoinPoint.getThis());
    methodCase.setArgs(thisJoinPoint.getArgs());
    PoisonApple.init(methodCase);
  }

  private int getStackNumber() {
    return Thread.currentThread().getStackTrace().length - 1;
  }

  @Pointcut
  public abstract void cut();
}
