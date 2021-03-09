package biblio.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblio.dao.CategorieDAO;
import biblio.dto.CategorieDTO;
import biblio.model.Categorie;
import biblio.repository.IRepository;
import biblio.utils.CategorieMapper;

@Service	
//@Transactional
public class CategorieService implements ILibrairieService<CategorieDTO> {
	
	@Autowired
	private CategorieDAO dao; 
	private CategorieMapper mapper = new CategorieMapper();
	
	@Autowired
	private IRepository daoTest;
	
	
	public static void main(String[] args) {
		new CategorieService().getAll().stream().forEach(System.out::println);
	}
	
	@Override
	public List<CategorieDTO> getAll() {
		List<CategorieDTO> listeDTO = new LinkedList<>();
		List<Categorie> listeEntity = this.daoTest.findAll();
		for (Categorie entity : listeEntity) {
			listeDTO.add(mapper.convertToDto(entity));
		}
		return listeDTO;
	}

	@Override
	public CategorieDTO getById(int id) {
		return mapper.convertToDto(this.daoTest.findById(id));
	}

	@Override
	public void update(CategorieDTO o) {
		Categorie temp = this.daoTest.findById(o.getId());	
		Categorie mappedCategorie = mapper.convertToEntity(o);
		mappedCategorie.setId(temp.getId());
		this.daoTest.save(mappedCategorie);
	}

	@Override
	public void deleteById(int id) {
		this.dao.remove(id);
	}

	@Override
	public void add(CategorieDTO o) {
		this.dao.create(mapper.convertToEntity(o));
	}

	
}
