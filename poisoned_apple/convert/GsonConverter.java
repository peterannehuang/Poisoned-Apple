package tw.idv.peterannehuang.poisoned_apple.convert;

import com.google.gson.Gson;

public class GsonConverter implements ConverterInterface {

  @Override
  public String toString(Object object) {
    return new Gson().toJson(object);
  }

  @Override
  public <T> T toObject(Class<T> objectClass, String string) {
    return new Gson().fromJson(string, objectClass);
  }
}
