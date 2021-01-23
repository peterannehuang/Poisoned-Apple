package tw.idv.peterannehuang.poisoned_apple.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonConverter implements ConverterInterface {

  @Override
  public String toString(Object object) {
    try {
      return new ObjectMapper().writeValueAsString(object);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public <T> T toObject(Class<T> objectClass, String string) {
    // TODO Auto-generated method stub
    try {
      return new ObjectMapper().readValue(string, objectClass);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
  }
}
