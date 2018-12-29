package api;

public interface Logger {
    void log(String message);
    void logInfo(String message);
    void setName(String name);
    void setVersion(double version);
}
