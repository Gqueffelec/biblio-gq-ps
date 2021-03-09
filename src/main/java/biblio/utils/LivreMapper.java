package biblio.utils;

import biblio.dto.LivreDTO;
import biblio.model.Livre;

public class LivreMapper implements IMapper<LivreDTO, Livre> {

	@Override
	public LivreDTO convertToDto(Livre entity) {
		return LivreDTO.builder().id(entity.getId()).titre(entity.getTitre()).label(entity.getLabel())
				.date_edition(entity.getDate_edition()).stock(entity.getStock()).prix(entity.getPrix())
				.categorie(new CategorieMapper().convertToDto(entity.getCategorie())).build();
	}

	@Override
	public Livre convertToEntity(LivreDTO entity) {
		return Livre.builder().id(entity.getId()).titre(entity.getTitre()).label(entity.getLabel())
				.date_edition(entity.getDate_edition()).stock(entity.getStock()).prix(entity.getPrix())
				.categorie(new CategorieMapper().convertToEntity(entity.getCategorie())).build();
	}

}
