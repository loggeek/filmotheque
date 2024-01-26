package fr.eni.tp.filmotheque.bo;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Membre implements Serializable
{
	@NotNull private int id;
	@NotNull private String nom;
	@NotNull private String prenom;

	@NotNull private String pseudo;
	@NotNull @ToString.Exclude private String motDePasse;
	@NotNull private boolean isAdmin;
}
