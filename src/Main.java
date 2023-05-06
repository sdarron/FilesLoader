import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "src/google.png";
        String url = "https://www.google.com.ua/images/srpr/logo11w.png";

        FileOutputStream fout = null;
        BufferedInputStream in = null;
        try{
            in = new BufferedInputStream( new URL(url).openStream());   // устанавливаем соединение
            fout = new FileOutputStream(fileName);
            byte data[] = new byte[1024];
            int count;
            while ((count = in.read( data, 0, 1024)) != - 1){
                fout.write(data, 0, count);
                fout.flush();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}