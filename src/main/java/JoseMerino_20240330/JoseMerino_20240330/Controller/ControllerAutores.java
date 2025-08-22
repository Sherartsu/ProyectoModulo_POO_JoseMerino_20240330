package JoseMerino_20240330.JoseMerino_20240330.Controller;

import JoseMerino_20240330.JoseMerino_20240330.Model.DTO.DTOAutores;
import JoseMerino_20240330.JoseMerino_20240330.Model.DTO.DTOLibros;
import JoseMerino_20240330.JoseMerino_20240330.Service.AutoresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/autores")
public class ControllerAutores {

    @Autowired
    private AutoresService service;

    @GetMapping("/getAutores")
    public List<DTOAutores> obtenerAutores(){
        return service.obtenerAutores();
    }

    @GetMapping("/getAutor/{id}")
    public DTOAutores obtenerLibrosPorId(@PathVariable Long id){
        return service.obtenerAutorPorId(id);
    }

    @PostMapping("/postAutor")
    public ResponseEntity<Map<String, Object>> insertarAutor(@Valid @RequestBody DTOAutores autor){
        try {
            DTOAutores response = service.insertarAutor(autor);
            if(response == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Inserccion incorrecta",
                        "message", "Datos del usuario no valido"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "succes",
                    "data", response
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "Error",
                    "message", "Error al registrar autor"
            ));
        }
    }

    @PutMapping("/putAutor/{id}")
    public ResponseEntity<Map<String, Object>> actualizarAutor(@Valid @RequestBody DTOAutores autor, @PathVariable Long id){
        try {
            DTOAutores response = service.actualizarAutor(id, autor);
            if(response == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Actualizacion incorrecta",
                        "message", "Datos del usuario no valido"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "succes",
                    "data", response
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "Error",
                    "message", "Error al actualizar autor"
            ));
        }
    }

    @DeleteMapping("/deleteAutor/{id}")
    public ResponseEntity<Map<String, Object>> actualizarAutor(@PathVariable Long id){
        try {
            boolean response = service.eliminarAutor(id);
            if(!response){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Usuario no encontrado").body(Map.of(
                        "status", "Actualizacion incorrecta",
                        "message", "Datos del autor no valido"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "succes",
                    "data", "Autor eliminado correctamente"
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "Error",
                    "message", "Error al eliminar autor"
            ));
        }
    }

}
