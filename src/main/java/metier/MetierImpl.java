package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao; // couplage faible

    @Override
    public double calcul() {
       double d = dao.getData();
       double res = d*13;
       return res;

    }
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
