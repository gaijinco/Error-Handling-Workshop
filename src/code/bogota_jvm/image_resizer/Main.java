package code.bogota_jvm.image_resizer;

import java.nio.file.Path;
import java.nio.file.Paths;

import code.bogota_jvm.image_resizer.resizer.ImageResizer;

public class Main {

	public static void main(String[] args) {
		Path source = Paths.get("");
		Path destination = Paths.get("");
		int width = 0;
		int height = 0;
		ImageResizer resizer = new ImageResizer.Builder(source, destination)
											   .withWidth(width)
											   .withHeight(height)
											   .build();
		resizer.run();
	}

}
