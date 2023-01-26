package user;

import java.util.List;
import sale.ItemDTO;

public interface UserService {

    public List<ItemDTO> getPurchases(int userId);

    public UserDTO oneMember(String nickname);

}
