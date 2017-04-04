import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**

    Not complete yet, currently leads to a folder specifically on my hard drive to a specific image
    You can test this by changing the path down there and compiling the project into a jar
    The program works it just needs some more time to get the noise level, scale ratio, and image locations working


 **/

public class Upscale {

    Util utility;


    public Upscale(Util util){
        utility = util;
    }


    // Runs a commandline within java to convert an image using the settings the user provided in the GUI
    public void convert() throws IOException
    {
        Runtime runtime = Runtime.getRuntime();

        String flags = utility.getFlags();


        Process waifu2x = runtime.exec(
                "cmd /c start waifu2x-converter-cpp.exe " +              // Launches the Waifu2x Wrapper
                flags +
                " --processor " + "1"                                               // To stop Waifu2x from using Nvidia CUDA cores and crashing the app
        );

        InputStream is = waifu2x.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

}
