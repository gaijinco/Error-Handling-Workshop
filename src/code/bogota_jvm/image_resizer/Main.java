package code.bogota_jvm.image_resizer;

import java.io.IOException;

import code.bogota_jvm.image_resizer.config.ConfigReader;
import code.bogota_jvm.image_resizer.resizer.ImageResizer;

public class Main {

	public static void main(String[] args) throws IOException {
		ConfigReader reader = new ConfigReader();
		ImageResizer resizer = new ImageResizer.Builder(reader.getSource(), reader.getDestination())
											   .withWidth(reader.getWidth())
											   .withHeight(reader.getHeight())
											   .build();
		resizer.run();
	}

}
