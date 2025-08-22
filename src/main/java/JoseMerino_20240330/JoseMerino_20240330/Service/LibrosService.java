package JoseMerino_20240330.JoseMerino_20240330.Service;

import JoseMerino_20240330.JoseMerino_20240330.Entity.AutoresEntity;
import JoseMerino_20240330.JoseMerino_20240330.Entity.LibrosEntity;
import JoseMerino_20240330.JoseMerino_20240330.Model.DTO.DTOAutores;
import JoseMerino_20240330.JoseMerino_20240330.Model.DTO.DTOLibros;
import JoseMerino_20240330.JoseMerino_20240330.Repository.AutoresRepository;
import JoseMerino_20240330.JoseMerino_20240330.Repository.LibrosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LibrosService {

    @Autowired
    private LibrosRepository repo;

    public List<DTOLibros> obtenerLibros() {
        List<LibrosEntity> libros = repo.findAll();
        return libros.stream().map(this::ConvertirADtoLibros).collect(Collectors.toList());
    }

    public DTOLibros ConvertirADtoLibros(LibrosEntity libro){
        DTOLibros dto = new DTOLibros();
        dto.setId(libro.getId());
        dto.setTitulo(libro.getTitulo());
        dto.setIsbn(libro.getIsbn());
        dto.setAño_publicacion(libro.getAño_publicacion());
        dto.setGenero(libro.getGenero());
        dto.setAutor_id(libro.getAutor_id());
        return dto;
    }

    public LibrosEntity ConvertirAEntityLibros(DTOLibros libro){
        LibrosEntity entity = new LibrosEntity();
        entity.setTitulo(libro.getTitulo());
        entity.setIsbn(libro.getIsbn());
        entity.setAño_publicacion(libro.getAño_publicacion());
        entity.setGenero(libro.getGenero());
        entity.setAutor_id(libro.getAutor_id());
        return entity;
    }

    public LibrosEntity ConvertirAEntityLibrosUpdate(Long id, DTOLibros libro){
        LibrosEntity entity = new LibrosEntity();
        entity.setId(id);
        entity.setTitulo(libro.getTitulo());
        entity.setIsbn(libro.getIsbn());
        entity.setAño_publicacion(libro.getAño_publicacion());
        entity.setGenero(libro.getGenero());
        entity.setAutor_id(libro.getAutor_id());
        return entity;
    }

    public DTOLibros insertarLibro(DTOLibros libro) {
        try{
            LibrosEntity data = ConvertirAEntityLibros(libro);
            LibrosEntity libroGuardado = repo.save(data);
            return ConvertirADtoLibros(libroGuardado);
        } catch (Exception e) {
            log.error("Error al registrar el libro");
            return null;
        }
    }

    public DTOLibros actualizarLibro(Long id, DTOLibros autor) {
        try{
            LibrosEntity data = ConvertirAEntityLibrosUpdate(id, autor);
            LibrosEntity libroActualizado = repo.save(data);
            return ConvertirADtoLibros(libroActualizado);
        } catch (Exception e) {
            log.error("Error al actualizar al libro");
            return null;
        }
    }

    public boolean eliminarLibro(Long id) {
        try{
            LibrosEntity libroAEliminar = repo.findById(id).orElseThrow(null);
            if(libroAEliminar != null){
                repo.deleteById(id);
                return true;
            } else {
                System.out.println("libro no encontrado");
                return false;
            }
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("No se encontro libro con id: " + id, 1);
        }
    }

    public DTOLibros obtenerLibrosPorId(Long id) {
        try{
            LibrosEntity libro = repo.findById(id).orElseThrow(null);
            return ConvertirADtoLibros(libro);
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("No se encontro libro con id: " + id, 1);
        }

    }
}
