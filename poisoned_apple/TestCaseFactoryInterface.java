package tw.idv.peterannehuang.poisoned_apple;

public interface TestCaseFactoryInterface {

  public Testable read(String name);

  public void write(Testable testCase);
}
