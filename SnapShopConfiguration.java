// Write your short report here (-2 if there is no report)
/**I submitted 5 additional filters namely: shiftLeftFilter, BalckWhiteFilter, BrightensFilter, DarkensFilter, RemoveGreenFilter,RemoveRedFilter, 
 * RemoveBlueFilter out of which the DarkensFilter didn't give me the output I was expecting. It does the same filter as  the BrightensFilter does. 
 * But the other filters transform the image as expected. 
 * I had hard time figuring out the central pixels of the image(looping through each of them). Since I wasn't getting it right, I would get the transformation
 * on some part of the image but not the whole image. Also when I didn't scale down some of the filters they would create a completely different
 * transformation.
 * 
 */

/**
 * A class to configure the SnapShop application
 * 
 * @author (Yonas Abraha)
 * @version (03/17/2020)
 */
public class SnapShopConfiguration {
	/**
	 * Method to configure the SnapShop. Call methods like addFilter and
	 * setDefaultFilename here.
	 * 
	 * @param theShop
	 *            A pointer to the application
	 */
	public static void configure(SnapShop theShop) {

		theShop.setDefaultFilename("billg.jpg");
		theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
		// add your other filters below
		theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
		theShop.addFilter(new NegativeFilter(), "Negative");
		theShop.addFilter(new GaussianFilter(), "Gaussian blur");
		theShop.addFilter(new LaplacianFilter(), "Laplacian");
		theShop.addFilter(new UnsharpMaskingFilter(), "Unsharp masking");
		theShop.addFilter(new EdgyFilter(), "Edgy");
		theShop.addFilter(new ShiftLeftFilter(), "Shift left");
		theShop.addFilter(new BlackWhiteFilter(),"Black & White");
		theShop.addFilter(new BrightenFilter(),"Brightens");
		theShop.addFilter(new BrightenFilter(),"Darkens");
		theShop.addFilter(new RemoveGreenFilter(), "Remove Green Filter");
		theShop.addFilter(new RemoveRedFilter(), "Remove Red Filter");
		theShop.addFilter(new RemoveBlueFilter(), "Remove Blue Filter");
		
	}
}