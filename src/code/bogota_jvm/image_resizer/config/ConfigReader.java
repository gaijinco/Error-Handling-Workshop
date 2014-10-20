package code.bogota_jvm.image_resizer.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * This class reads a config.properties files to be used with ImageResizer.
 *
 */
public class ConfigReader {

	private final Path source;
	private final Path destination;
	private final int width;
	private final int height;

	/**
	 * Loads the parameters from a config.properties files.
	 * 
	 * The config file should have 4 parameters: source, destination, width and height (with those names)
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public ConfigReader() throws FileNotFoundException, IOException {
		try (FileInputStream inputStream = new FileInputStream("config.properties")) {
			Properties properties = new Properties();
			properties.load(inputStream);
			source = Paths.get(properties.getProperty("source"));
			destination = Paths.get(properties.getProperty("destination"));
			width = Integer.parseInt(properties.getProperty("width"));
			height = Integer.parseInt(properties.getProperty("height"));
		}
	}

	/**
	 * 
	 * @return
	 */
	public Path getSource() {
		return source;
	}

	/**
	 * 
	 * @return
	 */
	public Path getDestination() {
		return destination;
	}

	/**
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @return
	 */
	public int getHeight() {
		return height;
	}
}
