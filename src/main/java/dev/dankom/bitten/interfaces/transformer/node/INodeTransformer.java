package dev.dankom.bitten.interfaces.transformer.node;

import jdk.internal.org.objectweb.asm.tree.InsnList;

public interface INodeTransformer {
    void transform(InsnList list);
}
