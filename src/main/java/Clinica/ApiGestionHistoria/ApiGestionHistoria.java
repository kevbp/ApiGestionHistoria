
package Clinica.ApiGestionHistoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiGestionHistoria")
public class ApiGestionHistoria {
    
    @Autowired
    private ServicioGestionHistoria serv;
    
    @PostMapping("/grabar")
    public HistoriaDTO grabarHistoria(@RequestBody Entrada ent) {
        return serv.grabar(ent);
    }
    
}
