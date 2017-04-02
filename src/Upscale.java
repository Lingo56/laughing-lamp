/**
 * Created by theli on 3/28/2017.
 */
public class Upscale
{
		//Saito April 1 2017
	//Unsure if this is stuff needed for program application
	//Need Methods to input all different options into Command?
	//Method to print text into command that enable option but upscale button is what executes?
	//method to store all strings until upload button sends?
	//If this is even the right place for this kind of stuff
	
	private static String CommandString;
	private static String NoiseNone = " -noise_level 0";
	private static String NoiseLow = " -noise_level 1";
	private static String NoiseMedium = " -noise_level 2";
	private static String NoiseHigh = " -noise_level 3";
	private static String ScaleNone = " -m noise";
	private static String Scale2x = " -m scale";
	private static String Scale4x = " -m scale";
	private static String Cmd = "Waifu2x.exe";
	//APRIL 2  ------- changed strings to cmd commands from waifu2x github

	//-----Noise
	public static String SetNoiseNone()
	{
		return NoiseNone;
	}
	
	public static String SetNoiseLow()
	{
		return NoiseLow;
	}
	
	public static String SetNoiseMedium()
	{
		return NoiseMedium;
	}
	
	public static String SetNoiseHigh()
	{
		return NoiseHigh;
	}
	//-----Noise
	
	
	//-----Scale
	public static String SetScaleNone()
	{
		return ScaleNone;
	}
	public static String SetScale2x()
	{
		return Scale2x;
	}
	public static String SetScale4x()
	{
		return Scale4x;
	}
	//-----Scale
	
	
	//Noise, File and Scale portion are added on from options and combine strings here to send to command to execute
	public static String CommandLine(String Noise, String Scale, String FileIN, String INName, String FileOut, String OUTName)
	{
		CommandString = Cmd + Noise + Scale + FileIN + INName + FileOut + OUTName; //added File input and output name  April 2
		
		return CommandString;
		
	}
	//-------Added by Saito April 1 2017
	
	
}
