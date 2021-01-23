package tw.idv.peterannehuang.poisoned_apple.convert;

import javax.json.bind.JsonbBuilder;

public class JsonBConverter implements ConverterInterface {

  @Override
  public String toString(Object object) {
    return JsonbBuilder.create().toJson(object);
  }

  @Override
  public <T> T toObject(Class<T> objectClass, String string) {
    return JsonbBuilder.create().fromJson(string, objectClass);
  }
}
