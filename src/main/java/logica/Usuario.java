package logica;

import datatypes.DtFecha;
import datatypes.DtUsuario;

public abstract class Usuario {

    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DtFecha fechaNac;

    public Usuario(String nick, String nombre, String apellido, String email, DtFecha fechaNac) {
        this.nickname = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
    }

    public abstract DtUsuario getDtUsuario();
    
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

    public void setNickname(String nick) {
        this.nickname = nick;
    }

     public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNac(DtFecha fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    public abstract DtUsuario obtenerInfo(); 

}
