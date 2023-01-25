package sale;

import java.util.List;

public interface SaleService {

    public int getNumberOfItems();
    public List<ItemDTO> getCartItems(int id);
	public void deleteCartItem(int id);

}
