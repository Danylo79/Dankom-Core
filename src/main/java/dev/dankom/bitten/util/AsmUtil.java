package dev.dankom.bitten.util;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

public class AsmUtil {
    public static class Adapter {

        public Adapter() throws Exception {
            throw new Exception("The class Adapter can not be instantiated!");
        }

        public static final int PUBLIC = Op.ACC_PUBLIC;
        public static final int PRIVATE = Op.ACC_PRIVATE;
        public static final int PROTECTED = Op.ACC_PROTECTED;

        public static final int FINAL = Op.ACC_FINAL;
        public static final int ABSTRACT = Op.ACC_ABSTRACT;
        public static final int STATIC = Op.ACC_STATIC;
        public static final int NATIVE = Op.ACC_NATIVE;
        public static final int STRICT = Op.ACC_STRICT;
        public static final int SYNC = Op.ACC_SYNCHRONIZED;
        public static final int SYNTHETIC = Op.ACC_SYNTHETIC;

        public static final int INTERFACE = Op.ACC_INTERFACE;
        public static final int ENUM = Op.ACC_ENUM;

        public static final int ANNOTATION = Op.ACC_ANNOTATION;
        public static final int DEPRECATED = Op.ACC_DEPRECATED;
    }
    public static class Api {

        public Api() throws Exception {
            throw new Exception("The class Api can not be instantiated!");
        }

        public static final int LATEST = Op.ASM5;
        public static final int ASM5 = Op.ASM5;
        public static final int ASM4 = Op.ASM4;

        public static final int COMPUTE_MAXS = ClassWriter.COMPUTE_MAXS;
        public static final int COMPUTE_FRAMES = ClassWriter.COMPUTE_FRAMES;

        public static final int EXPAND_FRAMES = ClassReader.EXPAND_FRAMES;
        public static final int SKIP_FRAMES = ClassReader.SKIP_FRAMES;
        public static final int SKIP_CODE = ClassReader.SKIP_CODE;
        public static final int SKIP_DEBUG = ClassReader.SKIP_DEBUG;

        public static final int JAVA_V1_1 = Op.V1_1;
        public static final int JAVA_V1_2 = Op.V1_2;
        public static final int JAVA_V1_3 = Op.V1_3;
        public static final int JAVA_V1_4 = Op.V1_4;
        public static final int JAVA_V1_5 = Op.V1_5;
        public static final int JAVA_V1_6 = Op.V1_6;
        public static final int JAVA_V1_7 = Op.V1_7;
        public static final int JAVA_V1_8 = Op.V1_8;
        public static final int JAVA_LATEST = Op.V1_8;
    }
    public static class Op implements Opcodes {
        public Op() throws Exception {
            throw new Exception("The class Op can not be instantiated!");
        }
    }
}
