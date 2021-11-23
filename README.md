# Online-auction-system

1) In main (explicatie si pentru teste):
Daca este introdus de la input:
    -"Client" urmatoarele 2 comenzi trebuie sa fie Numele si Adresa acestuia. Dupa aceea se pot introduce
urmatoarele: * "VizualizareProduse" si se vor afisa toate produsele.
	     * "LicitezPentruUnProdus" , iar apoi trebuie introdus tipulPersoanei(PersoanaJuridica/
PersoanaFizica), id-ul persoanei(cod unic: ultimele 6 cifre din buletin), id-ul produsului pentru care 
vrea sa liciteze, pretul licitat, pretul maxim pe care-l liciteaza. Dupa ce au fost introduse datele 
acestea, clientul este trecut in baza de date din Casa de licitatii. 
    -"Administrator", iar apoi se pot introduce urmatoarele: 
	     * "AdaugProdus" , iar administratorul va adauga in lista de produse un produs cu informatiile 
date de la stdin(id, nume(Tablou, Mobila, Bijuterie), pretMinim, an).
	     * "VizualizareClienti" si se vor afisa toti clientii.
    - "Broker", iar urmatoarea comanda va fi id-ul produsului care se doreste sa fie sters.
    - "IncepeLicitatia" -> se va specifica id-ul produsului pentru care se doreste inceperea licitatiei si 
se verifica daca avem cel putin 3 clienti care sa participe la licitatie. Daca 
avem 5 clienti atunci putem incepe licitatia.
    - "exit" -> acesta comanda va incheia programul.

2) design pattern : - am implementat un builder pentru clasa Licitatie
		    - am implementat un factory pentru casa Produs

3) Clasa: - avem clasele Broker si Administrator care extind clasa Angajat
		*in clasa Broker am implementat metoda pentru comision
	  - in clasa CasaDelicitatii am initializat listele de clienti, produse si licitatii si am facut 
metoda care ma ajuta la crearea unui cont pentru un nou client.
	  - in clasa Client am un constructor gol si un constructor cu toate variabilele din clasa si niste 
getteri
	  - cu ajutorul clasei FactoryProdus creez un nou produs cu informatiile primite de la tastatura.
	  - in clasa Licitatie am facut un builder si metoda pentru inceperea licitatiei.
	  - am facut clasele Mobila, Tablou si Bijuterie care extind clasa Produs. Am toate aceste clase am 
doar getteri si Constructori.

4) SPECIFICATII: am introdus biblioteca opencsv 5.3
