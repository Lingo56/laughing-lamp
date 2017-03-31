import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Util {
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

}
