package RegularneVyrazy;

//1. úloha: Napíš metódu, ktorá bude akceptovať na vstupe String predstavujúci email. Metóda overí, či je email v správnom formáte. Metóda vráti true ak áno inak false.
//
//2. úloha: Napíš metódu, ktorá overí zložitosť zadaného hesla. Na vstupe metódy bude heslo. Metóda preverí či heslo spĺňa nasledovné kritéria:
//
//minimálne 8 znakov
//musí obsahovať aspoň jedno veľké písmeno
//musí obsahovať aspoň jedno číslo
//3. úloha: Napíš metódu, ktorá overí, či daný String je obrázok = koncovka je jedna z nasledujúcich: .jpg, .png, .jpeg, .bmp
//
//4. úloha: Napíš metódu, ktorá zistí, či daný String má správny tvar dátumu. Uvažuj, že správny tvar je nasledujúci: dd/mm/yyyy. Kde dd je den vo formáte 01 pre prvý deň. Kde mm je mesiac vo formáte 02 pre február. Kde yyyy je rok vo formáte 2018.
//
//5. úloha: Napíš metódu, ktorá pomocou regulárneho výrazu vypíše na konzolu všetky slová začínajúce na veľké písmeno.
//
//6. úloha: Napíš metódu, ktorá pomocou regulárneho výrazu nájde všetky čísla v texte a vypíše ich na konzolu.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegVyrazy {

    public static boolean zhodujeSa(String regex, String s) {

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        return m.matches();
    }


    public static void ulohaJedna(String email) {
        ///
        String regex = "\\w+@\\w+\\.\\D{2,3}";
        System.out.println(email.matches(regex));

    }

    public static void ulohaDva(String heslo){
        int a = 0;
        Pattern pattern = Pattern.compile("\\w{8,}");
        Pattern pattern1 = Pattern.compile("\\d+");
        Pattern pattern2 = Pattern.compile("[A-Z]+");

        Matcher m3 = pattern.matcher(heslo);
        if (!m3.find()){
            a++;
            System.out.println("Heslo je prilis kratke");
        }else {
            Matcher m2 = pattern1.matcher(heslo);
                if (!m2.find()){
                    a++;
                    System.out.println("Heslo neobsahuje cislicu");
                }
        }
        Matcher m1 = pattern2.matcher(heslo);
        if (!m1.find()){
            a++;
            System.out.println("Heslo neobsahuje velke pismeno ");
        }else {
            if (a == 0){
                System.out.println("Heslo je v poriadku");
            }
        }

    }

    public static void ulohatri(String obrazok){
        Pattern pattern = Pattern.compile("\\.jpg");
        Pattern pattern1 = Pattern.compile("\\.png");
        Pattern pattern2 = Pattern.compile("\\.jpeg");
        Pattern pattern3 = Pattern.compile("\\.bmp");
        Matcher matcher = pattern.matcher(obrazok);


        if (!matcher.find()){
            Matcher matcher1 = pattern1.matcher(obrazok);
            if (!matcher1.find()){
                Matcher matcher2 = pattern2.matcher(obrazok);
                if (!matcher2.find()) {
                    Matcher matcher3 = pattern3.matcher(obrazok);
                    if (!matcher3.find()){
                        System.out.println("Nie je tam ziaden obrazok");
                    }else {
                        System.out.println("Obrazok bmp");
                    }
                } else {
                    System.out.println("Obrazok jpeg");
                }
            } else {
                System.out.println("obrazok png");
            }
        } else {
            System.out.println("Obrazok jpg");
        }
    }

    public static void ulohatridva(){
        System.out.println(zhodujeSa("^\\w+\\.(jpg|png|jpeg|bmp)$" , "skuska.bmp"));
    }

    //4. úloha: Napíš metódu, ktorá zistí, či daný String má správny tvar dátumu.
    // Uvažuj, že správny tvar je nasledujúci: dd/mm/yyyy. Kde dd je den vo formáte
    // 01 pre prvý deň. Kde mm je mesiac vo formáte 02 pre február. Kde yyyy je rok vo formáte 2018.
    ////

    public static void ulohaStyri(){
        System.out.println(zhodujeSa("([0-2][1-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}" , "26/02/1992"));
    }

    public static void ulohaStyridva(String datum){

        Pattern den = Pattern.compile("([0-2][1-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}");
        Matcher matcher = den.matcher(datum);
        System.out.println(datum.matches(String.valueOf(den)));

    }

    //úloha: Napíš metódu, ktorá pomocou regulárneho výrazu
    // vypíše na konzolu všetky slová začínajúce na veľké písmeno.

    public static void ulohaPat(String slova){
        Pattern pattern = Pattern.compile("\\b[A-Z]\\w+\\b");
        Matcher matcher = pattern.matcher(slova);
        while (matcher.find()) {
            System.out.println(matcher.group());

        }
    }

    //úloha: Napíš metódu, ktorá pomocou regulárneho výrazu nájde všetky čísla v texte a vypíše ich na konzolu.

    public static void ulohaSest(String cisla){

        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(cisla);

        while (matcher.find()){
            System.out.printf(matcher.group());
        }

    }

    public static void main(String[] args) {
        ulohaJedna("pacholskyj@gmail.com");
        ulohaDva("Jurajko10");
        ulohatri("skuska");
        ulohatridva();
        ulohaStyri();
        ulohaStyridva("32/12/2020");
        ulohaPat("Ahoj ako sa mas Ja dobre");
        ulohaSest("Ahoj vol4m s1 p3t3r");


    }
}
