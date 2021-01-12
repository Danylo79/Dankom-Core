package dev.dankom.test.tests;

import dev.dankom.core.Core;
import dev.dankom.test.RuntimeTest;
import dev.dankom.test.Test;
import dev.dankom.util.general.ArrayUtil;
import dev.dankom.util.json.JsonExpose;
import dev.dankom.util.json.JsonSerializable;

import java.util.List;

public class JsonTest extends RuntimeTest {
    @Test
    public void serialize() {
        String i1 = new SerializeTest().toJSONString();
        Core.getLogger().info("JsonTest", i1);
    }

    public class SerializeTest implements JsonSerializable {
        @JsonExpose
        public String foo = "bar";
        @JsonExpose(customName = "test1")
        public String test = "test";
        @JsonExpose
        public List<String> strings = ArrayUtil.create("foo", "bar");
    }
}