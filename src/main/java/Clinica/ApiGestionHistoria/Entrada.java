
package Clinica.ApiGestionHistoria;

public class Entrada {
    
    private Long idHis;
    private String nom;
    private int dni;
    private double pes;
    private double tal;
    private int eda;
    private Long idEmp;

    public Entrada() {
    }

    public Entrada(Long idHis, String nom, int dni, double pes, double tal, int eda, Long idEmp) {
        this.idHis = idHis;
        this.nom = nom;
        this.dni = dni;
        this.pes = pes;
        this.tal = tal;
        this.eda = eda;
        this.idEmp = idEmp;
    }

    public Long getIdHis() {
        return idHis;
    }

    public void setIdHis(Long idHis) {
        this.idHis = idHis;
    }

    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    public double getTal() {
        return tal;
    }

    public void setTal(double tal) {
        this.tal = tal;
    }

    public int getEda() {
        return eda;
    }

    public void setEda(int eda) {
        this.eda = eda;
    }

    public Long getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Long idEmp) {
        this.idEmp = idEmp;
    }

    
    
}
