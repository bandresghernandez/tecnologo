package datatypes;

public class DtHora {

    private int hora;
    private int minutos;
 
    public DtHora(int h, int min) {
        this.hora = h;
        this.minutos = min;
    }

    public int getHora() {
        return hora;
    }

    
    public int getMinuto() {
        return minutos;
    }
}