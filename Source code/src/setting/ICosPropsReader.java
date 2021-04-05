package setting;

import java.util.Properties;

import bca.util.common.jdomWrapper;

public class ICosPropsReader {
	
	// source dari icos, modified by NXN cuma untuk test doang
  public static org.jdom.Document CONFIG_DOM_DOC = new org.jdom.Document();
  public static Properties BCA_ICOS_MSG_PROPS = new Properties();

  
  public synchronized static String readMsgProperties(String propsKey)
  {
	  String propsValue = BCA_ICOS_MSG_PROPS.getProperty(propsKey);
	  return propsValue;
  }

  private synchronized static void loadConfigurationDOMDocument()
  {
	  try
	  {
		  CONFIG_DOM_DOC = jdomWrapper.createDOMDoc("/mnt/singleconfig/icossme-config.xml");
		  System.out.println("**** AUTO LOAD AWAL *****");
		  System.out.println(jdomWrapper.getXMLContentValue(CONFIG_DOM_DOC, "/config/icossme/etc/message.properties.path"));
//		  FileInputStream in = new FileInputStream(jdomWrapper.getXMLContentValue(CONFIG_DOM_DOC, "/config/icossme/etc/message.properties.path"));
//		  Properties prp = new Properties();
//		  prp.load(in);
//		  BCA_ICOS_MSG_PROPS = prp;
//		  in.close();
		  //BCA_ICOS_MSG_PROPS = PropsReader.loadProps(jdomWrapper.getXMLContentValue(CONFIG_DOM_DOC, "/config/icossme/etc/message.properties.path"));
	  }catch(Exception ex){
		  ex.printStackTrace();
	  }
  }
  
  public synchronized static void initAppConfig()
  {
		  ICosPropsReader.loadConfigurationDOMDocument();
  }
}
