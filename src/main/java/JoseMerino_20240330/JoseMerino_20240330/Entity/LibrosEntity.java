package JoseMerino_20240330.JoseMerino_20240330.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Libros")
@Getter @Setter @EqualsAndHashCode @ToString
public class LibrosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Libros")
    @SequenceGenerator(name = "seq_Libros", sequenceName = "seq_Libros", allocationSize = 1)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "año_publicacion")
    private int año_publicacion;

    @Column(name = "genero")
    private String genero;

    @Column(name = "autor_id")
    private int autor_id;

}
