package JoseMerino_20240330.JoseMerino_20240330.Model.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @EqualsAndHashCode @ToString
public class DTOLibros {

    @Id
    private int id;

    @NotNull
    private String titulo;

    @NotNull
    private String isbn;

    @Null
    private int año_publicacion;

    @Null
    private String genero;

    private int autor_id;
}
