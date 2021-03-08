package biblio.utils;

import biblio.dto.CategorieDTO;
import biblio.model.Categorie;

public class CategorieMapper implements IMapper<CategorieDTO, Categorie> {

	@Override
	public CategorieDTO convertToDto(Categorie entity) {
		return CategorieDTO.builder().id(entity.getId()).nom(entity.getNom()).label(entity.getLabel()).information_technique(entity.getInformation_technique()).build();
	}

	@Override
	public Categorie convertToEntity(CategorieDTO dto) {
		return Categorie.builder().id(dto.getId()).nom(dto.getNom()).label(dto.getLabel()).information_technique(dto.getInformation_technique()).build();
	}

}
