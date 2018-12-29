package impl;

import api.Logger;

import java.util.Date;

public class LoggerImpl implements Logger {

    private String name;
    private double version;

    public void setVersion(double version) {
        this.version = version;
    }

    public void log(String message) {
        System.out.println(new Date() + " [" + name + " v." + version + "] : " + message);
    }

    public void logInfo(String message) {
        System.out.println(new Date() + "[INFO]" + " [" + name + " v." + version + "] : " + message);
    }

    public void setName(String name) {
        this.name = name;
    }
}
