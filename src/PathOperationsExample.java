import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathOperationsExample {
    public static void main(String[] args) {

        // 1. Working with Relative and Absolute Paths
        Path relativePath = Paths.get("testing");
        Path absolutePath = relativePath.toAbsolutePath();
        System.out.println("Relative Path: " + relativePath);
        System.out.println("Converted to Absolute Path: " + absolutePath);

        // Preparing for symbolic link creation
        Path targetFile = Paths.get("testing/TargetFile.txt");
        try {
            // Ensure target file exists
            if (!Files.exists(targetFile)) {
                Files.createFile(targetFile);
            }
        } catch (IOException e) {
            System.err.println("Error preparing target file: " + e.getMessage());
        }

        Path symLink = Paths.get("testing/SymLink");

        // 2. Creating a Symbolic Link
        try {
            if (!Files.exists(symLink)) {
                Files.createSymbolicLink(symLink, targetFile);
                System.out.println("Symbolic Link Created: " + symLink + " -> " + targetFile);
            }
        } catch (IOException e) {
            System.err.println("Error creating symbolic link: " + e.getMessage());
        }

        // 3. Checking if a Path is a Symbolic Link
        boolean isSymLink = Files.isSymbolicLink(symLink);
        System.out.println("Is " + symLink + " a symbolic link? " + isSymLink);

        // 4. Resolving Paths
        Path baseDir = Paths.get("/usr/local");
        Path resolvedPath = baseDir.resolve("bin/someExecutable");
        System.out.println("Resolved Path: " + resolvedPath);
    }
}
