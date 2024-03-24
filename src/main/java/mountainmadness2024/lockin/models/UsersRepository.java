package mountainmadness2024.lockin.models;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    List<Users> findByNameAndPassword(String name, String password);
    List<Users> findByName(String name);
    List<Users> findByUid(int uid);
    
    
}
