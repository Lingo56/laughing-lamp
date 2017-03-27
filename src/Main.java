import java.util.Scanner;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*; // For Input Stream


public class Main extends JFrame {

    //Frame width and height
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	
	//Objects
	private JPanel TitlePanel, UploadPanel, ButtonPanel, InstructionPanel, NoisePanel, ScalePanel;
	private JLabel TitleLabel, InstructionLabel;
	private JButton ExitButton, UpscaleButton;
	private JRadioButton NoiseNoneRadio, NoiseLowRadio, NoiseMediumRadio, NoiseHighRadio;
	private JRadioButton OneRadio, OneSixRadio, TwoTimesRadio;
	private JTextArea theText; //TEMPORARY MIDDLE!!!!!!!!!!!!
	
	
    //GUI interface Constructor-----------------------------
    public Main()
    {
    	super("Main");
    	setTitle("Waif2x"); //set title of window
    	setSize(WIDTH, HEIGHT); //set size of window
    	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    	
    	BuildTitlePanel();
    	BuildInstructionPanel();
    	BuildUploadPanel();
    	BuildNoisePanel();
    	BuildScalePanel();
    	BuildButtons();
    	
    	setLayout(new GridLayout(6, 1)); //set gridlayout
    	add(TitlePanel);
    	add(InstructionPanel);
    	add(UploadPanel);
    	add(NoisePanel);
    	add(ScalePanel);
    	add(ButtonPanel);
    }
    
    
	public void BuildTitlePanel()
	{
		TitleLabel = new JLabel("Waifu 2x Upscaling Program");
		
		//create TitlePanel
		TitlePanel = new JPanel();
		
		//add labels to the panel
		TitlePanel.add(TitleLabel);
	}
	
	public void BuildInstructionPanel()
	{
		InstructionLabel = new JLabel("Upload your image to the by dragging and dropping");
		
		//create TitlePanel
		InstructionPanel = new JPanel();
		
		//add labels to the panel
		InstructionPanel.add(InstructionLabel);
	}
	
	public void BuildUploadPanel()
	{	
		UploadPanel = new JPanel();
		UploadPanel.setBackground(Color.blue);
		theText = new JTextArea(13, 45);
		theText.setBackground(Color.white);
		
		//create UploadPanel
		UploadPanel = new JPanel();
		
		UploadPanel.add(theText);
	}
	
	
	public void BuildNoisePanel()
	{
		JLabel RadioLabel = new JLabel("Select noise reduction: ");
		NoiseNoneRadio = new JRadioButton("None");
		NoiseLowRadio = new JRadioButton("Low");
		NoiseMediumRadio = new JRadioButton("Medium");
		NoiseHighRadio = new JRadioButton("High");
		
		NoiseNoneRadio.addActionListener(new NoiseNoneRadioListener());
		NoiseLowRadio.addActionListener(new NoiseLowRadioListener());
		NoiseMediumRadio.addActionListener(new NoiseMediumRadioListener());
		NoiseHighRadio.addActionListener(new NoiseHighRadioListener());
		
		//create ButtonPanel
		NoisePanel = new JPanel();
		
		//Button group so only one can be selected
		ButtonGroup noisegroup = new ButtonGroup();
		noisegroup.add(NoiseNoneRadio);
		noisegroup.add(NoiseLowRadio);
		noisegroup.add(NoiseMediumRadio);
		noisegroup.add(NoiseHighRadio);
				
		//adds label and radio buttons
		NoisePanel.add(NoiseNoneRadio);
		NoisePanel.add(NoiseLowRadio);
		NoisePanel.add(NoiseMediumRadio);
		NoisePanel.add(NoiseHighRadio);
	}
	
	
	
	public void BuildScalePanel()
	{
		JLabel RadioLabel = new JLabel("Select upscale multiplier: ");
		OneRadio = new JRadioButton("None");
		OneSixRadio = new JRadioButton("1.6x");
		TwoTimesRadio = new JRadioButton("2x");
		
		OneRadio.addActionListener(new OneRadioListener());
		OneSixRadio.addActionListener(new OneSixRadioListener());
		TwoTimesRadio.addActionListener(new TwoTimesRadioListener());
		
		//create ButtonPanel
		ScalePanel = new JPanel();
		
		//Button group so only one can be selected
		ButtonGroup scalegroup = new ButtonGroup();
		scalegroup.add(OneRadio);
		scalegroup.add(OneSixRadio);
		scalegroup.add(TwoTimesRadio);
				
		//adds label and radio buttons
		ScalePanel.add(OneRadio);
		ScalePanel.add(OneSixRadio);
		ScalePanel.add(TwoTimesRadio);
	}
	
	public void BuildButtons()
	{
		ExitButton = new JButton("Exit");
		UpscaleButton = new JButton("Upscale");
		
		ExitButton.addActionListener(new ExitButtonListener());
		UpscaleButton.addActionListener(new UpscaleButtonListener());
		
		//create ButtonPanel
		ButtonPanel = new JPanel();
				
		ButtonPanel.add(ExitButton);
		ButtonPanel.add(UpscaleButton);
	}

	
	
	//-------------------BUTTONS-------------------------
	
	//CLOSE BUTTON----------
	private class ExitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	//UPSCALE BUTTON---------
	private class UpscaleButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("\nYou've pressed the 'Upscale' Button");
		}
	}
	
	
	//NOISE RADIO---------
	private class NoiseNoneRadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("\nYou've selected the 'None' Button");
		}
	}
	private class NoiseLowRadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("\nYou've selected the 'Low' Button");
		}
	}
	private class NoiseMediumRadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("\nYou've selected the 'Medium' Button");
		}
	}
	private class NoiseHighRadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("\nYou've selected the 'High' Button");
		}
	}
	
	
	//MULTIPLIER RADIO---------
	private class OneRadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("\nYou've selected the 'None' Button");
		}
	}
	private class OneSixRadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("\nYou've selected the '1.6x' Button");
		}
	}
	private class TwoTimesRadioListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("\nYou've selected the '2x' Button");
		}
	}
	
	
	//-------------------BUTTONS-------------------------
	

    public static void main(String[] args) {

        // Console Output

        System.out.println("What am I doing?! Steven Saito");

        System.out.println("Seasons pass snow and snow"); //Steven Saito

        System.out.println("Im Fancy! Avneet Sekhon");

        System.out.println("More to add to the project. Peter");

        // Runs ipconfig

        Runtime runtime = Runtime.getRuntime();

        try {
            Process process = runtime.exec("ipconfig"); // you might need the full path
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
        Main GUIinterface = new Main();
        GUIinterface.setVisible(true);

    }
    
    
}
