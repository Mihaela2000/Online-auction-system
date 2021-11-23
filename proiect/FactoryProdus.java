package proiect;

public class FactoryProdus {
//    am folosit acest factory pentru a creea produse
    public Produs creeazaProdus(int id, String nume, double pretMinim, int an, String tipMobila, String materialMobila, String materialBijuterie, boolean piatraPretioasaBijuterie, String numePictor, String culoriTablou ) {
        switch (nume) {
            case "Tablou":
                switch (culoriTablou) {
                    case "ulei":
                        return new Tablou(id, nume, pretMinim, an, numePictor, Tablou.Culori.ulei);
                    case"tempera":
                        return new Tablou(id, nume, pretMinim, an, numePictor, Tablou.Culori.tempera);
                    case "acrilic":
                        return new Tablou(id, nume, pretMinim, an, numePictor, Tablou.Culori.acrilic);
                    default:
                        return null;
                }
            case "Mobila":
                return new Mobila(id, nume, pretMinim, an, tipMobila, materialMobila);
            case "Bijuterie":
                return new Bijuterie(id, nume, pretMinim, an, materialBijuterie, piatraPretioasaBijuterie);
            default:
                return null;
        }
    }

}
