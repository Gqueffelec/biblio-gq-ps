package biblio.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LivreDTO {
	private int id;
	private String titre;
	private Date date_edition;
	private double prix;
	private String label;
	private int stock;
	private CategorieDTO categorie;
}
