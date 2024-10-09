package pres;

import dao.DaoImpl;
import dao.IDao;
import ext.DaoImpl2;
import metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        //DaoImpl2 d = new DaoImpl2();
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner la classe de la couche DAO: ");
        String daoClassName = sc.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getConstructor().newInstance(); //=> new DaoImpl();
        //System.out.println(dao.getData());
        //MetierImpl metier = new MetierImpl();
        System.out.println("Donner la classe de la couche Métier: ");
        String metierClassName = sc.nextLine();
        Class cMetier = Class.forName(metierClassName);
        MetierImpl metier = (MetierImpl) cMetier.getConstructor().newInstance();

        //metier.setDao(d); // injéction des dépendances
        Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
        setDao.invoke(metier,dao);//executer la méthode sur l'objet Metier // injection des dépendances
        //System.out.println("RES = " + metier.calcul());

        System.out.println("Res = "+metier.calcul());
    }
}
