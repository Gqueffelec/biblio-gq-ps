package biblio.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategorieDTO {
	private int id;
	private String nom;
	private String label;
	private String information_technique;
}
