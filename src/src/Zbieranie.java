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
            } else if (Postac.y == 208 & (Postac.x<=368 & Postac.x >=276) & Poziom1.majonezWidoczny) {
                zetkniecie =2;
            } else if (Postac.y == 60 & (Postac.x<=56 & Postac.x >=0) & Poziom1.lizakWidoczny ) {
                zetkniecie =3;
            } else if (Postac.y == 308 & (Postac.x<=700 & Postac.x >=620) & Poziom1.pizzaWidoczna) {
                zetkniecie =4;
            } else if (Postac.y == 108 & (Postac.x<=844 & Postac.x >=732) & Poziom1.zupaWidoczna) {
                zetkniecie =5;
            }
            else zetkniecie = 0;
        } else if (ktoryPoziom ==2){ //1-slimak 2-meduza 3-konik 4-papuga 5-malpa
            if (Postac.y ==84 & (Postac.x<=380 & Postac.x >=300) & Poziom2.slimakWidoczny ) {
                zetkniecie =1;
            } else if (Postac.y == 356 & (Postac.x<=412 & Postac.x >=360) & Poziom2.meduzaWidoczna) {
                zetkniecie =2;
            } else if (Postac.y == 208 & (Postac.x<=92 & Postac.x >=16) & Poziom2.konikMorskiWidoczny ) {
                zetkniecie =3;
            } else if (Postac.y == 164 & (Postac.x<=716 & Postac.x >=656) & Poziom2.papugaWidoczna) {
                zetkniecie =4;
            } else if (Postac.y == 296 & (Postac.x<=888 & Postac.x >=808) & Poziom2.malpaWidoczna) {
                zetkniecie =5;
            }
            else zetkniecie = 0;
        }
        else if (ktoryPoziom ==3) { //1-banknot 2-olowek 3-okulary 4-prezent 5-gitara
            if (Postac.y == 76 & (Postac.x <= 580 & Postac.x >= 504) & Poziom3.banknotWidoczny) {
                zetkniecie = 1;
            } else if (Postac.y == 224 & (Postac.x <= 320 & Postac.x >= 252) & Poziom3.olowekWidoczny) {
                zetkniecie = 2;
            } else if (Postac.y == 356 & (Postac.x <= 696 & Postac.x >= 640) & Poziom3.okularyWidoczne) {
                zetkniecie = 3;
            } else if (Postac.y == 96 & (Postac.x <= 60 & Postac.x >= 0) & Poziom3.prezentWidocznu) {
                zetkniecie = 4;
            } else if (Postac.y == 204 & (Postac.x <= 888 & Postac.x >= 804) & Poziom3.gitaraWidoczna) {
                zetkniecie = 5;
            } else zetkniecie = 0;
        }
        return zetkniecie;
    }
}
