package com.sina.crm.collection_;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author caoshuai
 * @version 1.0
 */
public class DAO<T> {
    Map<String, T> map;

    public void save(String id, T entity) {
        this.map.put(id, entity);
    }

    public T get(String id) {
        return this.map.get(id);
    }

    public void update(String id, T entity) {
        this.map.put(id, entity);
    }

    public List<T> list() {
        Set<String> strings = map.keySet();
        ArrayList<T> ts = new ArrayList<>();
        for (String str : strings) {
            T t = this.map.get(str);
            ts.add(t);
        }
        return ts;
    }

    public void dalete(String id) {
        this.map.remove(id);
    }
}
