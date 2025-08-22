package JoseMerino_20240330.JoseMerino_20240330.Model.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.util.Date;

@Getter @Setter @EqualsAndHashCode @ToString
public class DTOAutores {

    @Id
    private int id;

    @NonNull
    private String nombre;

    @NotNull
    private String Apellido;

    @Null
    private String nacionalidad;

    @Null
    private Date fecha_nacimiento;
}
