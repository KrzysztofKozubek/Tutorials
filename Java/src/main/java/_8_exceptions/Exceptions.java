package _8_exceptions;


/*
 * Exception is a problem that arises during the execution of a program
 * When an Exception occurs the normal flow of the program is disrupted and the program/Application terminates abnormally, which is not recommended, therefore, these exceptions are to be handled.
 *
 * Hierarchy:
 *
 *                    Object
 *                   Throwable
 *       Errors                     Exception
 *                   Runtime Exceptions    Other Exceptions
 *
 *
 *
 *   Example Error (hierarchy: Throwable -> Object -> java.lang)
 *   LinkageError, ThreadDeath, VirtualMachineError, AWTError
 *
 *   Example Runtime Exception (hierarchy: Exception -> Throwable -> Object -> java.lang)
 *   ArrayOfIndexException, NullPointerException, IllegalArgumentException, IndexOutOfBoundsException, SecurityException
 *
 *   Example Other Exception (hierarchy: Exception -> Throwable -> Object -> java.lang
 *   ClassNotFoundException, CloneNotSupportedException, IllegalAccessException, NoSuchMethodException, IOException
 *
 * */

import java.util.function.Consumer;

public class Exceptions {

    private static void throwException(Object message) throws Exception {
        throw new MyOwnOtherException(message);
    }

    private static void throwMyOwnException(Object message) {
        throw new MyOwnRunTimeException(message);
    }

    public static void main(String[] args) {
        Consumer[] suppliers = new Consumer[]{
                message -> {
                    try {
                        Exceptions.throwException(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                Exceptions::throwMyOwnException
        };

        suppliers[0].accept("MyOwnCaughtException");
        suppliers[1].accept("MyOwnNotCaughtRunTimeException");
    }
}

// Example run time exception
// This exceptions we dont need to catch
class MyOwnRunTimeException extends NullPointerException {
    MyOwnRunTimeException(Object s) {
        super(s.toString());
    }
}

// Example other example
class MyOwnOtherException extends ClassNotFoundException {
    MyOwnOtherException(Object s) {
        super(s.toString());
    }
}
