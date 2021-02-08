package dev.dankom.bitten.interfaces.transformer.clazz;

import jdk.internal.org.objectweb.asm.ClassWriter;

public interface IClassTransformer {
    void transform(ClassWriter cw);
}
