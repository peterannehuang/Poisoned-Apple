package tw.idv.peterannehuang.poisoned_apple.writable;

import java.lang.reflect.Method;

public class MethodCaseData {

  private String name;
  private Method method;
  private String targetJson;
  private String[] ArgsJsons;
  private String[] varArgJsons;
  private String returnJson;
  private String message;
  private Class<? extends Throwable> exceptionClass;

  public MethodCaseData(Method method, String name) {
    this.method = method;
    this.name = name;
  }

  public String[] getArgsJsons() {
    return this.ArgsJsons;
  }

  public Class<? extends Throwable> getExceptionClass() {
    return exceptionClass;
  }

  public String getMessage() {
    return this.message;
  }

  public Method getMethod() {
    return this.method;
  }

  public String getName() {
    return this.name;
  }

  public String getReturnJson() {
    return this.returnJson;
  }

  public String getTargetJson() {
    return this.targetJson;
  }

  public String[] getVarArgJsons() {
    return this.varArgJsons;
  }

  public void setArgument(int position, String jsonString) {
    this.ArgsJsons[position - 1] = jsonString;
  }

  public void setArgument(String name, String jsonString) {
    // TODO
  }

  public void setException(Throwable exception) {
    this.exceptionClass = exception.getClass();
    this.message = exception.getMessage();
  }

  public void setReturnValue(String jsonString) {
    this.returnJson = jsonString;
  }

  public MethodCaseData setTarget(String jsonString) {
    this.targetJson = jsonString;
    return this;
  }

  public void setVarArg(String jsonString) {
    String[] newVarArgJsons;
    if (this.varArgJsons == null) {
      newVarArgJsons = new String[1];
      newVarArgJsons[0] = jsonString;
    } else {
      newVarArgJsons = new String[this.varArgJsons.length + 1];
      for (int i = 0; i < this.varArgJsons.length; i++) {
        newVarArgJsons[i] = this.varArgJsons[i];
      }
      newVarArgJsons[this.varArgJsons.length] = jsonString;
    }
    this.varArgJsons = newVarArgJsons;
  }

  public void setVarArgs(String... jsonStrings) {
    this.varArgJsons = jsonStrings;
  }
}
