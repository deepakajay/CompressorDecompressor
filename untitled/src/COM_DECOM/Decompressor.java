package COM_DECOM;

import java.io.*;
import java.util.zip.GZIPInputStream;

public class Decompressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();

        //first we have to read the file, so we will use a file input stream
        FileInputStream fis = new FileInputStream(file);
        //as we know this file will be in compressed form, so we will use gzip input stream
        GZIPInputStream gzip = new GZIPInputStream(fis);
        //as we know the output will be in normal form, so we can use file output stream
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/DecompressedFile");

        //then we will do the exact same thing wht we did during compression but in reverse fashion
        byte[] buffer = new byte[1024];
        int len;

        while ((len = gzip.read(buffer)) != -1) fos.write(buffer, 0, len);

        gzip.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("");
        method(file);
    }
}
