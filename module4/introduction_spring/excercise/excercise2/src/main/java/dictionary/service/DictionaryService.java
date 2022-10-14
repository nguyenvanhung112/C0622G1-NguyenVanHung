package dictionary.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("apple", "táo");
        map.put("banana", "chuối");
        map.put("pen", "bút");
        map.put("stupid", "sơn");
    }

    @Override
    public String getDictionary(String eng) {
        return map.get(eng);
    }
}
