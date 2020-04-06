
public class LaplacianFilter implements Filter {
	//This transformation detects and highlights edges.
	public void filter(PixelImage pi) {
		int[][] c= {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
		Pixel[][] transformed = pi.transformImage(c);
		
		pi.setData(transformed);
	}
}
