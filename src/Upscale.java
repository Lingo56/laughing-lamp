import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

/**

    Not complete yet, currently leads to a folder specifically on my hard drive to a specific image
    You can test this by changing the path down there and compiling the project into a jar
    The program works it just needs some more time to get the noise level, scale ratio, and image locations working


 **/

public class Upscale {

    Util utility;
    Pattern pattern = Pattern.compile("\\.(?=\\w+$)");

    public Upscale(Util util){
        utility = util;
    }


    // Runs a commandline within java to convert an image using the settings the user provided in the GUI
    public void convert()
    {
        Runtime runtime = Runtime.getRuntime();

        int noiseLevel = utility.getDeNoise();
        int scaleRatio = utility.getScale();
        String imageInputPath = utility.getImagePath();
        String[] splits = pattern.split(imageInputPath);

        String imageOutputPath = splits[0] + "_out." + splits[1];

        System.out.println(imageInputPath);

        try {
            Process process = runtime.exec(
                    "cmd /c start waifu2x-converter-cpp.exe" +    // Launches the Waifu2x Wrapper
                    " -m noise_scale" +                                     // Tells Waifu2x what type of operation it will per form (this case De-Noise + Scale)
                    " --noise_level " + "1" +                               // The amount of De-Noise applied
                    " --scale_ratio " + "1" +                               // The amount the image will be scaled up
                    " -i " + imageInputPath +                               // Input location command
                    " -o " + imageOutputPath +                              // Output location command
                    " --processor " + "1"                                   // To stop Waifu2x from using Nvidia CUDA cores and crashing the app
            );

            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IO Error: " + e);
        }
    }

}
