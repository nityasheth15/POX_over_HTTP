package mainClasses;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "FoodItem")
public class FoodItemDetail{
	
	private int item_ID;
	private String item_name;
	private String item_desc;
	private String item_category;
	private String item_price;
	private String item_country;
	
	
	
	@XmlElement(name="ID")
	public void setItem_ID(int ID)
	{
		this.item_ID = ID;
	}
	public int getItem_ID()
	{
		return this.item_ID;
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
	
	@Override
	public String toString() {
		return "FoodItemDetail [item_ID=" + item_ID + ", item_name=" + item_name + ", item_desc=" + item_desc
				+ ", item_category=" + item_category + ", item_price=" + item_price + ", item_country=" + item_country
				+ "]";
	}
	
	
	
	
}
