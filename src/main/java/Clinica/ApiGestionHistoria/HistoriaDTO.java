
package Clinica.ApiGestionHistoria;

public class HistoriaDTO {

    private Long id;
    private Long idPac;
    private Long idEmp;

    public HistoriaDTO() {
    }

    public HistoriaDTO(Long id, Long idPac, Long idEmp) {
        this.id = id;
        this.idPac = idPac;
        this.idEmp = idEmp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPac() {
        return idPac;
    }

    public void setIdPac(Long idPac) {
        this.idPac = idPac;
    }

    public Long getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Long idEmp) {
        this.idEmp = idEmp;
    }
    
    
}
