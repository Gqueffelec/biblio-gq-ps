package biblio.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblio.dto.CategorieDTO;
import biblio.model.Categorie;
import biblio.repository.IRepositoryCategorie;
import biblio.service.ILibrairieService;
import biblio.utils.CategorieMapper;

@Service	
//@Transactional
public class CategorieService implements ILibrairieService<CategorieDTO> {
	
	private CategorieMapper mapper = new CategorieMapper();
	
	@Autowired
	private IRepositoryCategorie dao;
	
	
	public static void main(String[] args) {
		new CategorieService().getAll().stream().forEach(System.out::println);
	}
	
	@Override
	public List<CategorieDTO> getAll() {
		List<CategorieDTO> listeDTO = new LinkedList<>();
		List<Categorie> listeEntity = this.dao.findAll();
		for (Categorie entity : listeEntity) {
			listeDTO.add(mapper.convertToDto(entity));
		}
		return listeDTO;
	}

	@Override
	public CategorieDTO getById(int id) {
		return mapper.convertToDto(this.dao.findById(id).get());
	}

	@Override
	public void update(CategorieDTO o) {
		Optional<Categorie> temp = this.dao.findById(o.getId());	
		Categorie mappedCategorie = mapper.convertToEntity(o);
		mappedCategorie.setId(temp.get().getId());
		this.dao.save(mappedCategorie);
	}

	@Override
	public void deleteById(int id) {
		this.dao.deleteById(id);
	}

	@Override
	public void add(CategorieDTO o) {
		this.dao.save(mapper.convertToEntity(o));
	}

}
