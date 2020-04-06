public class RemoveBlueFilter implements Filter{
public void filter(PixelImage pi)	{
	//removes blue filter
	    Pixel [][] data = pi.getData();
	    for (int row = 0; row < pi.getHeight(); row++){
	      for (int col = 0; col < pi.getWidth(); col++){
	    	  data[row][col].blue = 0;
	      }
	    }
	    pi.setData(data);
	}
}