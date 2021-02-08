package dev.dankom.exception;

import dev.dankom.bitten.util.Bytecode;
import jdk.internal.org.objectweb.asm.tree.AbstractInsnNode;
import jdk.internal.org.objectweb.asm.tree.MethodInsnNode;

/**
 * Exception thrown when comparing two synthetic bridge methods fails, thrown
 * with the corresponding problem and functionality to support debugging when
 * verbosity is enabled.
 */
public class SyntheticBridgeException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Problem types for synthetic bridge comparisons
     */
    public enum Problem {

        BAD_INSN("Conflicting opcodes %4$s and %5$s at offset %3$d in synthetic bridge method %1$s%2$s"),
        BAD_LOAD("Conflicting variable access at offset %3$d in synthetic bridge method %1$s%2$s"),
        BAD_CAST("Conflicting type cast at offset %3$d in synthetic bridge method %1$s%2$s"),
        BAD_INVOKE_NAME("Conflicting synthetic bridge target method name in synthetic bridge method %1$s%2$s Existing:%6$s Incoming:%7$s"),
        BAD_INVOKE_DESC("Conflicting synthetic bridge target method descriptor in synthetic bridge method %1$s%2$s Existing:%8$s Incoming:%9$s"),
        BAD_LENGTH("Mismatched bridge method length for synthetic bridge method %1$s%2$s unexpected extra opcode at offset %3$d");

        private final String message;

        Problem(String message) {
            this.message = message;
        }

        String getMessage(String name, String desc, int index, AbstractInsnNode a, AbstractInsnNode b) {
            return String.format(this.message, name, desc, index, Bytecode.getOpcodeName(a), Bytecode.getOpcodeName(a),
                    Problem.getInsnName(a), Problem.getInsnName(b), Problem.getInsnDesc(a), Problem.getInsnDesc(b));
        }

        private static String getInsnName(AbstractInsnNode node) {
            return node instanceof MethodInsnNode ? ((MethodInsnNode)node).name : "";
        }

        private static String getInsnDesc(AbstractInsnNode node) {
            return node instanceof MethodInsnNode ? ((MethodInsnNode)node).desc : "";
        }

    }

    /**
     * Problem?
     */
    private final Problem problem;

    /**
     * Bridge method name and descriptor
     */
    private final String name, desc;

    /**
     * Opcode index where the mismatch occurred
     */
    private final int index;

    /**
     * Mismatched nodes, a is from the target class, b is from the incoming
     * class
     */
    private final AbstractInsnNode a, b;

    public SyntheticBridgeException(Problem problem, String name, String desc, int index, AbstractInsnNode a, AbstractInsnNode b) {
        super(problem.getMessage(name, desc, index, a, b));
        this.problem = problem;
        this.name = name;
        this.desc = desc;
        this.index = index;
        this.a = a;
        this.b = b;
    }
}
