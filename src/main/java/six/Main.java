package six;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Main {
    public static void main(String[] args){

        String inFile = "C:\\Users\\laire\\Downloads\\student.management\\JavaZissenn\\src\\main\\java\\six\\file.txt";
        String outFile = "C:\\Users\\laire\\Downloads\\student.management\\JavaZissenn\\src\\main\\java\\six\\filegz.gz";

        try (
                FileInputStream fis = new FileInputStream(inFile);
                FileOutputStream fos = new FileOutputStream(outFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                GZIPOutputStream gzos = new GZIPOutputStream(bos);
                ){
            int i = fis.read();
            while (i != -1){
                gzos.write(i);
                i = fis.read();
            }
            gzos.finish();
        }catch (IOException e){
            System.out.println("失敗");
        }
    }
}
