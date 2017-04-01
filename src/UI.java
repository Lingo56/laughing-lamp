import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Created by theli on 3/28/2017. Updated by avneet on 03/30/2017.
 */
public class UI extends JFrame {
		//Frame width and height (updated by avneet)
		private static final int WIDTH = 500; 
		private static final int HEIGHT = 400; 
		
		//Objects (updated by avneet)
		private JPanel TitlePanel, BrowsePanel, ButtonPanel, InstructionPanel, NoisePanel, ScalePanel;
		private JLabel TitleLabel, InstructionLabel;
		private JButton ExitButton, UpscaleButton;
		private JRadioButton NoiseNoneRadio, NoiseLowRadio, NoiseMediumRadio, NoiseHighRadio;
		private JRadioButton OneRadio, OneSixRadio, TwoTimesRadio;
		private JTextField theText; //TEMPORARY MIDDLE!!!!!!!!!!!! ACTUALLY MAYBE NOT FOR URL UPLOAD
		private JButton BrowseButton;
		private Font displayFont = new Font("Apple Casual",Font.BOLD, 18);
		private JFileChooser myBrowser;
		private String path = "Browse for your image...";
		
		private Color bgColor = Color.white; 
		
		//Saito April 1 2017
		//-----Stores commands for command line, different options
		private static String Noisecmd;
		private static String Scalecmd;
		private static String Filecmd;
		private static String CommandInput;
		//-----Stores commands for command line
		
		
		//GUI interface Constructor-----------------------------
		//Build the Gui
	    public UI()
	    {
	    	super("Main");
	    	setTitle("Waifu2X"); //set title of window
	    	setSize(WIDTH, HEIGHT); //set size of window
	    	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	    	
	    	
	    	BuildTitlePanel();
	    	BuildInstructionPanel();
	    	BuildBrowsePanel();
	    	BuildNoisePanel();
	    	BuildScalePanel();
	    	BuildButtons();
	    	
	    	setLayout(new GridLayout(6, 0)); //set gridlayout
	    	add(TitlePanel);
	    	add(InstructionPanel);
	    	add(BrowsePanel);
	    	add(NoisePanel);
	    	add(ScalePanel);
	    	add(ButtonPanel);
	    	
	    	setBackground(bgColor);
	    }
	    
	    
	    
	    public void BuildTitlePanel() // (updated by avneet)
		{
			TitleLabel = new JLabel("Welcome to Waifu2X!");
			
			TitleLabel.setFont(displayFont);
			
			//create TitlePanel
			TitlePanel = new JPanel();
			TitlePanel.setBackground(bgColor);
			
			//add labels to the panel
			TitlePanel.add(TitleLabel);		
		}
		
		public void BuildInstructionPanel()
		{
			InstructionLabel = new JLabel("Choose File");
			
			//create TitlePanel
			InstructionPanel = new JPanel();
			InstructionPanel.setBackground(bgColor);
			
			//add labels to the panel
			InstructionPanel.add(InstructionLabel);
		}
		
		public void BuildBrowsePanel()// (updated by avneet)
		{	
			BrowsePanel = new JPanel();
			BrowsePanel.setBackground(bgColor);
			theText = new JTextField(30);
			theText.setBackground(bgColor);
			BrowseButton = new JButton("Browse");
			theText.setText("" + path);
			
			BrowseButton.addActionListener(new BrowseButtonListener());
			
			//create BrowsePanel (updated by avneet)
			BrowsePanel = new JPanel();
			BrowsePanel.setBackground(bgColor);
			BrowsePanel.add(theText);
			BrowsePanel.add(BrowseButton);
			
		}
		
		
		public void BuildNoisePanel() // (updated by avneet)
		{
			JLabel RadioLabel = new JLabel("Select noise reduction: ");
			NoiseNoneRadio = new JRadioButton("None");
			NoiseLowRadio = new JRadioButton("Low");
			NoiseMediumRadio = new JRadioButton("Medium");
			NoiseHighRadio = new JRadioButton("High");
			
			//NoiseHighRadio.setBackground(bgColor);  //Button was offsetting consistency in boxes around buttons    Saito April 1 2017
			
			NoiseLowRadio.addActionListener(new NoiseLowRadioListener());
			NoiseMediumRadio.addActionListener(new NoiseMediumRadioListener());
			NoiseHighRadio.addActionListener(new NoiseHighRadioListener());
			NoiseNoneRadio.addActionListener(new NoiseNoneRadioListener());
			
			
			//create ButtonPanel
			NoisePanel = new JPanel();
			NoisePanel.setBackground(bgColor);
			
			//Button group so only one can be selected
			ButtonGroup noisegroup = new ButtonGroup();
			noisegroup.add(NoiseLowRadio);
			noisegroup.add(NoiseMediumRadio);
			noisegroup.add(NoiseHighRadio);
			noisegroup.add(NoiseNoneRadio);
					
			//adds label and radio buttons
			NoisePanel.add(NoiseLowRadio);
			NoisePanel.add(NoiseMediumRadio);
			NoisePanel.add(NoiseHighRadio);
			NoisePanel.add(NoiseNoneRadio);
		}
		
		
		
