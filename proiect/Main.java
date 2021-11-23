package proiect;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class Main {

//    -"Client" urmatoarele 2 comenzi trebuie sa fie Numele si Adresa acestuia. Dupa aceea se pot introduce
//    urmatoarele: * "VizualizareProduse" si se vor afisa toate produsele.
//            * "LicitezPentruUnProdus" , iar apoi trebuie introdus tipulPersoanei(PersoanaJuridica/
//            PersoanaFizica), id-ul persoanei(cod unic: ultimele 6 cifre din buletin), id-ul produsului pentru care
//    vrea sa liciteze, pretul licitat, pretul maxim pe care-l liciteaza. Dupa ce au fost introduse datele
//    acestea, clientul este trecut in baza de date din Casa de licitatii.
//    -"Administrator", iar apoi se pot introduce urmatoarele:
//            * "AdaugProdus" , iar administratorul va adauga in lista de produse un produs cu informatiile
//    date de la stdin(id, nume(Tablou, Mobila, Bijuterie), pretMinim, an).
//            * "VizualizareClienti" si se vor afisa toti clientii.
//    - "Broker", iar urmatoarea comanda va fi id-ul produsului care se doreste sa fie sters.
//    - "IncepeLicitatia" -> se va specifica id-ul produsului pentru care se doreste inceperea licitatiei si
//    se verifica daca avem cel putin 3 clienti care sa participe la licitatie. Daca
//    avem 5 clienti atunci putem incepe licitatia.
//    - "exit" -> acesta comanda va incheia programul.

    public static void main(String[] args) {
        FactoryProdus factoryProdus = new FactoryProdus();
        Scanner scanner = new Scanner(System.in);
        String token = scanner.next();
        CasaDeLicitatii casaDeLicitatii = new CasaDeLicitatii();
        Produs produs = new Produs();
        Client client = new Client();
        Licitatie licitatie = new Licitatie();

        while(token != null) {
            switch (token) {
                case "Client":
                    String numeClient = scanner.next();
                    String adresaClient = scanner.next();
                    token = scanner.next();
                    switch (token) {
                        case "VizualizareProduse":
                            for(Produs p : casaDeLicitatii.listProdus)
                                System.out.println("Produse care pot fi licitate: " + p.getId() + ", " + p.getNume() + ", " + ", " + p.getPretMinim() + ", " + p.getAn());
                            break;
                        case "LicitezPentruUnProdus":
                            String tipPersoana = scanner.next();
                            String idPersoana = scanner.next();
                            String id = scanner.next();
                            String pretLicitat = scanner.next();
                            String pretMax = scanner.next();

                            int clientInscris = 0;
                            for(Produs p : casaDeLicitatii.listProdus) {
                                if (p.id == Integer.parseInt(id)) {
                                        for (Client c : casaDeLicitatii.listClient) {
                                            if (c.nume.equals(numeClient) && c.adresa.equals(adresaClient)) {
                                                clientInscris = 1;
                                                c.nrParticipari += 1;
                                                c.idLicitatie = Integer.parseInt(id);
                                                for (Licitatie l : casaDeLicitatii.listLicitatie) {
                                                    if (l.idProdus == p.id) {
                                                        l.nrParticipanti += 1;
                                                    }
                                                }
                                            }
                                        }
                                        if(clientInscris == 0) {
                                            client.nrParticipari = 1;
                                            client.idLicitatie = Integer.parseInt(id);
                                            if (p.pretMinim <= Double.parseDouble(pretLicitat)) {
                                                for (Licitatie l : casaDeLicitatii.listLicitatie) {
                                                    if(l.idProdus == p.id) {
                                                        l.nrParticipanti += 1;
                                                    }
                                                }
                                            } else {
                                                System.out.println("Suma licitata este sub pretul minim(" + p.pretMinim + ") al produsului");
                                            }
                                            Client add_client = casaDeLicitatii.createClient(Integer.parseInt(id), Integer.parseInt(idPersoana), numeClient, adresaClient, tipPersoana, client.nrParticipari, Double.parseDouble(pretLicitat));
                                            casaDeLicitatii.listClient = ArrayUtils.add(casaDeLicitatii.listClient, add_client);
                                        }
                                }
                            }
                            break;
                    }
                    break;
                case "Administrator":
                    token = scanner.next();
                    switch (token) {
                        case "AdaugProdus":
                            String id = scanner.next();
                            String nume = scanner.next();
                            String pretMinim = scanner.next(); //prețul minim acceptat pentru vânzare
                            String an = scanner.next();
                            if(nume.equals("Mobila")){
                                String tipMobila = scanner.next();
                                String materialMobila = scanner.next();
                                Produs add_produs = factoryProdus.creeazaProdus(Integer.parseInt(id), nume, Double.parseDouble(pretMinim), Integer.parseInt(an), tipMobila, materialMobila, "yok", true, "Yok", "Yok");
                                casaDeLicitatii.listProdus = ArrayUtils.add(casaDeLicitatii.listProdus, add_produs);
                            } else if(nume.equals("Tablou")){
                                String numePictor = scanner.next();
                                String culoriTablou = scanner.next();
                                Produs add_produs = factoryProdus.creeazaProdus(Integer.parseInt(id), nume, Double.parseDouble(pretMinim), Integer.parseInt(an), "Yok", "Yok", "yok", true, numePictor, culoriTablou);
                                casaDeLicitatii.listProdus = ArrayUtils.add(casaDeLicitatii.listProdus, add_produs);
                            } else if(nume.equals("Bijuterie")){
                                String materialBijuterie = scanner.next();
                                String piatraPretioasaBijuterie = scanner.next();
                                Produs add_produs = factoryProdus.creeazaProdus(Integer.parseInt(id), nume, Double.parseDouble(pretMinim), Integer.parseInt(an), "yok", "yok", materialBijuterie, Boolean.parseBoolean(piatraPretioasaBijuterie), "yok", "yok");
                                casaDeLicitatii.listProdus = ArrayUtils.add(casaDeLicitatii.listProdus, add_produs);
                            }
                            break;
                        case "VizualizareClienti":
                            for(Client c:casaDeLicitatii.listClient)
                                System.out.println("Id-ul clientului: " + c.getId() + ", Nume: " + c.getNume() + ", Adresa: " + c.getAdresa() + ", Nr. participari: " + c.getNrParticipari() + ", Nr. licitatii castigate: " + c.getNrLicitatiiCastigate());
                            break;
                    }
                    break;
                case "Broker":
                    token = scanner.next();
                    switch (token) {
                        case "StergereProdus":
                            String id = scanner.next();
                            for (Produs p : casaDeLicitatii.listProdus) {
                                if (Integer.parseInt(id) == p.id) {
                                    casaDeLicitatii.listProdus = ArrayUtils.removeAllOccurrences(casaDeLicitatii.listProdus, p);
                                }
                            }

                    }
                    break;
                case "IncepeLicitatia":
                    String id = scanner.next();
                    int i = 0;
                    for(Produs p : casaDeLicitatii.listProdus) {
                        if(Integer.parseInt(id)  == p.id) {
                            for (Client c : casaDeLicitatii.listClient) {
                                if (c.idLicitatie == p.id){
                                    i++;
                                }
                            }
                        }
                    }
                    if( i >= 3){
                        for(Produs p : casaDeLicitatii.listProdus) {
                            if(Integer.parseInt(id)  == p.id){
                                produs = p;
                            }
                        }
                        licitatie.incepeLicitatia(produs.getId(), casaDeLicitatii);
                        casaDeLicitatii.listProdus = ArrayUtils.removeAllOccurrences(casaDeLicitatii.listProdus, produs);

                    } else {
                        System.out.println("Licitatie nu poate incepe pana nu se strang 3 Clienti!");
                    }
                    break;

                case "exit":
                    //opreste programul
                    System.exit(0);
                    break;
                default:
                    System.out.println("!!!Comanda gresita!!!");
            }
            token = scanner.next();
        }
    }
}