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
	private static String NoiseNone = " noise none";
	private static String NoiseLow = " low";
	private static String NoiseMedium = " medium";
	private static String NoiseHigh = " high";
	private static String ScaleNone = " scale none";
	private static String Scale2x = " 2x";
	private static String Scale4x = " 4x";
	private static String Cmd = "Waifu2x.exe";

	//-----Noise
	public static String NoiseNone()
	{
		return NoiseNone;
	}
	
	public static String NoiseLow()
	{
		return NoiseLow;
	}
	
	public static String NoiseMedium()
	{
		return NoiseMedium;
	}
	
	public static String NoiseHigh()
	{
		return NoiseHigh;
	}
	//-----Noise
	
	
	//-----Scale
	public static String ScaleNone()
	{
		return ScaleNone;
	}
	public static String Scale2x()
	{
		return Scale2x;
	}
	public static String Scale4x()
	{
		return Scale4x;
	}
	//-----Scale
	
	
	//Noise, File and Scale portion are added on from options and combine strings here to send to command to execute
	public static String CommandLine(String Noise, String Scale, String File)
	{
		CommandString = Cmd + Noise + Scale + File;
		
		return CommandString;
		
	}
	//-------Added by Saito April 1 2017
	
	
}
