package JoseMerino_20240330.JoseMerino_20240330.Controller;

import JoseMerino_20240330.JoseMerino_20240330.Model.DTO.DTOAutores;
import JoseMerino_20240330.JoseMerino_20240330.Model.DTO.DTOLibros;
import JoseMerino_20240330.JoseMerino_20240330.Service.AutoresService;
import JoseMerino_20240330.JoseMerino_20240330.Service.LibrosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Libros")
public class ControllerLibros {

    @Autowired
    private LibrosService service;

    @GetMapping("/getLibros")
    public List<DTOLibros> obtenerLibros(){
        return service.obtenerLibros();
    }

    @GetMapping("/getLibro/{id}")
    public DTOLibros obtenerLibrosPorId(@PathVariable Long id){
        return service.obtenerLibrosPorId(id);
    }

    @PostMapping("/postLibro")
    public ResponseEntity<Map<String, Object>> insertarLibro(@Valid @RequestBody DTOLibros libro){
        try {
            DTOLibros response = service.insertarLibro(libro);
            if(response == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Inserccion incorrecta",
                        "message", "Datos del libro no valido"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "succes",
                    "data", response
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "Error",
                    "message", "Error al registrar libro"
            ));
        }
    }

    @PutMapping("/putLibro/{id}")
    public ResponseEntity<Map<String, Object>> actualizarLibro(@Valid @RequestBody DTOLibros libro, @PathVariable Long id){
        try {
            DTOLibros response = service.actualizarLibro(id, libro);
            if(response == null){
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Actualizacion incorrecta",
                        "message", "Datos del libro no valido"
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

    @DeleteMapping("/deleteLibro/{id}")
    public ResponseEntity<Map<String, Object>> eliminarLibro(@PathVariable Long id){
        try {
            boolean response = service.eliminarLibro(id);
            if(!response){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Usuario no encontrado").body(Map.of(
                        "status", "Actualizacion incorrecta",
                        "message", "Datos del usuario no valido"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "succes",
                    "data", "Libro eliminado correctamente"
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "Error",
                    "message", "Error al eliminar autor"
            ));
        }
    }

}
