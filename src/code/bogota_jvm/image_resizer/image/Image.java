package code.bogota_jvm.image_resizer.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import javax.imageio.ImageIO;

/**
 * Represents an image from the filesystem.
 *
 */
public class Image {

	private final BufferedImage image;
	private final Path filename;

	/**
	 * Tries to create an Image from the given path.
	 * 
	 * @param path
	 * @return an Optional<Image>
	 */
	public static Optional<Image> read(Path path) {
		try {
			BufferedImage image = ImageIO.read(path.toFile());
			return Optional.of(new Image(image, path.getFileName()));
		} catch (IOException e) {
			return Optional.empty();
		}
	}

	private Image(BufferedImage image, Path filename) {
		this.image = image;
		this.filename = filename;
	}

	/**
	 * 
	 * @return
	 */
	public int getHeight() {
		return image.getHeight();
	}

	/**
	 * 
	 * @return
	 */
	public int getWidth() {
		return image.getWidth();
	}

	/**
	 * Checks if this image is proportional to a given size.
	 * 
	 * This is not an appropriate implementation for real uses.
	 * 
	 * This is useful so that you can call resize method and be sure you get
	 * useful results. Call it always before calling resize() and only code it
	 * if this method returned true.
	 * @param width
	 * @param height
	 * @return true if the image is proportional to the given size, false otherwise.
	 */
	public boolean isProportional(int width, int height) {
		return width * getHeight() == height * getWidth();
	}

	/**
	 * Resizes the image to the given size.
	 * 
	 * The algorithm is based on {@link http://www.mkyong.com/java/how-to-resize-an-image-in-java/} 
	 * which surely is not state-of-the-art.
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	public Image resize(int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height,
				image.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();
		return new Image(resizedImage, filename);
	}

	/**
	 * Creates an image in the given location with the information of the object.
	 * 
	 * The name of the file would be the exact same name that had when it was read.
	 * @param destination
	 * @throws IOException if there's an error writing the image.
	 */
	public void write(Path destination) throws IOException {
		Path path = destination.resolve(filename);
		ImageIO.write(image, Images.getExtension(filename), path.toFile());
	}
}
