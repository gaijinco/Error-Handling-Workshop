package code.bogota_jvm.image_resizer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import code.bogota_jvm.image_resizer.resizer.ImageResizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Path source = Paths.get("C:/Clean Coder/Error Handling Workshop");
		Path destination = Paths.get("C:/Clean Coder/Error Handling Workshop/small");
		int width = 640;
		int height = 480;
		ImageResizer resizer = new ImageResizer.Builder(source, destination)
											   .withWidth(width)
											   .withHeight(height)
											   .build();
		resizer.run();
	}

}
