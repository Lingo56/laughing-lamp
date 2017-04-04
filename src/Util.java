import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Util {

	// Upscale Variables
	private int scaleAmount;
	private int denoiseAmount;
	private String imagePath;

	public static BufferedImage loadImage(String fileName) {
		BufferedImage bufImg = null;
		try {
			bufImg = ImageIO.read(new File(fileName));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return bufImg;
	}


	// SETTERS

	// Set Scale Amount
	public void setScale(int scale){
		this.scaleAmount = scale;
	}

	// Set De-Noise Amount
	public void setDeNoise(int denoise){
		this.denoiseAmount = denoise;
	}

	// Set the path to the image
	public void setImagePath(String path) {
		this.imagePath = path;
		System.out.println(imagePath);
	}

	// GETTERS

	public int getScale(){
		return this.scaleAmount;
	}

	public int getDeNoise(){
		return this.denoiseAmount;
	}

	public String getImagePath(){
		System.out.println(imagePath);

		return this.imagePath;
	}
}
