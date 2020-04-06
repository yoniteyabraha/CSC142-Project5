public class BlackWhiteFilter implements Filter{
	public void filter(PixelImage pi)	{
	    Pixel [][] data = pi.getData();
	    //does black and white filter only based on the value of the average
	    for (int row = 0; row < pi.getHeight(); row++){
	      for (int col = 0; col < pi.getWidth(); col++){
	    	double average = (data[row][col].red + data[row][col].green + data[row][col].blue)/3.0;
	    	if (average < 100)
	    		average = 0;
	    	if (average > 100)
	    		average = 255;
	    	data[row][col].red = (int)average;
	    	data[row][col].green = (int) average;
	    	data[row][col].blue = (int) average;
	      }
	    }
	    pi.setData(data);
	}
}