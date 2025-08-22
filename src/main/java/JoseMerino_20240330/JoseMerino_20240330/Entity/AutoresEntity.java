package JoseMerino_20240330.JoseMerino_20240330.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Autores")
@Getter @Setter @EqualsAndHashCode @ToString
public class AutoresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Autores")
    @SequenceGenerator(name = "seq_Autores", sequenceName = "seq_Autores", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String Apellido;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
}
