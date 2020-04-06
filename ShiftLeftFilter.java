public class ShiftLeftFilter implements Filter
{
	public void filter(PixelImage pi)	{
		//shifts the image to the left
		int c [][] = {{0, 0, 0}, {0, 0, 1}, {0, 0, 0}};
		Pixel [][] transformed = pi.transformImage(c);
		pi.setData(transformed);
	}
}