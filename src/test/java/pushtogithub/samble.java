package pushtogithub;

import org.testng.annotations.Test;

import com.crm.comcast.genericUtility.FileUtility;

public class samble {
	
	@Test
	public void Testsamble() throws Throwable {
		FileUtility f=new FileUtility();
	String data = f.getPropertyKeyValue("browser");
	System.out.println(data);
	}

}
