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
        String tag = element.getClassName();

        println(type, tag, msg, element);
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


    // Info

    public static void i(String tag, Object value) {
        println(Log.INFO, tag, value.toString());
    }

    public static void i(Object value) {
        println(Log.INFO, value.toString());
    }

    public static void i(String tag, String format, Object... args) {
        i(tag, String.format(format, args));
    }


    // Debug

    public static void d(String tag, Object value) {
        println(Log.DEBUG, tag, value.toString());
    }

    public static void d(Object value) {
        println(Log.DEBUG, value.toString());
    }

    public static void d(String tag, String format, Object... args) {
        d(tag, String.format(format, args));
    }


    // Error

    public static void e(String tag, Object value) {
        println(Log.ERROR, tag, value.toString());
    }

    public static void e(Object value) {
        println(Log.ERROR, value.toString());
    }

    public static void e(String tag, String format, Object... args) {
        e(tag, String.format(format, args));
    }


    // Warn

    public static void w(String tag, Object value) {
        println(Log.WARN, tag, value.toString());
    }

    public static void w(Object value) {
        println(Log.WARN, value.toString());
    }

    public static void w(String tag, String format, Object... args) {
        w(tag, String.format(format, args));
    }


    // Verbose

    public static void v(String tag, Object value) {
        println(Log.VERBOSE, tag, value.toString());
    }

    public static void v(Object value) {
        println(Log.VERBOSE, value.toString());
    }

    public static void v(String tag, String format, Object... args) {
        v(tag, String.format(format, args));
    }


    // Assert

    public static void wtf(String tag, Object value) {
        println(Log.ASSERT, tag, value.toString());
    }

    public static void wtf(Object value) {
        println(Log.ASSERT, value.toString());
    }

    public static void wtf(String tag, String format, Object... args) {
        wtf(tag, String.format(format, args));
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
}

