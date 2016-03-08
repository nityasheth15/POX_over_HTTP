import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import nitya.assignOne.FoodItemDetail;
import nitya.assignOne.FoodItemUtility;
import nitya.assignOne.MainClient;


public class FoodItemApp 
{
    public static void main( String[] args )
    {
    	 try{
    		 
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		Scanner input = new Scanner(System.in);
	    	int choice = -1;
	    	
	    	System.out.println("Please choose following choice: ");
    		System.out.println("1. Add XML Element. ");
    		System.out.println("2. Find XML Element. ");
    		
	    	while(choice != 1 && choice !=2)
	    	{
	    		choice = -1;
	    		try
	    		{
		    		choice = Integer.parseInt(br.readLine());
		    		if(choice != 1 && choice != 2)
		    		{
		    			System.err.println("Invalid Choice");
		    		}
	    		}
	    		catch(NumberFormatException e)
	    		{
	    			System.err.println("Please enter 1 or 2 only");
	    		}	    		
	    	}
	    	
	    	if(choice == 1)
	    	{
	    	    System.out.println("Enter the food item details you want to add: ");
		        
		        System.out.println("What is the name of item? ");
		        String item_name = input.nextLine();
		        
		        System.out.println("Which country is it found in? [Country Initials]");
		        String item_country = input.nextLine();
		        System.out.println("Describe your item: ");
		        String item_desc = input.nextLine();
		        System.out.println("Tell me the category of your item: ");
		        String item_category = input.nextLine();
		        System.out.println("How much should one pay to taste it?");
		        String item_price = input.nextLine();
		        
		        Random r = new Random();
		        
		        FoodItemDetail fid = null;
		        if(item_name != null && !item_name.trim().equals("")
		        && item_country != null && !item_country.trim().equals("")
				&& item_desc != null && !item_desc.trim().equals("")
				&& item_category != null && !item_category.trim().equals("")
		        && item_price != null && !item_price.trim().equals(""))
		        {
		        	fid = new FoodItemDetail();
		        	fid.setItem_name(item_name);
		        	fid.setItem_country(item_country);
		        	fid.setItem_desc(item_desc);
		        	fid.setItem_category(item_category);
		        	fid.setItem_price(item_price);
		        	fid.setItem_ID(r.nextInt(1000));
		        }
		        else
		        {
		        	System.err.println("Please re reun the program");
		        	System.exit(0);
		        }
		        
	        	MainClient foodItemClient=new MainClient();
		    	foodItemClient.addFoodItem(fid);
		    	System.exit(0);
		    	input.close();
	    	}
	    	else if(choice == 2)
	    	{
	    		System.out.println("Please enter element IDs you wish to search: (Please note that you are required to put IDs space separated)");
	    		String elementIDs = input.nextLine();
	    		String[] splitSelectedIDs = elementIDs.split(" ");
	    		
	    		FoodItemUtility.selectedFoodItem[] selectedIDs = new FoodItemUtility.selectedFoodItem[splitSelectedIDs.length];
	    		for(int i=0; i<splitSelectedIDs.length; i++)
	    		{
	    			FoodItemUtility.selectedFoodItem selectedID = new FoodItemUtility.selectedFoodItem();
		    		selectedID.setFoodItemId(Integer.parseInt(splitSelectedIDs[i]));
		    		selectedIDs[i] = selectedID;
	    		}
	    		
	    		//FoodItemUtility.selectedFoodItem selectedID = new FoodItemUtility.selectedFoodItem();
	    		//selectedID.setFoodItemId(elementID);
	    		MainClient foodItemClient=new MainClient();
	    		foodItemClient.getFoodItem(selectedIDs);
	    	}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    	System.out.println("Exception");
	    }
	   }
        
        
        
    }
   