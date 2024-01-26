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
public class Avis implements Serializable
{
	@NotNull private int id;
	@NotNull private int note;
	@NotNull private String commentaire;
	@NotNull private Membre membre;
}
