package logica;

import datatypes.DtFecha;

public class Usuario {

    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DtFecha fechaNac;

    public Usuario(String ni, String n, String ap, String e, DtFecha fn) {
        this.nickname = ni;
        this.nombre = n;
        this.apellido = ap;
        this.email = e;
        this.fechaNac = fn;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public DtFecha getFechaNac() {
        return fechaNac;
    }

    public void setNickname(String ni) {
        nickname = ni;
    }

     public void setNombre(String n) {
        nombre = n;
    }

    public void setApellido(String ap) {
        apellido = ap;
    }

    public void setEmail(String e) {
        email = e;
    }

    public void setFechaNac(DtFecha fn) {
        fechaNac = fn;
    }

}
