package dev.dankom.bitten.util;

/**
 * Miscellaneous shared constants
 */
public abstract class Constants {

    public static final String CTOR = "<init>";
    public static final String CLINIT = "<clinit>";
    public static final String IMAGINARY_SUPER = "super$";

    public static final String STRING = "java/lang/String";
    public static final String OBJECT = "java/lang/Object";
    public static final String CLASS = "java/lang/Class";

    public static final String STRING_DESC = "L" + Constants.STRING + ";";
    public static final String OBJECT_DESC = "L" + Constants.OBJECT + ";";
    public static final String CLASS_DESC = "L" + Constants.CLASS + ";";

    public static final char UNICODE_SNOWMAN = '\u2603';

    public static final String SIDE_DEDICATEDSERVER = "DEDICATEDSERVER";
    public static final String SIDE_SERVER = "SERVER";
    public static final String SIDE_CLIENT = "CLIENT";
    public static final String SIDE_UNKNOWN = "UNKNOWN";

    private Constants() {}
}
