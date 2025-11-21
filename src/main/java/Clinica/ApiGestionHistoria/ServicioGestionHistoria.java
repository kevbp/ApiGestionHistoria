package Clinica.ApiGestionHistoria;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicioGestionHistoria {

    @Autowired
    private RestTemplate resTem;
    DateTimeFormatter fmtFec = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter fmtHor = DateTimeFormatter.ofPattern("HH:mm:ss");

    public HistoriaDTO grabar(Entrada ent) {

        PacienteDTO pac = new PacienteDTO();
        pac.setNom(ent.getNom());
        pac.setDni(ent.getDni());
        pac.setPes(ent.getPes());
        pac.setTal(ent.getTal());
        pac.setEda(ent.getEda());
        pac.setEst("Activo");

        String urlPac = "http://ApiPaciente/paciente/grabar";
        PacienteDTO pacReg = resTem.postForObject(urlPac, pac, PacienteDTO.class);

        HistoriaDTO his = new HistoriaDTO();
        his.setFecCre(LocalDate.now().format(fmtFec));
        his.setHorCre(LocalTime.now().format(fmtHor));
        his.setIdPac(pacReg.getId());
        his.setIdEmp(ent.getIdEmp());

        String urlHis = "http://ApiHistoria/historia/grabar";
        HistoriaDTO hisReg = resTem.postForObject(urlHis, his, HistoriaDTO.class);

        return hisReg;
    }
    
    public SalidaHistoria buscar(Long id){
        String urlBusHis = "http://ApiHistoria/historia/buscar/" + id;
        HistoriaDTO his = resTem.getForObject(urlBusHis, HistoriaDTO.class);
        
        String urlBusPac = "http://ApiPaciente/paciente/buscar/" + his.getIdPac();
        String urlBusEmp = "http://ApiHistoria/historia/buscar/" + his.getIdEmp();
        
        PacienteDTO pac = resTem.getForObject(urlBusPac, PacienteDTO.class);
        EmpleadoDTO emp = resTem.getForObject(urlBusEmp, EmpleadoDTO.class);
        
        SalidaHistoria salHis = new SalidaHistoria();
        salHis.setIdHis(his.getId());
        salHis.setFecCre(his.getFecCre());
        salHis.setHorCre(his.getHorCre());
        salHis.setPac(pac);
        salHis.setEmp(emp);
        
        return salHis;
    }

}
