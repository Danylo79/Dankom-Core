package dev.dankom.bitten.asm;

import dev.dankom.bitten.interfaces.generator.IClassGenerator;
import dev.dankom.bitten.interfaces.transformer.clazz.IClassTransformer;
import dev.dankom.bitten.util.ByteUtil;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.File;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class ClassGenerator implements IClassGenerator {

    private IClassTransformer[] transformers;

    public ClassGenerator(IClassTransformer... transformers) {
        this.transformers = transformers;
    }

    @Override
    public void generate(String name, File path) {
        try {
            ClassWriter cw = new ClassWriter(0);

            cw.visit(V1_8, ACC_PUBLIC + ACC_SUPER, name, null, "java/lang/Object", null);

            for (IClassTransformer imt : transformers) {
                imt.transform(cw);
            }

            cw.visitEnd();

            File file = new File(path.getAbsolutePath());
            if (!file.exists()) {
                file.mkdirs();
            }

            ByteUtil.save(name, path, cw.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
