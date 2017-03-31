import java.util.Scanner;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*; // For Input Stream


public class Main extends JFrame {


    public static void main(String[] args) {

        // Console Output

        System.out.println("What am I doing?! Steven Saito");

        System.out.println("Seasons pass snow and snow"); //Steven Saito

        System.out.println("Im Fancy! Avneet Sekhon");

        System.out.println("More to add to the project. Peter");

        // Runs ipconfig

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
        }catch(IOException e){
            System.out.println("IO Error");
        }

        // GUI------------------------------------------------------
        UI GUIinterface = new UI();
        GUIinterface.setVisible(true);
        

    }
    
    
}
