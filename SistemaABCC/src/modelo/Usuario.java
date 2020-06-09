package modelo;

public class Usuario {
    private String numControl;
    private String nombre;
    private String primerAp;
    private String segundoAp;
    private byte edad;
    private byte semestre;
    private String carrera;

    public Usuario() {}

    public Usuario(String numControl, String nombre) {
        this.numControl = numControl;
        this.nombre = nombre;
    }

    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                numControl + "|" +
                nombre  +
                '}';
    }
}
