public class FileOrganiserApp {
    /*  To run this program from the command line, navigate to the directory containing the FileOrganiserApp.java
        file and compile it with javac FileOrganiserApp.java. Then, run the program using...
        java FileOrganiserApp [directoryPath]
        replacing [directoryPath] with the path of the directory we want to organize.

    */

    public static void main(String[] args) {
        if(args.length > 0){
            FileIO fileIO = new FileIO();
            fileIO.organiseFiles(args[0]);  // Take the directory path from the command line
        } else {
            System.out.println("Please provide a directory path.");
        }
    }
}