package Clinica.ApiGestionHistoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicioGestionHistoria {

    @Autowired
    private RestTemplate resTem;

    public HistoriaDTO grabar(Entrada ent) {
        String urlSal = "http://ApiNuevaHistoria/apiNuevaHistoria/salida";
        SalidaDTO sal = resTem.getForObject(urlSal, SalidaDTO.class);

        PacienteDTO pac = new PacienteDTO();
        pac.setNom(sal.getPac().getNom());
        pac.setDni(sal.getPac().getDni());
        pac.setPes(sal.getPac().getPes());
        pac.setTal(sal.getPac().getTal());
        pac.setEda(sal.getPac().getEda());
        pac.setEst("Activo");

        String urlPac = "http://ApiPaciente/paciente/grabar";
        PacienteDTO pacReg = resTem.postForObject(urlPac, pac, PacienteDTO.class);

        HistoriaDTO his = new HistoriaDTO();
        his.setIdPac(pacReg.getId());
        his.setIdEmp(ent.getIdEmp());

        String urlHis = "http://ApiHistoria/historia/grabar";
        HistoriaDTO hisReg = resTem.postForObject(urlHis, his, HistoriaDTO.class);

        return hisReg;
    }

}
