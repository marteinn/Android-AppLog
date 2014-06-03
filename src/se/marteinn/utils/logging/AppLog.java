package se.marteinn.utils.logging;

import android.util.Log;


/**
 * Simplifies Android logging by pointing out calling class/method,
 * accepting more loggable primary types and the ability to disable
 * log calls by muting them.
 *
 * @author martinsandstrom
 */
public class AppLog {
    /**
     * Used to disable log print.
     */
    private static Boolean sMute = false;

    /**
     * Removes namespace from class when using calling class as tag.
     */
    private static Boolean sSkipNamespace = false;


    /**
     * Regular log call that resolves stack element.
     * @param type
     * @param tag
     * @param msg
     */
    public static void println(int type, String tag, String msg) {
        StackTraceElement element = getTraceElement();

        println(type, tag, msg, element);
    }

    /**
     * Logging call that uses the calling class as tag.
     * @param type
     * @param msg
     */
    public static void println(int type, String msg) {
        StackTraceElement element = getTraceElement();
        String name = element.getClassName();

        if (sSkipNamespace) {
            name = name.substring(name.lastIndexOf(".")+1);
        }
        println(type, name, msg, element);
    }

    /**
     * Low level logging call against Log.println.
     * @param type
     * @param tag
     * @param msg
     * @param element
     */
    public static void println(int type, String tag, String msg, StackTraceElement element) {
        if (sMute) return;

        // Get info about the method invoking logging.
        String signature = String.format("\t(%s:%d)", element.getMethodName(),
                element.getLineNumber());

        // Run original logger
        Log.println(type, tag, msg+signature);
    }

    /**
     * Return the stack element invoking logging.
     * @return
     */
    public static StackTraceElement getTraceElement() {
        StackTraceElement[] elements = new Exception().getStackTrace();

        for (StackTraceElement element : elements) {
            if (! element.getClassName().startsWith("se.marteinn.utils.logging.")) {
                return element;
            }
        }

        return null;
    }

    /**
     * Handles object string conversion.
     * @param value
     * @return
     */
    private static String toString(Object value) {
        return (value != null) ? value.toString() : "null";
    }


    // Info

    public static void i(String tag, Object value) {
        println(Log.INFO, tag, toString(value));

    }

    public static void i(Object value) {
        println(Log.INFO, toString(value));
    }

    public static void i(String tag, LogFormat format, Object... args) {
        i(tag, String.format(format.getFormat(), args));
    }

    public static void i(LogFormat format, Object... args) {
        i(String.format(format.getFormat(), args));
    }



    // Debug

    public static void d(String tag, Object value) {
        println(Log.DEBUG, tag, toString(value));
    }

    public static void d(Object value) {
        println(Log.DEBUG, toString(value));
    }

    public static void d(String tag, LogFormat format, Object... args) {
        d(tag, String.format(format.getFormat(), args));
    }

    public static void d(LogFormat format, Object... args) {
        d(String.format(format.getFormat(), args));
    }


    // Error

    public static void e(String tag, Object value) {
        println(Log.ERROR, tag, toString(value));
    }

    public static void e(Object value) {
        println(Log.ERROR, toString(value));
    }

    public static void e(String tag, LogFormat format, Object... args) {
        e(tag, String.format(format.getFormat(), args));
    }

    public static void e(LogFormat format, Object... args) {
        e(String.format(format.getFormat(), args));
    }


    // Warn

    public static void w(String tag, Object value) {
        println(Log.WARN, tag, toString(value));
    }

    public static void w(Object value) {
        println(Log.WARN, toString(value));
    }

    public static void w(String tag, LogFormat format, Object... args) {
        w(tag, String.format(format.getFormat(), args));
    }

    public static void w(LogFormat format, Object... args) {
        w(String.format(format.getFormat(), args));
    }


    // Verbose

    public static void v(String tag, Object value) {
        println(Log.VERBOSE, tag, toString(value));
    }

    public static void v(Object value) {
        println(Log.VERBOSE, toString(value));
    }

    public static void v(String tag, LogFormat format, Object... args) {
        v(tag, String.format(format.getFormat(), args));
    }

    public static void v(LogFormat format, Object... args) {
        v(String.format(format.getFormat(), args));
    }


    // Assert

    public static void wtf(String tag, Object value) {
        println(Log.ASSERT, tag, toString(value));
    }

    public static void wtf(Object value) {
        println(Log.ASSERT, toString(value));
    }

    public static void wtf(String tag, LogFormat format, Object... args) {
        wtf(tag, String.format(format.getFormat(), args));
    }

    public static void wtf(LogFormat format, Object... args) {
        wtf(String.format(format.getFormat(), args));
    }


    // Getters + Setters

    /**
     * Set logger mutable state.
     * @param mute
     */
    public static void setMute(Boolean mute) {
        sMute = mute;
    }

    /**
     * Retrieve logger mutable state.
     * @return
     */
    public static Boolean getMute() {
        return sMute;
    }

    /**
     * Set namespace skip flag.
     * @return
     */
    public static void setSkipNamespace(Boolean skipNamespace) {
        AppLog.sSkipNamespace = skipNamespace;
    }

    /**
     * Get namespace skip flag.
     * @return
     */
    public static Boolean getSkipNamespace() {
        return sSkipNamespace;
    }
}
