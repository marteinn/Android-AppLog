package se.marteinn.utils.logging;

import android.util.Log;


/**
 * Simplifies Android logging by accepting more loggable primary types and the ability to disable
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
     * Factory method to create a TagLog instance.
     * @param tag
     * @return
     */
    public static TagLog newTagLog(String tag) {
        return new TagLog(tag);
    }

    /**
     * Low level logging call against Log.println.
     * @param type
     * @param tag
     * @param msg
     */
    public static void println(int type, String tag, String msg) {
        if (sMute) return;

        Log.println(type, tag, msg);
    }

    // TODO: Find a way to make log calls less repetitive.

    // Info

    public static void i(String tag, String value) {
        println(Log.INFO, tag, value);
    }

    public static void i(String tag, int value) {
        println(Log.INFO, tag, String.valueOf(value));
    }

    public static void i(String tag, float value) {
        println(Log.INFO, tag, String.valueOf(value));
    }

    public static void i(String tag, double value) {
        println(Log.INFO, tag, String.valueOf(value));
    }

    public static void i(String tag, boolean value) {
        println(Log.INFO, tag, String.valueOf(value));
    }

    public static void i(String tag, String format, Object... args) {
        i(tag, String.format(format, args));
    }


    // Debug

    public static void d(String tag, String value) {
        println(Log.DEBUG, tag, value);
    }

    public static void d(String tag, int value) {
        println(Log.DEBUG, tag, String.valueOf(value));
    }

    public static void d(String tag, float value) {
        println(Log.DEBUG, tag, String.valueOf(value));
    }

    public static void d(String tag, double value) {
        println(Log.DEBUG, tag, String.valueOf(value));
    }

    public static void d(String tag, boolean value) {
        println(Log.DEBUG, tag, String.valueOf(value));
    }

    public static void d(String tag, String format, Object... args) {
        d(tag, String.format(format, args));
    }


    // Error

    public static void e(String tag, String value) {
        println(Log.ERROR, tag, value);
    }

    public static void e(String tag, int value) {
        println(Log.ERROR, tag, String.valueOf(value));
    }

    public static void e(String tag, float value) {
        println(Log.ERROR, tag, String.valueOf(value));
    }

    public static void e(String tag, double value) {
        println(Log.ERROR, tag, String.valueOf(value));
    }

    public static void e(String tag, boolean value) {
        println(Log.ERROR, tag, String.valueOf(value));
    }

    public static void e(String tag, String format, Object... args) {
        e(tag, String.format(format, args));
    }


    // Warn

    public static void w(String tag, String value) {
        println(Log.WARN, tag, value);
    }

    public static void w(String tag, int value) {
        println(Log.WARN, tag, String.valueOf(value));
    }

    public static void w(String tag, float value) {
        println(Log.WARN, tag, String.valueOf(value));
    }

    public static void w(String tag, double value) {
        println(Log.WARN, tag, String.valueOf(value));
    }

    public static void w(String tag, boolean value) {
        println(Log.WARN, tag, String.valueOf(value));
    }

    public static void w(String tag, String format, Object... args) {
        w(tag, String.format(format, args));
    }


    // Verbose

    public static void v(String tag, String value) {
        println(Log.VERBOSE, tag, value);
    }

    public static void v(String tag, int value) {
        println(Log.VERBOSE, tag, String.valueOf(value));
    }

    public static void v(String tag, float value) {
        println(Log.VERBOSE, tag, String.valueOf(value));
    }

    public static void v(String tag, double value) {
        println(Log.VERBOSE, tag, String.valueOf(value));
    }

    public static void v(String tag, boolean value) {
        println(Log.VERBOSE, tag, String.valueOf(value));
    }

    public static void v(String tag, String format, Object... args) {
        v(tag, String.format(format, args));
    }


    // Assert

    public static void wtf(String tag, String value) {
        println(Log.ASSERT, tag, value);
    }

    public static void wtf(String tag, int value) {
        println(Log.ASSERT, tag, String.valueOf(value));
    }

    public static void wtf(String tag, float value) {
        println(Log.ASSERT, tag, String.valueOf(value));
    }

    public static void wtf(String tag, double value) {
        println(Log.ASSERT, tag, String.valueOf(value));
    }

    public static void wtf(String tag, boolean value) {
        println(Log.ASSERT, tag, String.valueOf(value));
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

