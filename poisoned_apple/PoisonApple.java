package tw.idv.peterannehuang.poisoned_apple;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;

public final class PoisonApple {

  private static PoisonApple uniqueInstance;

  private static void check() {
    if (uniqueInstance == null) {
      // throw
      System.out.println("Error: No initialing PoisonApple.");
    }
  }

  public static void init(AspectCase aspectCase) {
    check();
    if (aspectCase.getStackNumber() == 0) {
      // throw
      System.out.println("Error: Thread stack number is zero.");
    }
    uniqueInstance.add(aspectCase);
  }

  public static Testable read(String name) {
    // TODO
    return null;
  }

  public static void run(String name) {
    run(read(name));
  }

  public static void run(Testable testCase) {
    // TODO
  }

  public static void write(int stackNumber, Method method, Object returnValue) {
    check();
    MethodCase methodCase = uniqueInstance.getCase(MethodCase.class, stackNumber);
    if (Throwable.class.isInstance(returnValue)) {
      Throwable e = Throwable.class.cast(returnValue);
      methodCase.setThrowing(e);
    } else {
      methodCase.setReturnValue(returnValue);
    }
    uniqueInstance.remove(stackNumber);
  }

  @Resource private TestCaseFactoryInterface factory;

  private Map<Long, Map<Integer, AspectCase>> cache;

  public PoisonApple(TestCaseFactoryInterface factory) {
    if (uniqueInstance == null) {
      this.factory = factory;
      this.cache = new ConcurrentHashMap<>();
      uniqueInstance = this;
    } else {
      // throw
    }
  }

  private void add(AspectCase aspectCase) {
    Map<Integer, AspectCase> threadCache = getCache();
    if (threadCache.containsKey(aspectCase.getStackNumber())) {
      // throw
    }
    threadCache.put(aspectCase.getStackNumber(), aspectCase);
  }

  private void remove(int stackNumber) {
    Map<Integer, AspectCase> threadCache = getCache();
    threadCache.remove(stackNumber);
  }

  private Map<Integer, AspectCase> getCache() {
    long id = Thread.currentThread().getId();
    Map<Integer, AspectCase> threadCache = this.cache.get(id);
    if (threadCache == null) {
      threadCache = new HashMap<>();
      this.cache.put(id, threadCache);
    }
    return threadCache;
  }

  private <T extends AspectCase> T getCase(Class<T> caseClass, int stackNumber) {
    Map<Integer, AspectCase> threadCache = getCache();
    AspectCase aspectCase = threadCache.get(stackNumber);
    if (aspectCase == null) {
      // throw
      System.out.println("Error: aspectCase is null.");
    }
    if (!caseClass.isInstance(aspectCase)) {
      // throw
      System.out.println("Error: aspectCase is not a " + caseClass.getSimpleName() + ".");
    }
    return caseClass.cast(aspectCase);
  }
}
