package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {


	public Properties getPropertyFileValue(String fileName) throws IOException {
		Properties ssProp = new Properties();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		ssProp.load(inputStream);
		return ssProp;
	}
}
