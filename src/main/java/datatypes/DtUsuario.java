package datatypes;

public class DtUsuario {
    private String nickname;
    private String pass;
    private String nombre;
    private String apellido;
    private String email;
    private DtFecha fechaNac;

    public DtUsuario (String nickname, String pass, String nombre,String apellido, String email, DtFecha fechaNac ) {
        this.nickname = nickname;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
    
    }

    // Getter para nickname
    public String getNickname() {
        return nickname;
    }
    
    public String getPass() {
    	return pass;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }



    // Getter para apellido
    public String getApellido() {
        return apellido;
    }



    // Getter para email
    public String getEmail() {
        return email;
    }

 

    // Getterpara fechaNac
    public DtFecha getFechaNac() {
        return fechaNac;
    }


}
