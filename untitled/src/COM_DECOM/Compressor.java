package COM_DECOM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static void method(File file) throws IOException {
        //we need to store the parent directory in a variable
        //so that we can store the compressed file also in the same directory
        String fileDirectory = file.getParent();

        //we need to create a file input stream, and we can add this curr file
        FileInputStream fis = new FileInputStream(file);
        //we need to create a file output stream and pass this parent directory path, so that our output file will be stored in same loc
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.gz");
        //we can make use of GZ library to compress and store the compressed file
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        //creating a buffer array of byte type store each byte from the input file
        byte[] buffer = new byte[1024];
        //len representing the length of file input stream
        int len;

        //using the gzip to write this buffer array
        while ((len = fis.read(buffer)) != -1) gzip.write(buffer, 0, len);

        gzip.close();
        fos.close();
        fis.close();
    }
    public static void main(String[] args) throws IOException {
        File file = new File("");
        method(file);
    }
}
