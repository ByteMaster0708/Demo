package CommonUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutils {

	public  String getdatafrompropertyfiles(String Key) throws IOException
	{
		FileInputStream file=new FileInputStream("src\\test\\resources\\localhost.properties");
		Properties p=new Properties();
		p.load(file);
	    String value=p.getProperty(Key);
	    return value;

	}

}

