package biblio.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
	private String nom;
	private String password;
	private boolean admin;
}
