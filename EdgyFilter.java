
public class EdgyFilter implements Filter {
	//edgy filter
	public void filter(PixelImage pi) {
		int[][] c= {{-1,-2,-1},{-2,28,-2},{-1,-2,-1}};
		Pixel[][] transformed = pi.transformImage(c);
		
		pi.setData(transformed);
	}
}
