package logica;

import datatypes.DtFecha;

class Socio extends Usuario {
    public Socio(String nickname, String nombre, String apellido, String email, DtFecha fechaNac) {
        super(nickname, nombre, apellido, email, fechaNac);
    }
}
