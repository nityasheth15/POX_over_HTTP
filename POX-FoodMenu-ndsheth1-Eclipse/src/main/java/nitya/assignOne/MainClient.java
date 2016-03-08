package nitya.assignOne;


import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class MainClient {
	private WebResource webResource;
	private Client client;
	private static final String BASE_URI = "http://localhost:8080/POX-FoodMenu-S-ndsheth1-Eclipse/FoodItemSrvcImpl";

	public MainClient() {
		ClientConfig config = new DefaultClientConfig();
		client = Client.create(config);
	}
	
	public void addFoodItem(FoodItemDetail fi) throws JAXBException {
		webResource = client.resource(BASE_URI).path("createFoodItem");
		ClientResponse response = webResource.type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML)
				.post(ClientResponse.class, fi);
		
		if (response.getStatus() == 200) {
			FoodItemUtility.checkFoodItem exists = response.getEntity(FoodItemUtility.checkFoodItem.class);
			JAXBContext context = JAXBContext.newInstance(FoodItemUtility.checkFoodItem.class);

			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(exists, System.out);
			
		} else if (response.getStatus() == 201) {
			FoodItemUtility.createFoodItem added = response.getEntity(FoodItemUtility.createFoodItem.class);
			JAXBContext context = JAXBContext.newInstance(FoodItemUtility.createFoodItem.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(added, System.out);
		}
		else
		{
			System.out.println("<Invalid ---addFoodItem <- MainClient");
		}
	}
	
	
	public void getFoodItem(FoodItemUtility.selectedFoodItem[] selectedID) throws JAXBException
	{
		webResource = client.resource(BASE_URI).path("getFoodItem");
		for(int i=0; i<selectedID.length;i++)
		{
			try
			{
				ClientResponse response = webResource.type(MediaType.APPLICATION_XML)
						.accept(MediaType.APPLICATION_XML)
						.post(ClientResponse.class, selectedID[i]);
				if(response.getStatus() == 200)
				{
					FoodItemUtility.retrievedFoodItem rfi = response.getEntity(FoodItemUtility.retrievedFoodItem.class);
					JAXBContext context = JAXBContext.newInstance(FoodItemUtility.retrievedFoodItem.class);
					Marshaller m = context.createMarshaller();
					m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					m.marshal(rfi, System.out);
				}
				else
				{
					System.out.println("<InvalidMessage>");
				}
			}
			catch(Exception e)
			{
				System.out.println("<InvalidMessage>");
			}
		}
	}

}
