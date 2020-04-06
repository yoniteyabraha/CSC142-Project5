public class GaussianFilter implements Filter {
	public void filter(PixelImage pi) {
		//A filter that makes every pixel blurry and thus creates a blurry image.
		int[][] c= {{1,2,1},{2,4,2},{1,2,1}};
		Pixel[][] transformed= pi.transformImage(c);
		
		pi.setData(transformed);
	}
}


