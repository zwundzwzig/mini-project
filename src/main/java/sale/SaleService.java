package sale;

import java.util.List;

public interface SaleService {

    public int getNumberOfItems();
    public List<ItemDTO> getCartItems(int id);
	public void deleteCartItem(int id);
	public void buyEpisodes(int userId, int[] episodeIds) throws Exception;
	public int getBalance(int id);

}
