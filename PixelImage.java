import java.awt.image.*;

/**
 * Provides an interface to a picture as an array of Pixels
 */
public class PixelImage {
	private BufferedImage myImage;
	private int width;
	private int height;

	/**
	 * Map this PixelImage to a real image
	 * 
	 * @param bi The image
	 */
	public PixelImage(BufferedImage bi) {
		// initialise instance variables
		this.myImage = bi;
		this.width = bi.getWidth();
		this.height = bi.getHeight();
	}

	/**
	 * Return the width of the image
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Return the height of the image
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Return the BufferedImage of this PixelImage
	 */
	public BufferedImage getImage() {
		return this.myImage;
	}

	/**
	 * Return the image's pixel data as an array of Pixels. The first coordinate is
	 * the x-coordinate, so the size of the array is [width][height], where width
	 * and height are the dimensions of the array
	 * 
	 * @return The array of pixels
	 */
	public Pixel[][] getData() {
		Raster r = this.myImage.getRaster();
		Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
		int[] samples = new int[3];

		for (int row = 0; row < r.getHeight(); row++) {
			for (int col = 0; col < r.getWidth(); col++) {
				samples = r.getPixel(col, row, samples);
				Pixel newPixel = new Pixel(samples[0], samples[1], samples[2]);
				data[row][col] = newPixel;
			}
		}

		return data;
	}

	/**
	 * Set the image's pixel data from an array. This array matches that returned by
	 * getData(). It is an error to pass in an array that does not match the image's
	 * dimensions or that has pixels with invalid values (not 0-255)
	 * 
	 * @param data The array to pull from
	 */
	public void setData(Pixel[][] data) {
		int[] pixelValues = new int[3]; // a temporary array to hold r,g,b
										// values
		WritableRaster wr = this.myImage.getRaster();

		if (data.length != wr.getHeight()) {
			throw new IllegalArgumentException("Array size does not match");
		} else if (data[0].length != wr.getWidth()) {
			throw new IllegalArgumentException("Array size does not match");
		}

		for (int row = 0; row < wr.getHeight(); row++) {
			for (int col = 0; col < wr.getWidth(); col++) {
				pixelValues[0] = data[row][col].red;
				pixelValues[1] = data[row][col].green;
				pixelValues[2] = data[row][col].blue;
				wr.setPixel(col, row, pixelValues);
			}
		}
	}

	// compute the sum of all elements in a 2D integer array.
	public int matrixSum(int[][] intArray) {
		int sum = 0;
		for (int i = 0; i < intArray[0].length; i++) {
			for (int j = 0; j < intArray.length; j++) {
				sum += intArray[i][j];
			}
		}
		return sum;
	}

	// add a method to compute a new image given weighted averages
	/**
	 * Given an integer of 2D array it will return a transformed array of pixels
	 *
	 */
	public Pixel[][] transformImage(int[][] c) {
		Pixel[][] data = getData();
		Pixel[][] data2 = getData();

		int getSumOfMatrix = matrixSum(c); // get the sum of the transformation 2D array
		getSumOfMatrix = Math.max(1, getSumOfMatrix); // if the sum of the 2D array is 0 we get a sum of 1

		// loop through the pixels
		int firstOriginalPixel = (c.length - 1) / 2; // starting point
		// loop through the central pixels of the matrix
		for (int row = firstOriginalPixel; row < getHeight() - firstOriginalPixel; row++) {
			for (int col = firstOriginalPixel; col < getWidth() - firstOriginalPixel; col++) {
				// initialize the sum of the colors

				int redSum = 0, greenSum = 0, blueSum = 0;

				// loop through the neighboring pixels
				for (int i = 0, row1 = row - firstOriginalPixel; i < c.length; i++, row1++) {
					for (int j = 0, col1 = col - firstOriginalPixel; j < c.length; j++, col1++) {

						// find weighted sum
						redSum += c[i][j] * data[row1][col1].red;
						greenSum += c[i][j] * data[row1][col1].green;
						blueSum += c[i][j] * data[row1][col1].blue;
					}
				}

				// scale down the numbers to 0-255
				redSum /= getSumOfMatrix;
				greenSum /= getSumOfMatrix;
				blueSum /= getSumOfMatrix;

				// if the sum is greater than 255 get 255 or if the sum is negative get 0
				redSum = Math.min(255, Math.max(0, redSum));
				greenSum = Math.min(255, Math.max(0, greenSum));
				blueSum = Math.min(255, Math.max(0, blueSum));

				// now assign the transformed pixels
				data2[row][col].red = redSum;
				data2[row][col].green = greenSum;
				data2[row][col].blue = blueSum;

			}

		}
		return data2;

	}

}