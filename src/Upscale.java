import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by theli on 3/28/2017.
 */
public class Upscale {

    public Upscale(){

    }


    // Runs ipconfig
    public void convert()
    {
        Runtime runtime = Runtime.getRuntime();

        try {
            Process process = runtime.exec("cmd /c start waifu2x-converter-cpp.exe"); // you might need the full path
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }

}
