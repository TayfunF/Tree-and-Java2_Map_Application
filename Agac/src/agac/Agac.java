package agac;

import java.util.LinkedList;
import java.util.Queue;
public class Agac {

    int uzunluk = 0;
    Dugum kok;

    public Agac() {
        kok = null;
    }

    boolean yaprakMı(Dugum yeni) {
        return yeni.sol == null && yeni.sag == null;
    }

    void ekle(Dugum yeni) {
        uzunluk++;
        if (kok == null) {
            kok = yeni;
        } else {
            Dugum tmp = kok;
            Dugum once = null;
            while (tmp != null) {
                once = tmp;
                if (yeni.plaka < tmp.plaka) {
                    tmp = tmp.sol;
                } else {
                    tmp = tmp.sag;
                }
            }
            if (yeni.plaka < once.plaka) {
                once.sol = yeni;
            } else {
                once.sag = yeni;
            }
        }
    }

    Dugum ara(int aranan) {
        Dugum tmp = kok;
        while (tmp != null) {
            if (aranan == tmp.plaka) {
                return tmp;
            } else if (aranan < tmp.plaka) {
                tmp = tmp.sol;
            } else {
                tmp = tmp.sag;
            }
        }
        return null;
    }

    boolean sil(int plaka) {
        Dugum tmp = kok;
        Dugum ata = kok;
        boolean solCocuk = false;
        while (tmp.plaka != plaka) {
            ata = tmp;
            if (plaka < tmp.plaka) {
                tmp = tmp.sol;
                solCocuk = true;
            } else {
                tmp = tmp.sag;
                solCocuk = false;
            }
            if (tmp == null) {
                return false;
            }
        }
        if (yaprakMı(tmp)) {
            if (tmp == kok) {
                kok = null;
            } else if (solCocuk) {
                ata.sol = null;
            } else {
                ata.sag = null;
            }
        } else if (tmp.sol == null) {
            if (tmp == kok) {
                kok = tmp.sag;
            } else if (solCocuk) {
                ata.sol = tmp.sag;
            } else {
                ata.sag = tmp.sag;
            }
        } else if (tmp.sag == null) {
            if (tmp == kok) {
                kok = tmp.sol;
            } else if (solCocuk) {
                ata.sol = ata.sol;
            } else {
                ata.sag = tmp.sol;
            }
        }
        return true;
    }

    void preorder(Dugum yeni) {
        if (yeni == null) {
            return;
        }
        System.out.print(yeni.plaka + " ");
        preorder(yeni.sol);
        preorder(yeni.sag);
    }

    void inorder(Dugum yeni) {
        if (yeni == null) {
            return;
        }
        inorder(yeni.sol);
        System.out.print(yeni.plaka + " ");
        inorder(yeni.sol);
    }

    void postorder(Dugum yeni) {
        if (yeni == null) {
            return;
        }
        postorder(yeni.sol);
        postorder(yeni.sag);
        System.out.print(yeni.plaka + " ");
    }
 Dugum returnSecondBiggest(Dugum yeni){
        Dugum biggestPl= yeni;
        Dugum biggest2Pl= null;
        while (yeni!= null){
            if (yeni.plaka > biggestPl.plaka){
                biggest2Pl= biggestPl;
                biggestPl= yeni;
            }else if (biggest2Pl==null){
                biggest2Pl= yeni;
            }else if (yeni.plaka > biggest2Pl.plaka){
                biggest2Pl= yeni;
            }
            yeni= yeni.sag;
        }
        return biggest2Pl; 
    }



 public int isBalanced(Dugum kok){
        if(kok==null){
            return 0;
        }
        int leftH = isBalanced(kok.sol);
        if(leftH==-1)
            return -1;

        int rightH = isBalanced(kok.sag);
        if(rightH==-1)
            return -1;

        int diff = leftH-rightH;
        if(Math.abs(diff)>1)
            return -1;
        return 1 + Math.max(leftH, rightH);
    }
public boolean checkBalance(Dugum kok){
        int sonuc = isBalanced(kok);
        if(sonuc>0)
            return true;
        else
            return false;
    }          
   
    boolean isBSTUtil(Dugum node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.plaka < min || node.plaka > max) {
            return false;
        }

        return (isBSTUtil(node.sol, min, node.plaka - 1)
                && isBSTUtil(node.sag, node.plaka + 1, max));
    }
   
/* Dugum enKucuk(Dugum yeni){
        Dugum sayac= yeni;
            while (yeni!= null){
            if (yeni.plaka < sayac.plaka){
                sayac= yeni;
            }
            yeni= yeni.sol;
           
        }
            
        return sayac;
               
    }*/
}
