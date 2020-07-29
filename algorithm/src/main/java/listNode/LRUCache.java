package listNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int cacheSize;

    public LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }

    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<String, String>(16);
        Map.Entry<String, String> s = new Map.Entry<String, String>() {
            public String getKey() {
                return null;
            }

            public String getValue() {
                return null;
            }

            public String setValue(String value) {
                return null;
            }
        };
        lruCache.removeEldestEntry(s);
    }
}
