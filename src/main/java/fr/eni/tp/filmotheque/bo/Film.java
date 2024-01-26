package fr.eni.tp.filmotheque.bo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Film implements Serializable
{
	@NotNull private int id;
	@NotNull private String titre;
	@Min(1900) @NotNull private int annee;
	@Min(1) @NotNull private int duree;
	@NotNull private String synopsis;
	@NotNull private Participant realisateur;
	@Singular("acteur") @NotNull private List<Participant> acteurs = new ArrayList<>();
	@NotNull private Genre genre;
	@Singular("un_avis") @NotNull private List<Avis> avis = new ArrayList<>();
}
