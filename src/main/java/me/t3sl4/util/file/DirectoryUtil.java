package me.t3sl4.util.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for directory operations such as creation, deletion, and size calculation.
 */
public class DirectoryUtil {

    /**
     * Creates a directory including any necessary but nonexistent parent directories.
     * @param dirPath Path to the directory.
     * @return True if the directory is created.
     * @throws IOException If an I/O error occurs.
     */
    public static boolean createDirectory(String dirPath) throws IOException {
        Files.createDirectories(Paths.get(dirPath));
        return true;
    }

    /**
     * Creates one or more subdirectories inside the given parent directory.
     * @param parentDir Path to the parent directory.
     * @param subDirs Names of the subdirectories to create.
     * @return True if all subdirectories are created successfully.
     * @throws IOException If an I/O error occurs.
     */
    public static boolean createSubDirectory(String parentDir, String... subDirs) throws IOException {
        Path parentPath = Paths.get(parentDir);

        if (Files.exists(parentPath) && !Files.isDirectory(parentPath)) {
            throw new IOException("Belirtilen yol bir dosya: " + parentDir);
        }

        Files.createDirectories(parentPath);

        for (String subDir : subDirs) {
            Path subDirPath = parentPath.resolve(subDir);
            Files.createDirectories(subDirPath);
        }

        return true;
    }

    /**
     * Deletes a directory and all its contents.
     * @param dirPath Path to the directory.
     * @return True if the directory is deleted.
     * @throws IOException If an I/O error occurs.
     */
    public static boolean deleteDirectory(String dirPath) throws IOException {
        Files.walk(Paths.get(dirPath))
                .sorted((p1, p2) -> -p1.compareTo(p2))
                .forEach(p -> {
                    try {
                        Files.delete(p);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        return true;
    }

    /**
     * Checks if a directory is empty.
     * @param dirPath Path to the directory.
     * @return True if the directory is empty, false otherwise.
     * @throws IOException If an I/O error occurs.
     */
    public static boolean isDirectoryEmpty(String dirPath) throws IOException {
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(dirPath))) {
            return !dirStream.iterator().hasNext();
        }
    }

    /**
     * Lists all files in a directory.
     * @param dirPath Path to the directory.
     * @return List of file paths in the directory.
     * @throws IOException If an I/O error occurs.
     */
    public static List<String> listFiles(String dirPath) throws IOException {
        List<String> fileList = new ArrayList<>();
        Files.list(Paths.get(dirPath)).forEach(path -> fileList.add(path.toString()));
        return fileList;
    }

    /**
     * Calculates the size of a directory.
     * @param dirPath Path to the directory.
     * @return Size of the directory in bytes.
     * @throws IOException If an I/O error occurs.
     */
    public static long getDirectorySize(String dirPath) throws IOException {
        final long[] size = {0};
        Files.walkFileTree(Paths.get(dirPath), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                size[0] += attrs.size();
                return FileVisitResult.CONTINUE;
            }
        });
        return size[0];
    }

    /**
     * Counts the number of files in a directory.
     * @param dirPath Path to the directory.
     * @return Number of files in the directory.
     * @throws IOException If an I/O error occurs.
     */
    public static int getFileCount(String dirPath) throws IOException {
        return (int) Files.list(Paths.get(dirPath)).count();
    }
}

