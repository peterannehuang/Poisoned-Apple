package tw.idv.peterannehuang.poisoned_apple;

import java.lang.reflect.Method;

public class MethodCase extends AspectCase implements Testable {

  private Method method;
  private Object target;
  private Object[] args;
  private Object returnValue;
  private Class<? extends Throwable> throwClass;
  private String errorMessage;

  public Object[] getArgs() {
    return args;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public Method getMethod() {
    return method;
  }

  public Object getReturnValue() {
    return returnValue;
  }

  public Object getTarget() {
    return target;
  }

  public Class<? extends Throwable> getThrowClass() {
    return throwClass;
  }

  public void setArgs(Object[] args) {
    this.args = args;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public void setMethod(Method method) {
    this.method = method;
    setTargetClass(method.getDeclaringClass());
  }

  public void setReturnValue(Object returnValue) {
    this.returnValue = returnValue;
  }

  public void setTarget(Object object) {
    this.target = object;
  }

  public void setThrowClass(Class<? extends Throwable> throwClass) {
    this.throwClass = throwClass;
  }

  public void setThrowing(Throwable throwable) {
    if (throwable != null) {
      this.throwClass = throwable.getClass();
      this.errorMessage = throwable.getMessage();
    }
  }
}
