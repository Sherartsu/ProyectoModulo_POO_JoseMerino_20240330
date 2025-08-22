package JoseMerino_20240330.JoseMerino_20240330.Controller;

import JoseMerino_20240330.JoseMerino_20240330.Model.DTO.DTOAutores;
import JoseMerino_20240330.JoseMerino_20240330.Service.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/postAutores")
    public ResponseEntity<?> insertarAutor(){
        try {
            return ResponseEntity.ok(Map.of(
                    "status", "",
                    "message", "El autor se inserto correctamente"
            ));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("No se pudo insertar el autor");
        }
    }

}
