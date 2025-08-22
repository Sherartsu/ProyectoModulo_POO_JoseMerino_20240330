package JoseMerino_20240330.JoseMerino_20240330.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Libros")
public class LibrosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



}
