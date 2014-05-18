package se.marteinn.utils.logging;

/**
 * Simplifying tagging event more then AppLog by accepting a tag argument,
 * while using AppLog's extended log value parameters.
 *
 * @author martinsandstrom
 */
public class TagLog {
    /**
     * The logging tag that will be used when calling AppLog.
     */
    private String mTag = "";

    /**
     * Simple constructor to use when creating standalone or from AppLog.
     * @param tag
     */
    public TagLog(String tag) {
        setTag(tag);
    }

    // TODO: Find a way to make log calls less repetitive.

    // Info

    public void i(String value) {
        AppLog.i(mTag, value);
    }

    public void i(int value) {
        AppLog.i(mTag, String.valueOf(value));
    }

    public void i(float value) {
        AppLog.i(mTag, String.valueOf(value));
    }

    public void i(double value) {
        AppLog.i(mTag, String.valueOf(value));
    }

    public void i(boolean value) {
        AppLog.i(mTag, String.valueOf(value));
    }

    public void i(String format, Object... args) {
        i(String.format(format, args));
    }


    // Debug

    public void d(String value) {
        AppLog.d(mTag, value);
    }

    public void d(int value) {
        AppLog.d(mTag, String.valueOf(value));
    }

    public void d(float value) {
        AppLog.d(mTag, String.valueOf(value));
    }

    public void d(double value) {
        AppLog.d(mTag, String.valueOf(value));
    }

    public void d(boolean value) {
        AppLog.d(mTag, String.valueOf(value));
    }


    // Error

    public void e(String value) {
        AppLog.e(mTag, value);
    }

    public void e(int value) {
        AppLog.e(mTag, String.valueOf(value));
    }

    public void e(float value) {
        AppLog.e(mTag, String.valueOf(value));
    }

    public void e(double value) {
        AppLog.e(mTag, String.valueOf(value));
    }

    public void e(boolean value) {
        AppLog.e(mTag, String.valueOf(value));
    }

    public void e(String format, Object... args) {
        e(String.format(format, args));
    }


    // Warn

    public void w(String value) {
        AppLog.w(mTag, value);
    }

    public void w(int value) {
        AppLog.w(mTag, String.valueOf(value));
    }

    public void w(float value) {
        AppLog.w(mTag, String.valueOf(value));
    }

    public void w(double value) {
        AppLog.w(mTag, String.valueOf(value));
    }

    public void w(boolean value) {
        AppLog.w(mTag, String.valueOf(value));
    }

    public void w(String format, Object... args) {
        w(String.format(format, args));
    }


    // Verbose

    public void v(String value) {
        AppLog.v(mTag, value);
    }

    public void v(int value) {
        AppLog.v(mTag, String.valueOf(value));
    }

    public void v(float value) {
        AppLog.v(mTag, String.valueOf(value));
    }

    public void v(double value) {
        AppLog.v(mTag, String.valueOf(value));
    }

    public void v(boolean value) {
        AppLog.v(mTag, String.valueOf(value));
    }

    public void v(String format, Object... args) {
        v(String.format(format, args));
    }


    // Assert

    public void wtf(String value) {
        AppLog.wtf(mTag, value);
    }

    public void wtf(int value) {
        AppLog.wtf(mTag, String.valueOf(value));
    }

    public void wtf(float value) {
        AppLog.wtf(mTag, String.valueOf(value));
    }

    public void wtf(double value) {
        AppLog.wtf(mTag, String.valueOf(value));
    }

    public void wtf(boolean value) {
        AppLog.wtf(mTag, String.valueOf(value));
    }

    public void wtf(String format, Object... args) {
        wtf(String.format(format, args));
    }


    // Getters + Setters

    /**
     * Set the log tag that will be used.
     * @return
     */
    public String getTag() {
        return mTag;
    }

    /**
     * Retrive log tag in use.
     * @param tag
     */
    public void setTag(String tag) {
        this.mTag = tag;
    }
}
