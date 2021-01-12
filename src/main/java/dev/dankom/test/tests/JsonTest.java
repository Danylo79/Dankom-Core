package dev.dankom.test.tests;

import dev.dankom.test.RuntimeTest;
import dev.dankom.test.Test;
import dev.dankom.util.json.JsonExpose;
import dev.dankom.util.json.JsonSerializable;

public class JsonTest extends RuntimeTest {
    @Test
    public void serialize() {
        assertEquals(new SerializeTest().toJSONString(), "{\"ee\": \"wow\"}");
    }

    public class SerializeTest implements JsonSerializable {
        @JsonExpose
        public String foo = "bar";
    }
}
