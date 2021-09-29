
package Modelo;


public class DetalleDomicilio {

int iddetalle;
int iddm;
String fechaentrega;
String horaentrega;
Double valordomiiclio;
String estado;

    public DetalleDomicilio() {
    }

    public DetalleDomicilio(int iddetalle, int iddm, String fechaentrega, String horaentrega, Double valordomiiclio, String estado) {
        this.iddetalle = iddetalle;
        this.iddm = iddm;
        this.fechaentrega = fechaentrega;
        this.horaentrega = horaentrega;
        this.valordomiiclio = valordomiiclio;
        this.estado = estado;
    }

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getIddm() {
        return iddm;
    }

    public void setIddm(int iddm) {
        this.iddm = iddm;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getHoraentrega() {
        return horaentrega;
    }

    public void setHoraentrega(String horaentrega) {
        this.horaentrega = horaentrega;
    }

    public Double getValordomiiclio() {
        return valordomiiclio;
    }

    public void setValordomiiclio(Double valordomiiclio) {
        this.valordomiiclio = valordomiiclio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}