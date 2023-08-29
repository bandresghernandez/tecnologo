package datatypes;

import java.util.List;

public class DtSocio extends DtUsuario {
    private List<DtClase> clases;
    // en el DtSocio guardamos la lista de clases que esta inscripto

    public DtSocio(String nickname, String nombre, String apellido, String email,DtFecha fechaNac,List<DtClase> clases) {
        super(nickname, nombre, apellido, email,  fechaNac);
        this.clases = clases;
    }

    // Getter 
    public List<DtClase> getClase() {
        return clases;
    }


}

