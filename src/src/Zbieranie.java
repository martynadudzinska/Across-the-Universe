public class Zbieranie {

    int ktoryPoziom;
    int zetkniecie;
    Zbieranie (int ktoryPoziom) {
       this.ktoryPoziom = ktoryPoziom;
       zetkniecie = 0;
    }

    public int zbieranie() {
        if (ktoryPoziom==1){ //1-ananas 2-majonez 3-lizak 4-pizza 5-zupa

            if (Postac.y ==360 & (Postac.x<=40 & Postac.x >=0) & Poziom1.ananasWidoczny ) {
                zetkniecie =1;
               // System.out.println("ananas");
            } else if (Postac.y == 208 & (Postac.x<=368 & Postac.x >=276) & Poziom1.majonezWidoczny) {
                zetkniecie =2;
               // System.out.println("majonez");
            } else if (Postac.y == 60 & (Postac.x<=56 & Postac.x >=0) & Poziom1.lizakWidoczny ) {
                zetkniecie =3;
               // System.out.println("lizak");
            } else if (Postac.y == 308 & (Postac.x<=700 & Postac.x >=620) & Poziom1.pizzaWidoczna) {
                zetkniecie =4;
                //System.out.println("pizza");
            } else if (Postac.y == 108 & (Postac.x<=844 & Postac.x >=732) & Poziom1.zupaWidoczna) {
                zetkniecie =5;
                //System.out.println("zupa");
            }
            else zetkniecie = 0;
        }
        return zetkniecie;
    }
}
