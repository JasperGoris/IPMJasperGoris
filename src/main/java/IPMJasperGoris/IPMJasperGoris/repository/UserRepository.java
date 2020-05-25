package IPMJasperGoris.IPMJasperGoris.repository;


import IPMJasperGoris.IPMJasperGoris.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
