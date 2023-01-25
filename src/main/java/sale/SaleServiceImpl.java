package sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("saleservice")
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
}
