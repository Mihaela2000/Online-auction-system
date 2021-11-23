package proiect;

public class Tablou extends Produs{
    public String numePictor;
    public Culori culori;

    public Tablou(int id, String nume, double pretMinim, int an, String numePictor, Culori tipEnum) {
        this.id = id;
        this.nume = nume;
        this.pretMinim = pretMinim;
        this.an = an;
        this.numePictor = numePictor;
        this.culori = tipEnum;
    }

    enum Culori {
        ulei,
        tempera,
        acrilic
    }

    public Tablou(){
    }

}
