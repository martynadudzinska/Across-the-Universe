public class Kolizja {

    int ktoryPoziom;

    boolean czyKolizjaDol=false;
    boolean czyKolizjaGora=false;

    Kolizja (int ktoryPoziom) {
        this.ktoryPoziom = ktoryPoziom;
    }

    public boolean kolizjaDol() {

        if (ktoryPoziom ==1) {
            //jesli falsz to pojdzie w dol
            czyKolizjaDol = Postac.y > 498
                    || ((Postac.y == 360) & (Postac.x >= 0 & Postac.x < 188))
                    || ((Postac.y == 60) & (Postac.x >= 0 & Postac.x < 200))
                    || ((Postac.y == 208) & (Postac.x >= 248 & Postac.x <= 480))
                    || ((Postac.y == 308) & (Postac.x >= 530 & Postac.x < 780))
                    || ((Postac.y == 108) & (Postac.x >= 720 & Postac.x <= 888));

        }
        return czyKolizjaDol;
    }

    public boolean kolizjaGora() {

        if (ktoryPoziom ==1) {
            //jesli falsz to pojdzie w gore
            czyKolizjaGora =
                     ((Postac.y == 460) & (Postac.x >= 0 & Postac.x <= 200))
                    || ((Postac.y == 156) & (Postac.x >= 0 & Postac.x <= 200))
                    || ((Postac.y <= 304 & Postac.y >=280) & (Postac.x >= 248 & Postac.x <= 484)) //zwiekszyc zakres
                    || ((Postac.y == 416) & (Postac.x >= 530 & Postac.x <= 780))
                    || ((Postac.y == 216) & (Postac.x >= 720 & Postac.x <= 888));

        }
        return czyKolizjaGora;
    }

}
