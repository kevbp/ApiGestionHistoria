
package Clinica.ApiGestionHistoria;

public class SalidaDTO {
    private PacienteDTO pac;

    public SalidaDTO() {
    }

    public SalidaDTO(PacienteDTO pac) {
        this.pac = pac;
    }

    public PacienteDTO getPac() {
        return pac;
    }

    public void setPac(PacienteDTO pac) {
        this.pac = pac;
    }
    
    
}
