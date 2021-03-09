package biblio.utils;

import biblio.dto.UserDTO;
import biblio.model.User;

public class UserMapper implements IMapper<UserDTO, User> {

	@Override
	public UserDTO convertToDto(User u) {
		System.out.println(u);
		return UserDTO.builder().admin(u.isAdmin()).name(u.getName()).password(u.getPassword()).build();
	}

	@Override
	public User convertToEntity(UserDTO t) {
		return User.builder().name(t.getName()).admin(t.isAdmin()).password(t.getPassword()).build();
	}

}
