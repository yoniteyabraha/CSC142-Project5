
public class NegativeFilter implements Filter{
	//A filter that changes every pixel into it's negative color configuration.
	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();
        //loop through every pixel
		for (int row = 0; row < pi.getHeight(); row++) {
			for (int col = 0; col < pi.getWidth(); col++) {
				//applying the negative filter for every pixel
				int red= 255-data[row][col].red;
				int green= 255-data[row][col].green;
				int blue= 255-data[row][col].blue;
				
				Pixel temp= new Pixel(red,green,blue);
				data[row][col]=temp;
			}
		}

		pi.setData(data);
	}

}