		public void BuildScalePanel() // (updated by avneet)
		{
			JLabel RadioLabel = new JLabel("Select upscale multiplier: ");
			OneRadio = new JRadioButton("None");
			OneSixRadio = new JRadioButton("2x");
			TwoTimesRadio = new JRadioButton("4x");
			
			
			OneRadio.addActionListener(new OneRadioListener());
			OneSixRadio.addActionListener(new OneSixRadioListener());
			TwoTimesRadio.addActionListener(new TwoTimesRadioListener());
			
			//create ButtonPanel
			ScalePanel = new JPanel();
			ScalePanel.setBackground(bgColor);
			
			//Button group so only one can be selected (updated by avneet)
			ButtonGroup scalegroup = new ButtonGroup();
			scalegroup.add(OneSixRadio);
			scalegroup.add(TwoTimesRadio);
			scalegroup.add(OneRadio);
					
			//adds label and radio buttons (updated by avneet)
			ScalePanel.add(OneSixRadio);
			ScalePanel.add(TwoTimesRadio);
			ScalePanel.add(OneRadio);
		}
		
		public void BuildButtons()
		{
			ExitButton = new JButton("Exit");
			UpscaleButton = new JButton("Upscale");
			
			ExitButton.addActionListener(new ExitButtonListener());
			UpscaleButton.addActionListener(new UpscaleButtonListener());
			
			//create ButtonPanel
			ButtonPanel = new JPanel();
			ButtonPanel.setBackground(bgColor);
					
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
				CommandInput = Upscale.CommandLine(Noisecmd, Scalecmd, Filecmd); //call command to create command line argument    April 1 2017 Saito
				//Send CommandInput to be executed
			}
		}
		
		//UPLOAD BUTTON---------
		private class BrowseButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{	
				System.out.println("\nYou've pressed the 'Browse' Button");
				String textFieldValue = theText.getText(); //get text from textField
				System.out.print(textFieldValue); //Test that text field get inputs
				FindFile();
			}
		}
		
		
		
		//NOISE RADIO---------
		private class NoiseNoneRadioListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\nYou've selected the 'None' Button");
				Noisecmd = Upscale.NoiseNone(); //call command to create command line argument for noise none   April 1 2017 Saito
			}
		}
		private class NoiseLowRadioListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\nYou've selected the 'Low' Button");
				Noisecmd = Upscale.NoiseLow(); //call command to create command line argument for noise low   April 1 2017 Saito
			}
		}
		private class NoiseMediumRadioListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\nYou've selected the 'Medium' Button");
				Noisecmd = Upscale.NoiseMedium(); //call command to create command line argument for noise medium   April 1 2017 Saito
			}
		}
		private class NoiseHighRadioListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\nYou've selected the 'High' Button");
				Noisecmd = Upscale.NoiseHigh(); //call command to create command line argument for noise high   April 1 2017 Saito
			}
		}
		
		
		//MULTIPLIER RADIO---------
		private class OneRadioListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\nYou've selected the 'None' Button");
				Scalecmd = Upscale.ScaleNone(); //call command to create command line argument for scale none   April 1 2017 Saito
			}
		}
		private class OneSixRadioListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\nYou've selected the '2x' Button");
				Scalecmd = Upscale.Scale2x(); //call command to create command line argument for scale 2x   April 1 2017 Saito
			}
		}
		private class TwoTimesRadioListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\nYou've selected the '4x' Button");
				Scalecmd = Upscale.Scale4x(); //call command to create command line argument for scale 4x   April 1 2017 Saito
			}
		}
		
		
		//-------------------BUTTONS-END-------------------------
		
		// File Browsing (added by avneet)
		private void FindFile() {
			myBrowser = new JFileChooser();
			myBrowser.showOpenDialog(null);
			myBrowser.getSelectedFile().getAbsolutePath();
			path = myBrowser.getSelectedFile().getAbsolutePath();
			theText.setText("" + path);			
		}	
		
		
		
}
