package tw.idv.peterannehuang.poisoned_apple.convert;

public interface ConverterInterface {

  public String toString(Object object);

  public <T> T toObject(Class<T> objectClass, String string);
}
