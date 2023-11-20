package CommonUtil;

import java.util.Random;

public class JavaUtils {

	
	public int getRandomNUmber()
	{
		Random r = new Random();
		int rand=r.nextInt(10);
		return rand;

	}
}
