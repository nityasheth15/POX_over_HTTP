package service;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mainClasses.FoodItemDetail;
import mainClasses.FoodItemUtility;
import mainClasses.FoodItemXMLData;

@Path("/FoodItemSrvcImpl")
public class FoodItemSrvcImpl {
	
	@POST
	@Path("/createFoodItem")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response createFoodItem(FoodItemDetail fid) {
		try{
			FoodItemXMLData fixd = new FoodItemXMLData();
			if (fid != null) {
				
				String output = fixd.createFoodItem(fid);
				if (output.equals("true")) 
				{
					FoodItemUtility.createFoodItem crfi = new FoodItemUtility.createFoodItem();
					crfi.setFoodItemId(fid.getItem_ID());
					return Response.status(201).entity(crfi).build();
					//used 201 to differentiate the created XML element and already existing element. 
				} 
				else if (!output.equals("false") && output != null) 
				{
					FoodItemUtility.checkFoodItem cfi = new FoodItemUtility.checkFoodItem();
					cfi.setFoodItemId(Integer.parseInt(output));
					return Response.status(200).entity(cfi).build();
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("<InvalidMessage> -- FoodItemSrvcImpl");
		}
		return null;
	}
	
	
	@POST
	@Path("/getFoodItem")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Response getFoodItem(FoodItemUtility.selectedFoodItem selectedFoodItemID) throws Exception
	{
		FoodItemXMLData fixd = new FoodItemXMLData();
		String result = fixd.getFoodItem(selectedFoodItemID);
		System.out.println("Result:" + result);
		FoodItemUtility.retrievedFoodItem rfi = new FoodItemUtility.retrievedFoodItem();
		if(!result.equals("-1"))
		{
			try{
				String[] foundFoodItem = result.split("-");
				System.out.println(foundFoodItem);
				
				rfi.setFoodItemId(Integer.parseInt(foundFoodItem[0]));
				rfi.setItem_name(foundFoodItem[1]);
				rfi.setItem_category(foundFoodItem[2]);
				rfi.setItem_desc(foundFoodItem[3]);
				rfi.setItem_price(foundFoodItem[4]);
				rfi.setItem_country(foundFoodItem[5]);
				return Response.status(200).entity(rfi).build();
			}
			catch(Exception e)
			{
				return Response.status(404).entity(rfi).build();
			}
		}
		else
		{
			return Response.status(404).entity(rfi).build();
		}
	}
}
