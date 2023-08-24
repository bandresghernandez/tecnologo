package datatypes;

public class DtUsuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DtFecha fechaNac;

    public DtUsuario (String nickname, String nombre,String apellido, String email, DtFecha fechaNac ) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
    
    }

    // Getter  nickname
    public String getNickname() {
        return nickname;
    }

    // Getter  para nombre
    public String getNombre() {
        return nombre;
    }

  
    // Getter  para apellido
    public String getApellido() {
        return apellido;
    }



    // Getter  para email
    public String getEmail() {
        return email;
    }



    // Getter  para fechaNac
    public DtFecha getFechaNac() {
        return fechaNac;
    }


}
