package nitya.assignOne;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class FoodItemUtility {
	
	@XmlRootElement(name="CreateFoodItem")
	public static class createFoodItem{
		
		private int foodItemId;
	
		public int getFoodItemId() {
			return foodItemId;
		}
	
		@XmlElement(name="itemId")
		public void setFoodItemId(int foodItemId) {
			this.foodItemId = foodItemId;
		}
	}
	
	@XmlRootElement(name="checkFoodItem")
	public static class checkFoodItem
	{
	
		private int foodItemId;
	
		public int getFoodItemId() {
			return foodItemId;
		}
	
		@XmlElement(name="itemId")
		public void setFoodItemId(int foodItemId) {
			this.foodItemId = foodItemId;
		}
	}
	
	@XmlRootElement(name="RetrievedFoodItem")
	public static class retrievedFoodItem
	{
		private String item_name;
		private String item_desc;
		private String item_category;
		private String item_price;
		private String item_country;
		private int foodItemId;
		
		@XmlElement(name="id")
		public void setFoodItemId(int foodItemId) {
			this.foodItemId = foodItemId;
		}
		public int getFoodItemId() {
			return foodItemId;
		}
		
		@XmlElement(name="name")
		public void setItem_name(String name)
		{
			this.item_name = name;
		}
		public String getItem_name()
		{
			return this.item_name;
		}
		
		@XmlElement(name="description")
		public void setItem_desc(String desc)
		{
			this.item_desc = desc;
		}
		public String getItem_desc()
		{
			return this.item_desc;
		}
		
		@XmlElement(name="category")
		public void setItem_category(String category)
		{
			this.item_category = category;
		}
		
		public String getItem_category()
		{
			return this.item_category;
		}
		
		@XmlElement(name="price")
		public void setItem_price(String price)
		{
			this.item_price = price;
		}
		public String getItem_price()
		{
			return this.item_price;
		}
		
		@XmlAttribute(name="country")
		public void setItem_country(String country)
		{
			this.item_country = country;
		}
		public String getItem_country()
		{
			return this.item_country;
		}
	}
	
	@XmlRootElement(name="selectedFoodItem")
	public static class selectedFoodItem
	{
		private int foodItemId;
		public int getFoodItemId() {
			return foodItemId;
		}
	
		@XmlElement(name="FoodItemId")
		public void setFoodItemId(int foodItemId) {
			this.foodItemId = foodItemId;
		}
	}
}
