package _7_file_and_io;

import java.io.*;
import java.util.Arrays;

public class IOStream {

    private static String pathToFile = "src\\main\\java\\_7_file_and_io\\files\\";

    /* read byte 8bits */
    static void byteStream() throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(pathToFile + "input.txt");
            fileOutputStream = new FileOutputStream(pathToFile + "output1.txt");

            /*
            Another way is using buffer in method read and write

            int size = fileInputStream.available();
            byte[] fileInByte = new byte[(int) size];
            fileInputStream.read(fileInByte);
            fileOutputStream.write(fileInByte);
            */

            int c;
            while ((c = fileInputStream.read()) != -1) {
                fileOutputStream.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    /* read character 16bits */
    static void fileReader() throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader(pathToFile + "input.txt");
            fileWriter = new FileWriter(pathToFile + "output2.txt");

            /*
            Another way is using buffer in method read and write

            long size = new File(pathToFile + "input.txt").length();
            byte[] fileInByte = new byte[(int) size];
            fileReader.read(fileInByte);
            fileWriter.write(fileInByte);
            */

            int c;
            while ((c = fileReader.read()) != -1) {
                fileWriter.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    static void fileNavigationIO() throws IOException {
        File file = new File(pathToFile + "parent\\child\\");
        file.mkdirs();

        file = new File(pathToFile + "input.txt");
        System.out.println(Arrays.toString(file.list()));
        System.out.println(file.toString());
        System.out.println(file.length());
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getFreeSpace());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getTotalSpace());
        System.out.println(file.getUsableSpace());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.lastModified());
    }

    public static void main(String[] args) throws IOException {

        fileNavigationIO();

        new Thread(() -> {
            try {
                long start = System.nanoTime();
                byteStream();
                long elapsedTime = System.nanoTime() - start;
                System.out.println(String.format("%s: %sns -> %sms -> %ss",
                        "byteStream",
                        elapsedTime,
                        elapsedTime / 1_000_000,
                        elapsedTime / 1_000_000_000));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                long start = System.nanoTime();
                fileReader();
                long elapsedTime = System.nanoTime() - start;
                System.out.println(String.format("%s: %sns -> %sms -> %ss",
                        "fileReader",
                        elapsedTime,
                        elapsedTime / 1_000_000,
                        elapsedTime / 1_000_000_000));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
