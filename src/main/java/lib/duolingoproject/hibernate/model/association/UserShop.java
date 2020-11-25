package lib.duolingoproject.hibernate.model.association;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lib.duolingoproject.hibernate.model.ShopItem;
import lib.duolingoproject.hibernate.model.User;

@Entity
@Table(name = "user_shop")
public class UserShop { // Usamos esta clase para poder agregar columnas extras a una relacion "ManyToMany", como en este caso el boolean para saber si ha comprado el item.
	
	@EmbeddedId
	private UserShopId id = new UserShopId();

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "item_id")
	private ShopItem item;
	
	@Column(name = "is_bought")
	private boolean isBought;
	
	
	@Embeddable
	public class UserShopId implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		private Long userId;
		private Long itemId;
		
		public UserShopId() {
			
		}
		
		public UserShopId(long userId, long itemId) {
			super();
			this.userId = userId;
			this.itemId = itemId;
			
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}
	}
	
}
