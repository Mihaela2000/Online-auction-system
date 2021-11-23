package proiect;

public class Client {
    int id;
    String nume;
    String adresa;
    String tipPersoana;
    int nrParticipari;
    int nrLicitatiiCastigate;
    int idLicitatie;
    double pretLicitat;

    public Client() {
    }

    public Client(int idLicitatie, int id, String nume, String adresa, String tipPersoana, int nrParticipari, double pretLicitat) {
        this.idLicitatie = idLicitatie;
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.tipPersoana = tipPersoana;
        this.nrParticipari = nrParticipari;
        this.pretLicitat = pretLicitat;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public int getNrParticipari() {
        return nrParticipari;
    }

    public int getNrLicitatiiCastigate() {
        return nrLicitatiiCastigate;
    }

}
