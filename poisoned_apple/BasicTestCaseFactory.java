package tw.idv.peterannehuang.poisoned_apple;

import java.lang.reflect.Method;
import javax.annotation.Resource;
import tw.idv.peterannehuang.poisoned_apple.convert.ConverterInterface;
import tw.idv.peterannehuang.poisoned_apple.writable.MethodCaseData;

public abstract class BasicTestCaseFactory implements TestCaseFactoryInterface {

  @Resource ConverterInterface converter;

  public BasicTestCaseFactory(ConverterInterface converter) {
    this.converter = converter;
  }

  @Override
  public Testable read(String name) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void write(Testable testCase) {
    if (MethodCase.class.isInstance(testCase)) {
      write(MethodCase.class.cast(testCase));
    }
  }

  private void write(MethodCase methodCase) {
    Method method = methodCase.getMethod();
    MethodCaseData data = new MethodCaseData(method, getName(methodCase));
    data.setTarget(this.converter.toString(methodCase.getTarget()));
    for (int i = 0; i < method.getParameterCount(); i++) {}
  }

  public abstract void write(MethodCaseData data);

  protected String getName(MethodCase methodCase) {
    // TODO
    return null;
  }

  ConverterInterface getConverter() {
    return this.converter;
  }
}
