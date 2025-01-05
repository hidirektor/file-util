package me.t3sl4.util.file;

import java.io.*;
import java.nio.file.*;

/**
 * Utility class for file operations such as reading, writing, copying, and compressing files.
 */
public class FileUtil {

    /**
     * Reads the content of a file as a string.
     * @param filePath Path to the file.
     * @return File content as string.
     * @throws IOException If an I/O error occurs.
     */
    public static String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    /**
     * Writes content to a file.
     * @param filePath Path to the file.
     * @param content Content to write.
     * @param append If true, appends content to the file; otherwise overwrites it.
     * @throws IOException If an I/O error occurs.
     */
    public static void writeFile(String filePath, String content, boolean append) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write(content);
        }
    }

    /**
     * Reads a file as a byte array.
     * @param filePath Path to the file.
     * @return Byte array containing file data.
     * @throws IOException If an I/O error occurs.
     */
    public static byte[] readFileAsBytes(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }

    /**
     * Writes a byte array to a file.
     * @param filePath Path to the file.
     * @param data Data to write.
     * @param append If true, appends data to the file; otherwise overwrites it.
     * @throws IOException If an I/O error occurs.
     */
    public static void writeFileAsBytes(String filePath, byte[] data, boolean append) throws IOException {
        try (OutputStream os = new FileOutputStream(filePath, append)) {
            os.write(data);
        }
    }

    /**
     * Checks if a file exists.
     * @param filePath Path to the file.
     * @return True if the file exists, false otherwise.
     */
    public static boolean fileExists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }

    /**
     * Checks if a file is readable.
     * @param filePath Path to the file.
     * @return True if the file is readable, false otherwise.
     */
    public static boolean isReadable(String filePath) {
        return Files.isReadable(Paths.get(filePath));
    }

    /**
     * Checks if a file is writable.
     * @param filePath Path to the file.
     * @return True if the file is writable, false otherwise.
     */
    public static boolean isWritable(String filePath) {
        return Files.isWritable(Paths.get(filePath));
    }

    /**
     * Checks if a file is hidden.
     * @param filePath Path to the file.
     * @return True if the file is hidden, false otherwise.
     * @throws IOException If an I/O error occurs.
     */
    public static boolean isHidden(String filePath) throws IOException {
        return Files.isHidden(Paths.get(filePath));
    }

    /**
     * Deletes a file.
     * @param filePath Path to the file.
     * @return True if the file is deleted, false otherwise.
     * @throws IOException If an I/O error occurs.
     */
    public static boolean deleteFile(String filePath) throws IOException {
        return Files.deleteIfExists(Paths.get(filePath));
    }

    /**
     * Moves a file to a new location.
     * @param sourcePath Source file path.
     * @param destPath Destination file path.
     * @return True if the file is moved successfully.
     * @throws IOException If an I/O error occurs.
     */
    public static boolean moveFile(String sourcePath, String destPath) throws IOException {
        Files.move(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
        return true;
    }

    /**
     * Copies a file to a new location.
     * @param sourcePath Source file path.
     * @param destPath Destination file path.
     * @return True if the file is copied successfully.
     * @throws IOException If an I/O error occurs.
     */
    public static boolean copyFile(String sourcePath, String destPath) throws IOException {
        Files.copy(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
        return true;
    }

    /**
     * Retrieves the file name from the file path.
     * @param filePath Path to the file.
     * @return File name as string.
     */
    public static String getFileName(String filePath) {
        return Paths.get(filePath).getFileName().toString();
    }

    /**
     * Retrieves the file extension.
     * @param filePath Path to the file.
     * @return File extension as string.
     */
    public static String getFileExtension(String filePath) {
        String fileName = getFileName(filePath);
        int lastIndex = fileName.lastIndexOf('.');
        return (lastIndex == -1) ? "" : fileName.substring(lastIndex + 1);
    }

    /**
     * Changes the file extension.
     * @param filePath Path to the file.
     * @param newExtension New extension to be applied.
     * @return Updated file path as string.
     */
    public static String changeFileExtension(String filePath, String newExtension) {
        String baseName = filePath.substring(0, filePath.lastIndexOf('.'));
        return baseName + "." + newExtension;
    }
}
