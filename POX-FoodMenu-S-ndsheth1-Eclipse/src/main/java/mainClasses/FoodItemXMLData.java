package mainClasses;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class FoodItemXMLData {
	
	String path = "C:\\Windows\\Temp\\FoodItemData.xml";
	
	public String createFoodItem(FoodItemDetail fid)
	{
		
		File file = new File(path);
		
		//the following code was to let the program use resource folder, but as mentioned in the read me, server had the lock.
		//ClassLoader classLoader = getClass().getClassLoader();
		/*try {
			file = new File(path);//this.getClass().getResource("/FoodItemData.xml").toURI());
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}*/
		
		String outputID=null;
		boolean flag = false;
		try {
		if (file.exists()) {

            InputSource readSource = new InputSource(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            readSource.setEncoding("UTF-8");
            
			DocumentBuilderFactory builderFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFac.newDocumentBuilder();
			Document d = builder.parse(readSource);
			
			NodeList allNodes = d.getElementsByTagName("FoodItem");

			for (int i = 0; i < allNodes.getLength(); i++) 
			{
				Element eachElement = (Element) allNodes.item(i);
				String cat = eachElement.getElementsByTagName("category").item(0).getTextContent();
				String name = eachElement.getElementsByTagName("name").item(0).getTextContent();
				if (fid.getItem_category().equals(cat) && fid.getItem_name().equals(name)) 
				{
					outputID=eachElement.getElementsByTagName("id").item(0).getTextContent();
					flag = true;
					break;
				}
			}
			if (flag)
			{
				return outputID;
			}
				
			else {
				Element eachElement = d.createElement("FoodItem");
				eachElement.setAttribute("country", fid.getItem_country());
				
				//setting the ID of new Element
				Element ele_id = d.createElement("id");
				ele_id.setTextContent(String.valueOf(fid.getItem_ID()));
				
				//category
				Element ele_cat = d.createElement("category");
				ele_cat.setTextContent(fid.getItem_category());
				
				//name
				Element ele_name = d.createElement("name");
                ele_name.setTextContent(fid.getItem_name());
				
                //desecription
				Element ele_desc= d.createElement("description");
				ele_desc.setTextContent(fid.getItem_desc());
				//
				Element ele_price = d.createElement("price");
				ele_price.setTextContent(fid.getItem_price());
				
				//appending all the elements
				eachElement.appendChild(ele_id);
				eachElement.appendChild(ele_name);
				eachElement.appendChild(ele_desc);
				eachElement.appendChild(ele_cat);
				eachElement.appendChild(ele_price);
				
				Element rootTag=(Element) d.getElementsByTagName("FoodItemData").item(0);
				rootTag.appendChild(eachElement);
				//saving the data to file
				Transformer xform = TransformerFactory.newInstance().newTransformer();
			    Result output=new StreamResult(new File(path));
			    Source input=new DOMSource(d);
			    xform.transform(input, output);
			return "true";
			}
		}

	} catch (Exception e) {
		e.printStackTrace();
		return "false";
	}
	return null;
}
	
	
	public String getFoodItem(FoodItemUtility.selectedFoodItem selectedID) throws Exception
	{
		File file = new File(path);
		InputSource readSource = new InputSource(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		readSource.setEncoding("UTF-8");
		
		DocumentBuilderFactory builderFac = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFac.newDocumentBuilder();
		Document d = builder.parse(readSource);
		
		NodeList allNodes = d.getElementsByTagName("FoodItem");

		for (int i = 0; i < allNodes.getLength(); i++) {
			Element eachElement = (Element) allNodes.item(i);
			String item_id = eachElement.getElementsByTagName("id").item(0).getTextContent();
			
			if (selectedID.getFoodItemId() == Integer.parseInt(item_id))
			{
				System.out.println("found");
				String item_name = eachElement.getElementsByTagName("name").item(0).getTextContent();
				String item_category = eachElement.getElementsByTagName("category").item(0).getTextContent();
				String item_desc = eachElement.getElementsByTagName("description").item(0).getTextContent();
				String item_price = eachElement.getElementsByTagName("price").item(0).getTextContent();
				String item_country = eachElement.getAttribute("country");
				return selectedID.getFoodItemId()+"-"+item_name+"-"+item_category+"-"+item_desc+"-"+item_price+"-"+item_country;
			}
		}	
		return "-1";
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		/*
			FoodItemDetail fid = new FoodItemDetail();
			fid.setItem_category("asdf");
			fid.setItem_country("gdb3");
			fid.setItem_desc("4desc3");
			fid.setItem_ID(84);
			fid.setItem_name("Elementasdf");
			fid.setItem_price("psfrice");
			
			FoodItemXMLData fixd = new FoodItemXMLData();
			System.out.println(fixd.createFoodItem(fid));		
		*/
		/*FoodItemXMLData f = new FoodItemXMLData();
		f.getFoodItem(52);*/
		
		
	}
	
}
