package proiect;

public class Lista<E> {
    E[] tablou;
    int nr;
    public Lista(int dim) throws  IllegalArgumentException{
        if(dim<=0)
            throw new IllegalArgumentException("err");
        tablou = (E[]) new Object[dim];
        nr = 0;
    }
    public void adauga(E x) {
        if (tablou.length == nr) {
            E[] aux = (E[]) new Object[2 * tablou.length];
            for (int i = 0; i < tablou.length; i++)
                aux[i] = tablou[i];
            tablou = aux;
        }
        tablou[nr] = x;
        nr++;
    }
    public void afiseaza() {
        for(int i=0;i<nr;i++)
            System.out.println(tablou[i]);
    }
    public boolean cauta(E x){
        for(int i = 0;i<nr;i++){
            if(tablou[i].equals(x)){
                return  true;
            }
        }
        return false;
    }
}
