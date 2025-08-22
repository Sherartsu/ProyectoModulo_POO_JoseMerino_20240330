package JoseMerino_20240330.JoseMerino_20240330.Service;

import JoseMerino_20240330.JoseMerino_20240330.Entity.AutoresEntity;
import JoseMerino_20240330.JoseMerino_20240330.Entity.LibrosEntity;
import JoseMerino_20240330.JoseMerino_20240330.Model.DTO.DTOAutores;
import JoseMerino_20240330.JoseMerino_20240330.Model.DTO.DTOLibros;
import JoseMerino_20240330.JoseMerino_20240330.Repository.AutoresRepository;
import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AutoresService {

    @Autowired
    private AutoresRepository repo;

    public List<DTOAutores> obtenerAutores() {
        List<AutoresEntity> autores = repo.findAll();
        return autores.stream().map(this::ConvertirADtoAutores).collect(Collectors.toList());
    }

    public DTOAutores ConvertirADtoAutores(AutoresEntity autor){
        DTOAutores dto = new DTOAutores();
        dto.setId(autor.getId());
        dto.setNombre(autor.getNombre());
        dto.setApellido(autor.getApellido());
        dto.setNacionalidad(autor.getNacionalidad());
        dto.setFecha_nacimiento(autor.getFecha_nacimiento());
        return dto;
    }

    public AutoresEntity ConvertirAEntityAutores(DTOAutores autor){
        AutoresEntity entity = new AutoresEntity();
        entity.setNombre(autor.getNombre());
        entity.setApellido(autor.getApellido());
        entity.setNacionalidad(autor.getNacionalidad());
        entity.setFecha_nacimiento(autor.getFecha_nacimiento());
        return entity;
    }

    public AutoresEntity ConvertirAEntityAutoresUpdate(Long id, DTOAutores autor){
        AutoresEntity entity = new AutoresEntity();
        entity.setId(id);
        entity.setNombre(autor.getNombre());
        entity.setApellido(autor.getApellido());
        entity.setNacionalidad(autor.getNacionalidad());
        entity.setFecha_nacimiento(autor.getFecha_nacimiento());
        return entity;
    }

    public DTOAutores insertarAutor(DTOAutores autor) {
        try{
            AutoresEntity data = ConvertirAEntityAutores(autor);
            AutoresEntity autorGuardado = repo.save(data);
            return ConvertirADtoAutores(autorGuardado);
        } catch (Exception e) {
            log.error("Error al registrar al autor");
            return null;
        }
    }

    public DTOAutores actualizarAutor(Long id, DTOAutores autor) {
        try{
            AutoresEntity data = ConvertirAEntityAutoresUpdate(id, autor);
            AutoresEntity autorActualizado = repo.save(data);
            return ConvertirADtoAutores(autorActualizado);
        } catch (Exception e) {
            log.error("Error al actualizar al autor");
            return null;
        }
    }

    public boolean eliminarAutor(Long id) {
        try{
            AutoresEntity autorAEliminar = repo.findById(id).orElseThrow(null);
            if(autorAEliminar != null){
                repo.deleteById(id);
                return true;
            } else {
                System.out.println("Autor no encontrado");
                return false;
            }
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("No se encontro autor con id: " + id, 1);
        }
    }

    public DTOAutores obtenerAutorPorId(Long id) {
        AutoresEntity autor = repo.findById(id).orElseThrow(null);
        return ConvertirADtoAutores(autor);
    }
}
