package proiect;

public class Bijuterie extends Produs {
    String material;
    boolean piatraPretioasa;

    public Bijuterie(int id, String nume, double pretMinim, int an, String material, boolean piatraPretioasa) {
        this.id = id;
        this.nume = nume;
        this.pretMinim = pretMinim;
        this.an = an;
        this.material = material;
        this.piatraPretioasa = piatraPretioasa;
    }

    public Bijuterie() {
        this.material = material;
        this.piatraPretioasa = piatraPretioasa;
    }
}
