package newfeatures.java7;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class WatchServiceInJava7 {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
/*        directoryWatchService();

        Map<String, String> parametersDescription = new HashMap<>();
        parametersDescription.put("Returns the version of the Java Runtime Environment (JRE)", "java.version");
        parametersDescription.put("Returns the vendor that provided the JRE", "java.vendor");
        parametersDescription.put("Returns the installation directory of the JRE", "java.home");
        parametersDescription.put("Returns the name of the operating system", "os.name");
        parametersDescription.put("Returns the version of the operating system", "os.version");
        parametersDescription.put("Returns the architecture of the operating system", "os.arch");
        parametersDescription.put("Returns the name of the user running the JVM", "user.name");
        parametersDescription.put("Returns the current working directory", "user.dir");
        parametersDescription.put("Returns the temporary directory", "java.io.tmpdir");
        parametersDescription.put("Returns the file separator character (e.g., '/' on Unix-like systems, '' on Windows)", "file.separator");
        parametersDescription.put("Returns the path separator character (e.g., ':' on Unix-like systems, ';' on Windows)", "path.separator");
        parametersDescription.put("Returns the line separator character (e.g., '\n' on Unix-like systems, '\r\n' on Windows)", "line.separator");
        parametersDescription.put("Returns the user's home directory", "user.home");

        parametersDescription.forEach((key, value) -> {
            System.out.println(key + " : " + System.getProperty(value));
        });*/


        Path path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources");
        System.out.println("Resource directory: " + path.toAbsolutePath());

        if (path.toFile().exists()) {
            File[] files = path.toFile().listFiles();

            // Check if the directory is empty
            assert files != null;
            if (files.length == 0) {
                System.out.println("The directory is empty.");
            } else {
                System.out.println("Files in the directory:");
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            }
        } else {
            System.out.println("The specified path is not a directory.");
        }
    }
}

