package dev.dankom.test.tests;

import dev.dankom.test.RuntimeTest;
import dev.dankom.test.Test;
import dev.dankom.triggered.trigger.Trigger;
import dev.dankom.triggered.trigger.TriggerTranslator;
import dev.dankom.triggered.type.TriggerType;

public class TriggerTest extends RuntimeTest {
    @Test
    public void triggerTest() {
        Trigger trigger = new Trigger("Test", TriggerType.DURING);
        assertEquals(TriggerTranslator.translate(trigger), "Trigger={Test, Type={DURING}}");
    }
}
