public class Kolizja {

    int ktoryPoziom;
    boolean czyKolizja=false;
    Kolizja (int ktoryPoziom) {
        this.ktoryPoziom = ktoryPoziom;
    }

    public boolean kolizjaDol() {

        if (ktoryPoziom ==1) {
            //jesli falsz to pojdzie w dol
            czyKolizja = Postac.y > 498
                    || ((Postac.y == 360) & (Postac.x >= 0 & Postac.x < 200))
                    || ((Postac.y == 60) & (Postac.x >= 0 & Postac.x < 200))
                    || ((Postac.y == 208) & (Postac.x >= 256 & Postac.x < 480))
                    || ((Postac.y == 308) & (Postac.x >= 530 & Postac.x < 780))
                    || ((Postac.y == 108) & (Postac.x >= 720 & Postac.x <= 888));

        }
        return czyKolizja;
    }
}
