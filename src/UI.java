import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		private String path = "";
		
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
	    }
	    
	    public void BuildTitlePanel() // (updated by avneet)
		{
			TitleLabel = new JLabel("Welcome to Waifu2X!");
			
			TitleLabel.setFont(displayFont);
			
			//create TitlePanel
			TitlePanel = new JPanel();
			
			//add labels to the panel
			TitlePanel.add(TitleLabel);		
		}
		
		public void BuildInstructionPanel()
		{
			InstructionLabel = new JLabel("Choose File");
			
			//create TitlePanel
			InstructionPanel = new JPanel();
			
			//add labels to the panel
			InstructionPanel.add(InstructionLabel);
		}
		
		public void BuildBrowsePanel()// (updated by avneet)
		{	
			BrowsePanel = new JPanel();
			BrowsePanel.setBackground(Color.red);
			theText = new JTextField(30);
			theText.setBackground(Color.white);
			BrowseButton = new JButton("Browse");
			theText.setText("" + path);
			
			BrowseButton.addActionListener(new BrowseButtonListener());
			
			//create BrowsePanel (updated by avneet)
			BrowsePanel = new JPanel();
			BrowsePanel.add(theText);
			BrowsePanel.add(BrowseButton);
		}
		
		
		public void BuildNoisePanel()
		{
			JLabel RadioLabel = new JLabel("Select noise reduction: ");
			NoiseNoneRadio = new JRadioButton("None");
			NoiseLowRadio = new JRadioButton("Low");
			NoiseMediumRadio = new JRadioButton("Medium");
			NoiseHighRadio = new JRadioButton("High");
			
			NoiseLowRadio.addActionListener(new NoiseLowRadioListener());
			NoiseMediumRadio.addActionListener(new NoiseMediumRadioListener());
			NoiseHighRadio.addActionListener(new NoiseHighRadioListener());
			NoiseNoneRadio.addActionListener(new NoiseNoneRadioListener());
			
			//create ButtonPanel
			NoisePanel = new JPanel();
			
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
			scalegroup.add(OneSixRadio);
			scalegroup.add(TwoTimesRadio);
			scalegroup.add(OneRadio);
					
			//adds label and radio buttons
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
