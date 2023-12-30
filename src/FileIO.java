import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileIO {
    // Method to organise files in the folder by their extensions.
    public void organiseFiles(String directoryPath){
        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles();

        if(listOfFiles != null){
            Map<String, File> directories = new HashMap<>();
            for(File file: listOfFiles){
                if(file.isFile()){
                    String ext = getFileExtension(file);
                    directories.putIfAbsent(ext, new File(folder + File.separator + ext));
                    file.renameTo(new File(directories.get(ext) + File.separator + file.getName()));
                }
            }
        }

    }

    // Utility method to get the file extension
    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if(lastIndexOf == -1){
            return "other";// no extension found.
        }
        return name.substring(lastIndexOf + 1);
    }

}
