public class RemoveRedFilter implements Filter{
public void filter(PixelImage pi)	{
	//removes the red filter
	    Pixel [][] data = pi.getData();
	    for (int row = 0; row < pi.getHeight(); row++){
	      for (int col = 0; col < pi.getWidth(); col++){
	    	  data[row][col].red = 0;
	      }
	    }
	    pi.setData(data);
	}
}