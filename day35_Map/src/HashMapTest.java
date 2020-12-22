import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * @Package      : []
 * @Author       : yaowenzhou
 * @Date         : 2020-12-21 21:34:05 Monday
 * @LastEditors  : yaowenzhou
 * @LastEditTime : 2020-12-21 23:50:09
 * @Version      : 
 * @Description  : 
 */

public class HashMapTest {
    Map<Object, Object> getHashMap() {
        // 创建hashMap
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        map.put("week", "Mon");
        return map;
    }

    @Test
    public void createHashMap() {
        Map<Object, Object> map = getHashMap();
        System.out.println(map);
    }

    // 增
    @Test
    public void putTest() {
        Map<Object, Object> map = getHashMap();
        map.put("10", 10);
        System.out.println(map);
    }

    // 删
    @Test
    public void removeTest() {
        Map<Object, Object> map = getHashMap();
        Object val = map.remove("BB");
        System.out.println("val: " + val);
        System.out.println(map);
    }

    // 改
    @Test
    public void modifyTest() {
        Map<Object, Object> map = getHashMap();
        System.out.println(map);
        map.put("AA", 456);
        System.out.println(map);
    }

    // 清空
    @Test
    public void clearTest() {
        Map<Object, Object> map = getHashMap();
        System.out.println(map);
        map.clear();
        System.out.println(map);
    }

    // 查
    @Test
    public void getTest() {
        Map<Object, Object> map = getHashMap();
        // 根据key返回相应的value，如果没找到相应的value，则返回null
        System.out.println(map.get("AA"));
        // 返回map中是否包含某个key
        System.out.println(map.containsKey("AA"));
        // 返回map中是否包含某个value
        System.out.println(map.containsValue("123"));
        map.put(12345, null);
        System.out.println(map);
        System.out.println(map.get(123456));
        System.out.println(map.size());
        map.clear();
        System.out.println(map.isEmpty());
    }

    // 比较
    @Test
    public void equalsTest() {
        Map<Object, Object> map = getHashMap();
        Map<Object, Object> map1 = getHashMap();
        System.out.println(map.equals(map1));
    }

    // 遍历
    @Test
    public void keySetTest() {
        Map<Object, Object> map = getHashMap();
        Set<Object> set = map.keySet();
        Iterator<Object> ite = set.iterator();
        while (ite.hasNext()) {
            System.out.println(map.get(ite.next()));
        }
    }

    // 遍历
    @Test
    public void valuesTest() {
        Map<Object, Object> map = getHashMap();
        Collection<Object> values = map.values();
        for (Object object : values) {
            System.out.println(object);
        }
    }

    // 遍历
    @Test
    public void entrySetTest() {
        Map<Object, Object> map = getHashMap();
        Set<Entry<Object, Object>> entrySet = map.entrySet();
        Iterator<Entry<Object, Object>> ite = entrySet.iterator();
        while (ite.hasNext()) {
            Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) ite.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
