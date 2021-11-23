package proiect;
import java.util.ArrayList;
import java.util.List;

public class Broker extends Angajat {
    public Client[] listClient;

    public Broker() {
    }

//    am creeat clasa comision unde voi adauga un comision in functie de tipul persoanei
//    si de numarul de participari ale acestora
    public double comision(String tipPersoana, int nrParticipari, double pretLicitat) {
        //C1
        if(tipPersoana == "PersoanaFizica" && nrParticipari < 5) {
            pretLicitat = pretLicitat + 0.2*pretLicitat;
        }
        //C2
        else if(tipPersoana == "PersoanaFizica" && nrParticipari >= 5) {
            pretLicitat = pretLicitat + 0.15*pretLicitat;
        }
        //C3
        else if(tipPersoana == "PersoanaJuridica" && nrParticipari < 25) {
            pretLicitat = pretLicitat + 0.25*pretLicitat;
        }
        //C4
        else if(tipPersoana == "PersoanaJuridica" && nrParticipari >= 25){
            pretLicitat = pretLicitat + 0.1*pretLicitat;
        }
        return pretLicitat;
    }

}
