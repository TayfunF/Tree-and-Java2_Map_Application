package agac;
public class Dugum {
    int plaka;
    String sehir;
    double enlem;
    double boylam;
    Dugum sol;
    Dugum sag;
    public Dugum(int plaka,String sehir,double enlem,double boylam){
        this.plaka=plaka;
        this.sehir=sehir;
        this.enlem=enlem;
        this.boylam=boylam;
        sol=null;
        sag=null;
    }
}
