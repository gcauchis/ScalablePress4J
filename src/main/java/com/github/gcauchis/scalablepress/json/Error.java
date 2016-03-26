package com.github.gcauchis.scalablepress.json;

/**
 * The Error json object.
 * 
 * @author gcauchis
 * @see https://scalablepress.com/docs/#standard-quote
 */
public class Error {
    /** Identifier for type of error message */
    private String code;
    /** Path in quote object causing error */
    private String path;
    /** User-friendly error message */
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error [code=" + code + ", path=" + path + ", message="
                + message + "]";
    }
}
