package pres;

import dao.DaoImpl;
import ext.DaoImpl2;
import metier.MetierImpl;

public class Pres2 {
    public static void main(String[] args) {
        DaoImpl2 d = new DaoImpl2();
        MetierImpl metier = new MetierImpl();
        metier.setDao(d); // injéction des dépendances
        System.out.println("RES = " + metier.calcul());
    }
}
