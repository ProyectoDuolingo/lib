package lib.duolingoproject.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shop_item")
public class ShopItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "shop_itemname", unique = true)
	private String shopItemName;
	
	@Column(name = "price")
	private int price;
	
	public ShopItem(String shopItemName, int price) {
		
		this.shopItemName = shopItemName;
		this.price = price;
		
	}
	
}
