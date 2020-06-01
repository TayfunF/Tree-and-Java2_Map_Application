package agac;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
public class main extends Applet implements Runnable, MouseMotionListener {

    private Image resim;
    Agac data = new Agac();
    Dugum tmp;
    Dugum ankara = new Dugum(6, "Ankara", 340, 180);
    Dugum istanbul = new Dugum(34, "İstanbul", 155, 115);
    Dugum izmir = new Dugum(35, "İzmir", 60, 280);
    Dugum elazig = new Dugum(23, "Elazığ", 700, 230);
    Dugum artvin=new Dugum(8,"Artvin",825,100);
    Dugum bursa=new Dugum(16,"Bursa",165,165);
    Dugum malatya=new Dugum(44, "Malatya", 645,260);
    
       
    public void init() {
        this.setSize(1050, 500);
        data.ekle(ankara);
        data.ekle(istanbul);
        data.ekle(izmir);
        data.ekle(elazig);
        data.ekle(artvin);
        data.ekle(bursa);
        data.ekle(malatya);
           
        resim = getImage(getClass().getResource(""), "harita.png");
        
        Dugum sayac= tmp;
            while (tmp!= null){
            if (tmp.plaka < sayac.plaka){
                sayac= tmp;
            }
            tmp= tmp.sol;
           
        }
            
       
        } 
    
    public void paint(Graphics g) {
        g.drawImage(resim, 0, 0, this);
        for (int i = 0; i <= 81; i++) {
            tmp = data.ara(i);
            if (tmp != null) {
                cityDraw(g, tmp);
            }
        }
    }   
    
     

    public void cityDraw(Graphics g, Dugum yeni) {
        if (yeni.plaka / 10 == 0) {
            g.drawString(yeni.sehir + ", 0" + yeni.plaka, (int) yeni.enlem, (int) yeni.boylam);
        } else {
            g.drawString(yeni.sehir + ", " + yeni.plaka, (int) yeni.enlem, (int) yeni.boylam);
        }
        g.drawString(yeni.enlem + ", " + yeni.boylam, (int) yeni.enlem, (int) yeni.boylam + 15);
    }  
         
        
    @Override
    public void run() {
        while (true) {
           // System.out.println(mouseX+", "+mouseY);

            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {

            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       
    }
     
      
   

}





