package biblio.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblio.dao.LivreDAO;
import biblio.dto.LivreDTO;
import biblio.model.Livre;
import biblio.repository.IRepositoryLivre;
import biblio.service.ILibrairieService;
import biblio.utils.LivreMapper;

@Service
public class LivreService implements ILibrairieService<LivreDTO> {

	private LivreMapper mapper = new LivreMapper();

	@Autowired
	private IRepositoryLivre daoTest;

	@Override
	public List<LivreDTO> getAll() {
		List<LivreDTO> listeDTO = new LinkedList<>();
		List<Livre> listeEntity = this.daoTest.findAll();
		for (Livre entity : listeEntity) {
			listeDTO.add(mapper.convertToDto(entity));
		}
		return listeDTO;
	}

	@Override
	public LivreDTO getById(int id) {
		return mapper.convertToDto(this.daoTest.findById(id).get());
	}

	@Override
	public void update(LivreDTO o) {
		Optional<Livre> temp = this.daoTest.findById(o.getId());
		Livre mappedLivre = mapper.convertToEntity(o);
		mappedLivre.setId(temp.get().getId());
		this.daoTest.save(mappedLivre);
	}

	@Override
	public void deleteById(int id) {
		this.daoTest.deleteById(id);
	}

	@Override
	public void add(LivreDTO o) {
		this.daoTest.save(mapper.convertToEntity(o));
	}

}
