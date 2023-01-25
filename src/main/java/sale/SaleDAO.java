package sale;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SaleDAO {

    public int getNumberOfItems();
    public List<ItemDTO> getCartItems(int id);

}
