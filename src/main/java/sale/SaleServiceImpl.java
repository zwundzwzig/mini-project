package sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("saleservice")
@Transactional
public class SaleServiceImpl implements SaleService{

    @Autowired
    SaleDAO dao;

    @Override
    public int getNumberOfItems() {
        return dao.getNumberOfItems();
    }

    @Override
    public List<ItemDTO> getCartItems(int id) {
        return dao.getCartItems(id);
    }

	@Override
	public void deleteCartItem(int id) {
		dao.deleteCartItem(id);
	}

	@Override
	public void buyEpisodes(int userId, int[] episodeIds) {
		int totalPrice = dao.getTotalPrice(episodeIds);
		dao.subtractSand(userId, totalPrice);
		dao.addToLibrary(userId, episodeIds);
		dao.clearCart(userId, episodeIds);
	}

	@Override
	public int getBalance(int id) {
		return dao.getBalance(id);
	}
	
	
    
}
