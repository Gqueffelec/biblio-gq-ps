package biblio.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblio.dto.UserDTO;
import biblio.model.User;
import biblio.repository.IRepositoryUser;
import biblio.service.IUserService;
import biblio.utils.UserMapper;

@Service
public class UserService implements IUserService<UserDTO> {

	private UserMapper mapper = new UserMapper();
	
	@Autowired
	private IRepositoryUser dao;

	@Override
	public UserDTO login(UserDTO o) {
		User temp = dao.findByName(o.getName());
		if (temp == null) {
			return null;
		}
		if (temp.getName().equals(o.getName()) && temp.getPassword().equals(o.getPassword())) {
			o.setAdmin(temp.isAdmin());
			return o;
		} else {
			return null;
		}
	}

	@Override
	public void save(UserDTO o) {
		this.dao.save(new UserMapper().convertToEntity(o));
	}

	public List<UserDTO> getAll() {
		List<UserDTO> listeDTO = new LinkedList<>();
		List<User> listeEntity = this.dao.findAll();
		for (User entity : listeEntity) {
			UserDTO temp = mapper.convertToDto(entity);
			listeDTO.add(temp);
		}
		return listeDTO;
	}

}
