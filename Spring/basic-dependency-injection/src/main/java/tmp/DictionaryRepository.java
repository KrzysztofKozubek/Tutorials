package tmp;

import java.util.HashMap;
import java.util.Map;

public class DictionaryRepository {

    Map<String, String> result = new HashMap<>();

    public Map<String, String> getDictionarys() {
        result.put("PL", "pl");
        return result;
    }

    @Override
    public String toString() {
        return "DictionaryRepository{" +
                "result=" + result +
                '}';
    }
}
