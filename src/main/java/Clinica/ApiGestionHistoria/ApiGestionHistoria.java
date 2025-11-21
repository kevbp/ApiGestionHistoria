
package Clinica.ApiGestionHistoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiGestionHistoria")
public class ApiGestionHistoria {
    
    @Autowired
    private ServicioGestionHistoria serv;
    
    @PostMapping("/procesarYGrabar")
    public SalidaHistoria procesarYGrabar(@RequestBody Entrada ent) {
        return serv.grabar(ent);
    }
    
    @GetMapping("/buscar")
    public SalidaHistoria buscar(@PathVariable Long idHor) {
        return serv.buscar(idHor);
    }
    
}
