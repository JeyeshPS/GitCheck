package utlities;

public class BackgroudColor 
{
	public static String convertRGBAtohex(String rgba)
	{
		String[] values = rgba.replace("rgba(", "").replace(")", "").split(",");
	    int r = Integer.parseInt(values[0].trim());
	    int g = Integer.parseInt(values[1].trim());
	    int b = Integer.parseInt(values[2].trim());
	    return String.format("#%02x%02x%02x", r, g, b);
	}
}
