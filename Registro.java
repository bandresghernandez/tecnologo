package logica;

public class Registro {

    private DtFecha fechaReg;

    public Registro(DtFecha f) {
        this.fechaReg = f;
    }

    public DtFecha getFechaReg() {
        return fechaReg;
    }

    public DtFecha setFechaReg(DtFecha f) {
        fechaReg = f;
    }
}
