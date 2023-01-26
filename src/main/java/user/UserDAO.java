package user;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sale.ItemDTO;

@Mapper
@Repository
public interface UserDAO {

    public List<ItemDTO> getPurchases(int userId);

    public UserDTO oneMember(String nickname);
}
