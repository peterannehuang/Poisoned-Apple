package tw.idv.peterannehuang.poisoned_apple;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class AspectCase {

  private long threadId = Thread.currentThread().getId();
  private Date createdTimestamp = new Date(System.currentTimeMillis());
  private Map<String, Object> extraData = new HashMap<>();
  private int stackNumber;
  private Class<?> targetClass;

  public Date getCreatedTimestamp() {
    return createdTimestamp;
  }

  public Object getExtraData(String key) {
    return this.extraData.get(key);
  }

  public int getStackNumber() {
    return stackNumber;
  }

  public Class<?> getTargetClass() {
    return targetClass;
  }

  public long getThreadId() {
    return threadId;
  }

  public void setCreatedTimestamp(Date createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
  }

  public void setExtraData(String key, Object extraData) {
    this.extraData.put(key, extraData);
  }

  public void setStackNumber(int stackNumber) {
    this.stackNumber = stackNumber;
  }

  public void setTargetClass(Class<?> targetClass) {
    this.targetClass = targetClass;
  }

  public void setThreadId(long threadId) {
    this.threadId = threadId;
  }
}
