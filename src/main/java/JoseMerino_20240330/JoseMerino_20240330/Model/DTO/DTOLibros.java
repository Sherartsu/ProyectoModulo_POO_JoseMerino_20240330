package JoseMerino_20240330.JoseMerino_20240330.Model.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @EqualsAndHashCode @ToString
public class DTOLibros {

    private Long id;

    @NotBlank(message = "El titulo no puede ser nulo")
    private String titulo;

    @NotBlank(message = "El isbn no puede ser nulo")
    private String isbn;

    private int año_publicacion;

    @Null
    private String genero;

    private int autor_id;
}
