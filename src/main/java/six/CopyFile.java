package six;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPOutputStream;

public class CopyFile {
    public String filePath;
    public String copyPath;

    CopyFile(String filePath,String copyPath){
        this.filePath = filePath;
        this.copyPath = copyPath;
    }

    public static void main(String[] args) throws Exception {
        CopyFile copyFile = new CopyFile(
                "C:\\Users\\laire\\Downloads\\student.management\\JavaZissenn\\src\\main\\java\\six\\file.txt",
                "C:\\Users\\laire\\Downloads\\student.management\\JavaZissenn\\src\\main\\java\\six\\file.copy.txt"
                );

        FileInputStream fileInputStream = new FileInputStream(copyFile.filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(copyFile.copyPath);
        FileOutputStream fileOutputStreamGz = new FileOutputStream("C:\\Users\\laire\\Downloads\\student.management\\JavaZissenn\\src\\main\\java\\six\\filegz.gz");
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fileOutputStreamGz);
        int data = 0;
        try(fileOutputStream){
            while ((data = fileInputStream.read()) != -1) {
                System.out.print(data + "\n");
                fileOutputStream.write(data);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println("システムを終了します。");
        }
        System.out.println();
        System.out.println("data : " + data);
    }
}
