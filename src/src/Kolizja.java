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

        } else if (ktoryPoziom==2) {
            czyKolizjaDol = Postac.y > 498
                    || ((Postac.y == 356) & (Postac.x >= 284 & Postac.x < 524))
                    || ((Postac.y == 84) & (Postac.x >= 232 & Postac.x < 476))
                    || ((Postac.y == 208) & (Postac.x >= 0 & Postac.x <= 200))
                    || ((Postac.y == 296) & (Postac.x >= 732 & Postac.x < 896))
                    || ((Postac.y == 164) & (Postac.x >= 552 & Postac.x <= 764));
        }
        else if (ktoryPoziom==3) {
            czyKolizjaDol = Postac.y > 498
                    || ((Postac.y == 224) & (Postac.x >= 188 & Postac.x < 404))
                    || ((Postac.y == 96) & (Postac.x >= 0 & Postac.x < 176))
                    || ((Postac.y == 356) & (Postac.x >= 540 & Postac.x <= 764))
                    || ((Postac.y == 204) & (Postac.x >= 736 & Postac.x < 892))
                    || ((Postac.y == 76) & (Postac.x >= 444 & Postac.x <= 676));
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

        }else if (ktoryPoziom==2) {
            czyKolizjaGora = ((Postac.y == 460) & (Postac.x >= 284 & Postac.x < 524))
                    || ((Postac.y == 188) & (Postac.x >= 232 & Postac.x < 476))
                    || ((Postac.y == 304) & (Postac.x >= 0 & Postac.x <= 200))
                    || ((Postac.y == 392) & (Postac.x >= 732 & Postac.x < 896))
                    || ((Postac.y == 260) & (Postac.x >= 552 & Postac.x <= 764));
        }
        else if (ktoryPoziom==3) {
            czyKolizjaGora =
                     ((Postac.y == 344) & (Postac.x >= 188 & Postac.x < 404))
                    || ((Postac.y == 216) & (Postac.x >= 0 & Postac.x < 176))
                    || ((Postac.y == 464) & (Postac.x >= 540 & Postac.x <= 764))
                    || ((Postac.y == 316) & (Postac.x >= 728 & Postac.x < 892))
                    || ((Postac.y == 196) & (Postac.x >= 444 & Postac.x <= 676));
        }
        return czyKolizjaGora;
    }

}
