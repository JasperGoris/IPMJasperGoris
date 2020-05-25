package IPMJasperGoris.IPMJasperGoris.service;


import IPMJasperGoris.IPMJasperGoris.dto.CreateUserDTO;
import IPMJasperGoris.IPMJasperGoris.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	UserDTO createUser(CreateUserDTO userDTO);
}
