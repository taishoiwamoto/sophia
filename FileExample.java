import java.io.File;
 
public class FileExample {
  public static void main(String[] args) {
    File poemFile = new File("poem.txt");
    System.out.println("File Information: ");
    System.out.println("File Name: " + poemFile.getName());
    System.out.println("File Path: " + poemFile.getPath());
    System.out.println("Full Path: " + poemFile.getAbsolutePath());
    System.out.println("File Size: " + poemFile.length());
    System.out.println("Can Read: " + poemFile.canRead());
    System.out.println("Can Write: " + poemFile.canWrite());
    System.out.println("Can Execute: " + poemFile.canExecute());
    
  }  
}
 