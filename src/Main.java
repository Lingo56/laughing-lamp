import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Main {
	
	static JTextField name;
    static JTextField upload;
    

    public static void main(String[] args) {
    	
    	javax.swing.SwingUtilities.invokeLater(new Runnable()
    	{
            public void run()
            {
                frame();
            }
    	});

    		
        System.out.println("What am I doing?! Steven Saito");

        System.out.println("Seasons pass snow and snow"); //Steven Saito

        System.out.println("Im Fancy! Avneet Sekhon");

        System.out.println("More to add to the project. Peter");



    }
    

    
    private static void frame()
    {
    	
    	//create frame
    	JFrame frame = new JFrame("Waifu2x");
    	name = new JTextField(10);
        upload = new JTextField(10);
        
    	//create panel
    	JPanel panel = new JPanel(new BorderLayout(5,5));
        panel.setBorder(new EmptyBorder(10,10,10,10));
        frame.setContentPane(panel);
        
    	//boundaries
    	frame.setSize(500, 500);
    	
    	//Close Button
    	JButton buttonclose = new JButton();
    	buttonclose.setText("Exit");
    	
    	//When frame closes
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        //------------
    	JPanel namelabel = new JPanel(new GridLayout(0,1));
        JPanel uploadlabel = new JPanel(new GridLayout(0,1));
        panel.add(buttonclose, BorderLayout.SOUTH);
        panel.add(namelabel, BorderLayout.WEST);
        panel.add(uploadlabel, BorderLayout.CENTER);

        //----------------
        namelabel.add(new JLabel("Enter your name: "));
        uploadlabel.add(name);
        namelabel.add(new JLabel("Upload: "));
        uploadlabel.add(upload);
        //close = new JButton("Submit");

        //panel.add(submit, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
              

    	//close window when button pressed
    	buttonclose.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e)
    	    {
    	       System.exit(0);
    	    }
    	});
    
    }

}
