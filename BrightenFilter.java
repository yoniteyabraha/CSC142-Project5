public class BrightenFilter implements Filter{
public void filter(PixelImage pi)	{
	//brightens the image
	    Pixel [][] data = pi.getData();
	    for (int row = 0; row < pi.getHeight(); row++){
	      for (int col = 0; col < pi.getWidth(); col++){
		        data[row][col].red += 60;
		        data[row][col].green += 60;
		        data[row][col].blue += 60;

		        data[row][col].red = Math.min(data[row][col].red, 255);
		        data[row][col].green = Math.min(data[row][col].green, 255);
		        data[row][col].blue = Math.min(data[row][col].blue, 255);
	      }
	    }
	    pi.setData(data);
	}
}