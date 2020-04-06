public class DarkensFilter implements Filter{
public void filter(PixelImage pi)	{
	    Pixel [][] data = pi.getData();
        //darkens the image(failed!)
	    for (int row = 0; row < pi.getHeight(); row++){
	      for (int col = 0; col < pi.getWidth(); col++){
		        data[row][col].red -= 60;
		        data[row][col].green -= 60;
		        data[row][col].blue -= 60;

		        data[row][col].red = Math.max(data[row][col].red, 0);
		        data[row][col].green = Math.max(data[row][col].green, 0);
		        data[row][col].blue = Math.max(data[row][col].blue, 0);
	      }
	    }
	    pi.setData(data);
	}
}