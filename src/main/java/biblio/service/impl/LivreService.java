package biblio.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblio.dao.LivreDAO;
import biblio.dto.LivreDTO;
import biblio.model.Livre;
import biblio.service.ILibrairieService;
import biblio.utils.LivreMapper;

@Service
public class LivreService implements ILibrairieService<LivreDTO> {

	@Autowired
	private LivreDAO dao;
	private LivreMapper mapper = new LivreMapper();

	@Override
	public List<LivreDTO> getAll() {
		List<LivreDTO> listeDTO = new LinkedList<>();
		List<Livre> listeEntity = this.dao.getAll();
		for (Livre entity : listeEntity) {
			listeDTO.add(mapper.convertToDto(entity));
		}
		return listeDTO;
	}

	@Override
	public LivreDTO getById(int id) {
		return mapper.convertToDto(this.dao.getById(id));
	}

	@Override
	public void update(LivreDTO o) {
		this.dao.update(mapper.convertToEntity(o));
	}

	@Override
	public void deleteById(int id) {
		this.dao.remove(id);
	}

	@Override
	public void add(LivreDTO o) {
		this.dao.create(mapper.convertToEntity(o));
	}

}
