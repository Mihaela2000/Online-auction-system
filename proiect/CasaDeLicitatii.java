package proiect;
import org.apache.commons.lang3.ArrayUtils;
public class CasaDeLicitatii {
    public Produs produs;
    Client client;
    Licitatie licitatie;
    public Produs[] listProdus;
    Client[] listClient;
    Licitatie[] listLicitatie;

//    Am initializat fiecare lista deja cu cate un produs/client/licitatie
    public CasaDeLicitatii() {
        Produs prod = new Produs(0, "Tablou",1000.0, 2019, "Oglinda", "Foita de aur", "yok", true, "VanGogh", "ulei");
        this.produs = prod;
        this.listProdus = ArrayUtils.add(null, prod);

        Client cli = new Client(0, 432356, "Popescu", "Atlasului", "PersoanaFizica", 2, 3000);
        this.client = cli;
        this.listClient = ArrayUtils.add(listClient, cli);

        Licitatie licit = new Licitatie.LicitatieBuilder().setId(0).setNrParticipanti(10).setIdProdus(0).setNrPasiMaxim(15).build();
        this.licitatie = licit;
        this.listLicitatie = ArrayUtils.add(listLicitatie, licit);
    }

//    cu ajutorul acestei metode voi adauga un nou client
    Client createClient(int idLicitatie, int id, String nume, String adresa, String tipPersoana, int nrParticipari, double pretLicitat) {
        return new Client(idLicitatie, id, nume, adresa, tipPersoana, nrParticipari, pretLicitat);
    }
}