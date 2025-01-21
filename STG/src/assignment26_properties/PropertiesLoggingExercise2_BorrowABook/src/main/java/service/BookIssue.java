package service;

import java.util.Iterator;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sujal.exception.AcademyException;

public class BookIssue {
	public static Log LOGGER = LogFactory.getLog(BookIssue.class);
	public void bookDetails(String bookName) throws AcademyException, ConfigurationException{
		//Write your code here
		
		Configurations configurations = new Configurations();
		PropertiesConfiguration propertiesConfiguration;
		propertiesConfiguration = configurations.properties("src/main/resources/configuration.properties");
		Iterator<String> str = propertiesConfiguration.getKeys();
		String keyKey = null;
		while(str.hasNext()) {
			String val = str.next();
			if(propertiesConfiguration.getProperty(val).equals(bookName)){
				keyKey = val;
				break;
			}
		}
		String book = (String)propertiesConfiguration.getProperty(keyKey);
		System.out.println(book);
		if(book == null){
			LOGGER.error(propertiesConfiguration.getString("INVALID_BOOKNAME"));
			throw new AcademyException(propertiesConfiguration.getString("INVALID_BOOKNAME"));
		}
		else{
			String valKey = keyKey.substring(0, 3)+"VALUE";
			int val = propertiesConfiguration.getInt(valKey);
			if(val == 0){
				LOGGER.error(propertiesConfiguration.getString("BOOK_UNAVAILABLE"));
				throw new AcademyException(propertiesConfiguration.getString("BOOK_UNAVAILABLE"));
			}
			else{
				LOGGER.info(propertiesConfiguration.getString("BOOK_AVAILABLE")+" "+book);
			}
		}
	}

}
