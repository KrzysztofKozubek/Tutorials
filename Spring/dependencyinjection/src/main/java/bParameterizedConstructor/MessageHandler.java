package bParameterizedConstructor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MessageHandlerParameterizedConstructor")
public class MessageHandler {

    private Logger logger;
    private String nameLogger;

    @Autowired
    public MessageHandler(Logger logger, String nameLogger) {
        this.logger = logger;
        this.nameLogger = nameLogger;
    }

    public Logger getLogger() {
        return logger;
    }

    public void logMessage(String message) {
        logger.info(nameLogger + "(" + message + ")");
    }
}
