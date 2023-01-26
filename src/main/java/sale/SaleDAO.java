package sale;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SaleDAO {

    public int getNumberOfItems();
    public List<ItemDTO> getCartItems(int id);
	public void deleteCartItem(int id);
	public int getTotalPrice(int userId);
	public int[] getCartEpisodeIds(int userId);
	public void subtractSand(@Param("userId") int userId, @Param("totalPrice") int totalPrice);
	public void addToLibrary(@Param("userId") int userId, @Param("episodeIds") int[] episodeIds);
	public void clearCart(int userId);

}
