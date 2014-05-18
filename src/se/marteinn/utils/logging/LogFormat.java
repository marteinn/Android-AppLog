package se.marteinn.utils.logging;


/**
 * Holds the string format used in AppLog.
 * (Used primary to keep the log api simple and avoid method argument mismatches).
 * @author martinsandstrom
 */
public class LogFormat {
    private String sFormat;

    public LogFormat(String format) {
        setFormat(format);
    }


    // Getters & Setters

    public String getFormat() {
        return sFormat;
    }

    public void setFormat(String format) {
        this.sFormat = format;
    }
}
