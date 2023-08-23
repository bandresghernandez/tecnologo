package logica;

import datatypes.DtFecha;

public class Registro {

    private DtFecha fechaReg;

    public Registro(DtFecha f) {
        this.fechaReg = f;
    }

    public DtFecha getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(DtFecha f) {
        fechaReg = f;
    }
}
