package user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sale.ItemDTO;

@Service("userservice")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;

    @Override
    public List<ItemDTO> getPurchases(int userId) {
        return dao.getPurchases(userId);
    }

    @Override
    public UserDTO oneMember(String nickname) {
        return dao.oneMember(nickname);
    }

    public int joinuser(UserDTO dto) {
        return dao.joinuser(dto);
    }

}
