import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileIO {
    // Method to organise files in the folder by their extensions.
    public void organiseFiles(String directoryPath){
        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles();
        String parentFolderName = folder.getName(); // Get the parent folder's name

        System.out.println("Organising directory: " + directoryPath); // Print the directory being organised

        if(listOfFiles != null){
            Map<String, File> directories = new HashMap<>();
            for(File file : listOfFiles){
                if(file.isFile()){
                    String ext = getFileExtension(file);
                    // Change directory naming to include parent folder name and extension
                    String newDirName = parentFolderName + "_" + ext;

                    directories.putIfAbsent(ext, new File(folder + File.separator + newDirName));
                    if(directories.get(ext).mkdir()) { // Check if directory was created
                        System.out.println("Created directory for ." + ext + " files.");
                    }
                    System.out.println("Moving " + file.getName() + " to " + newDirName + "/");
                    file.renameTo(new File(directories.get(ext) + File.separator + file.getName()));
                }
                else if (file.isDirectory()) {
                    System.out.println("Entering subdirectory: " + file.getName());
                    organiseFiles(file.getPath()); // Recursively organize files in the subdirectory
                }
            }
        }
        else {
            System.out.println("No files found in directory: " + directoryPath);
        }
    }

    // Utility method to get the file extension
    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if(lastIndexOf == -1){
            return "other";// no extension found, place in "other" folder.
        }
        return name.substring(lastIndexOf + 1);
    }

}
