package proiect;

public class Licitatie {
    public int id;
    public int nrParticipanti;
    public int idProdus;
    public int nrPasiMaxim;

    private Licitatie(LicitatieBuilder builder) {
        this.id = builder.id;
        this.nrParticipanti = builder.nrParticipanti;
        this.idProdus = builder.idProdus;
        this.nrPasiMaxim = builder.nrPasiMaxim;
    }

    public Licitatie() {
    }

    @Override
    public String toString() {
        return "Id: " + this.id + ", Nr. participanti: " + this.nrParticipanti + ", Id produs: " + this.idProdus + ", Numar maxim de pasi: " + this.nrPasiMaxim;
    }

    public void incepeLicitatia(int idProdus, CasaDeLicitatii casaDeLicitatii) {
        String numeClient = null;
        double sumaMaxim = 0;
        for(Produs p : casaDeLicitatii.listProdus) {
            if(p.id == idProdus) {
                for(Client c : casaDeLicitatii.listClient) {
                    if(c.idLicitatie == idProdus){
                        if(c.pretLicitat > sumaMaxim){
                            sumaMaxim = c.pretLicitat;
                            numeClient = c.nume;
                        }
                    }

                }
                break;
            }
        }
        System.out.println("Constigatorul: " + numeClient + ", Id-ul produsului licitat: " + idProdus +", Cumparat cu: " + sumaMaxim );
    }

//    Acesta este un builder pentru clasa Licitatie
    public static class LicitatieBuilder {
        public int id;
        public int nrParticipanti;
        public int idProdus;
        public int nrPasiMaxim;

        public LicitatieBuilder() {
        }

        public LicitatieBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public LicitatieBuilder setNrParticipanti(int nrParticipanti) {
            this.nrParticipanti = nrParticipanti;
            return this;
        }

        public LicitatieBuilder setIdProdus(int idProdus) {
            this.idProdus = idProdus;
            return this;
        }

        public LicitatieBuilder setNrPasiMaxim(int nrPasiMaxim) {
            this.nrPasiMaxim = nrPasiMaxim;
            return this;
        }

        public Licitatie build() {
            Licitatie licitatie = new Licitatie(this);
            return licitatie;
        }
    }

}
