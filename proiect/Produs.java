package proiect;

public class Produs {
    public int id;
    public String nume;
    public double pretVanzare; //prețul cu care un produs a fost vândut în urma licitației
    public double pretMinim; //prețul minim acceptat pentru vânzare
    public int an;

    public String tipMobila;
    public String materialMobila;
    public String materialBijuterie;
    public boolean piatraPretioasaBijuterie;
    public String numePictor;
    public String culoriTablou;

    public Produs() {
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public double getPretVanzare() {
        return pretVanzare;
    }

    public double getPretMinim() {
        return pretMinim;
    }

    public int getAn() {
        return an;
    }

    public Produs(int id, String nume, double pretMinim, int an, String tipMobila, String materialMobila, String materialBijuterie, boolean piatraPretioasaBijuterie, String numePictor, String culoriTablou) {
        this.id = id;
        this.nume = nume;
        this.pretMinim = pretMinim;
        this.an = an;
        this.tipMobila = tipMobila;
        this.materialMobila = materialMobila;
        this.materialBijuterie = materialBijuterie;
        this.piatraPretioasaBijuterie = piatraPretioasaBijuterie;
        this.numePictor = numePictor;
        this.culoriTablou = culoriTablou;
    }


    public Produs(int id, String nume, double pretMinim, int an) {
        this.id = id;
        this.nume = nume;
        this.pretMinim = pretMinim;
        this.an = an;
    }

}
