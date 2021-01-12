package dev.dankom.util.json;

import dev.dankom.util.general.StringUtil;
import org.json.simple.JSONAware;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface JsonSerializable extends JSONAware {
    @Override
    default String toJSONString() {
        String out = "{";
        try {
            for (int i = 0; i < fields().size(); i++) {
                Field f = fields().get(i);
                JsonExpose a = f.getAnnotation(JsonExpose.class);
                String name = (a.customName().equalsIgnoreCase("") ? f.getName() : a.customName());
                Object value = f.get(this);
                if (i == (fields().size() - 1)) {
                    out += StringUtil.wrap(name, "\"") + ": " + StringUtil.wrap(value, "\"");
                } else {
                    out += StringUtil.wrap(name, "\"") + ": " + StringUtil.wrap(value, "\"") + ", ";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out += "}";
        return out;
    }

    default List<Field> fields() {
        List<Field> fields = new ArrayList<>();
        for (Field f : getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(JsonExpose.class)) {
                fields.add(f);
            }
        }
        return fields;
    }
}
