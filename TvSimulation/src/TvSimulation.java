import java.util.ArrayList;
import java.util.Scanner;

public class TvSimulation {
    static Scanner tara=new Scanner(System.in);
    static Televizyon tv;
    public static void main(String[] args) {
        menuGoster();
        boolean cikis=false;
        while (!cikis) {
            System.out.println("Seciminizi yapiniz(menuyu gormek icin 8 e basınız)");
            int secim=tara.nextInt();
            switch (secim) {
                case 1:
                    tvKurveKanallariOlustur();
                    break;
                case 2:
                    tvAc();
                    break;
                case 3:
                    sesArttir();
                    break;
                case 4:
                    sesAzalt();
                    break;
                case 5:
                    kanalDegistir();
                    break;
                case 6:
                    kanalGoster();
                    break;
                case 7:
                    tvKapat();
                    break;
                case 8:
                    menuGoster();
                    break;
                case 0:
                    System.out.println("Çıkıs yapılıyor");
                    cikis=true;
                    break;
                default:
                    System.out.println("0 ve 8 arasında bir sayi giriniz");
                    break;
            }

        }
    }

    private static void kanalGoster() {
        if (tv==null) {
            System.out.println("Oncelikle tv ve kanallari kurmaniz gerekiyor");
        }else {
            tv.KanalGoster();

        }
    }

    private static void kanalDegistir() {
        if (tv==null) {
            System.out.println("Oncelikle tv ve kanallari kurmaniz gerekiyor");
        }else {
            System.out.println("Gitmek istediginiz kanali giriniz");
            int secim=tara.nextInt();
            tv.kanalDegistir(secim);
        }

    }

    private static void sesAzalt() {
        if (tv==null) {
            System.out.println("Oncelikle tv ve kanallari kurmaniz gerekiyor");
        }else {
            tv.sesAzalt();
        }
    }

    private static void sesArttir() {
        if (tv==null) {
            System.out.println("Oncelikle tv ve kanallari kurmaniz gerekiyor");
        }else {
            tv.sesArttir();
        }

    }

    private static void tvKapat() {
        if (tv==null) {
            System.out.println("Oncelikle tv ve kanallari kurmaniz gerekiyor");
        }else {
            tv.tvKapat();
        }
    }

    private static void tvAc() {
        if (tv==null) {
            System.out.println("Oncelikle tv ve kanallari kurmaniz gerekiyor");
        }else {
            tv.tvAc();
        }
    }

    private static void tvKurveKanallariOlustur() {
        if (tv==null){
            tara.nextLine();
            System.out.println("Televizyonun markasini giriniz");
            String marka=tara.nextLine();
            System.out.println("Televizyonun boyutunu giriniz");
            String boyut=tara.nextLine();
            tv=new Televizyon(marka,boyut);
            System.out.println(tv);
        }else {
            System.out.println(tv);
        }


    }

    private static void menuGoster() {
        System.out.println("**********MENU*********");
        System.out.println("0--Çıkış\n" +
                "1--Televizyonu Kur\n" +
                "2--Televizyonu Aç\n" +
                "3--Sesini Arttir\n" +
                "4--Sesini Azalt\n" +
                "5--Kanal Degistir\n" +
                "6--Kanal Bilgisini Goster\n" +
                "7--Televizyonu Kapat\n" +
                "8--Menuyu tekrar goster\n");
    }
}
class Televizyon{
    private String marka;
    private String boyut;
    private ArrayList<Kanal> kanallar;
    private boolean acik;
    private int ses;
    private int aktifKanal;

    public Televizyon(String marka, String boyut) {
        this.marka = marka;
        this.boyut = boyut;
        kanallar=new ArrayList<>();
        kanalOlustur();
        aktifKanal=1;
        ses=10;
        this.acik=false;
    }
    public void tvAc() {
        if (acik==false) {
            System.out.println("Tv acildi");
            acik=true;
        }else {
            System.out.println("Tv zaten acik");
        }
    }
    public void tvKapat() {
        if (acik!=false) {
            System.out.println("Tv kapaniyor");
            acik=false;
        }else {
            System.out.println("Tv zaten kapalı");
        }
    }
    public void KanalGoster() {
        if(acik) {
            System.out.println("Aktif Kanal " +kanallar.get(aktifKanal-1).yazdir());

        }else {
            System.out.println("Tv acmaniz gerekiyor");
        }
    }
    public void kanalDegistir(int acilmakIstenen) {
        if (acik){
            if(acilmakIstenen!=aktifKanal) {
                if (acilmakIstenen<kanallar.size()&&acilmakIstenen>=0) {
                    aktifKanal=acilmakIstenen;
                    System.out.println("Kanal " +acilmakIstenen+" Bilgi " +kanallar.get(acilmakIstenen-1).yazdir());

                }else {
                    System.out.println("Gecerli bir kanal numarisi giriniz");
                }

            }else {
                System.out.println("Zaten " +aktifKanal + " .kanaldasiniz");
            }

        }else {
            System.out.println("Tv acmaniz gerekiyor");
        }
    }
    public void sesArttir() {
        if (acik){
            if (ses<20) {
                ses++;
                System.out.println("Ses Seviyesi " +ses);
            }else {
                System.out.println("Ses maksimum düzeyde daha fazla arttirilamaz");
            }
        }else {
            System.out.println("Tv kapali once TV yi acin");
        }
    }
    public void sesAzalt() {
        if (acik){
            if (ses>0) {
                ses--;
                System.out.println("Ses Seviyesi " +ses);
            }else {
                System.out.println("Ses minimum düzeyde daha fazla azaltilamaz");
            }
        }else {
            System.out.println("Tv kapali once TV yi acin");
        }
    }


    private void kanalOlustur() {
        HaberKanali bloom=new HaberKanali("Bloomberg",1,"İş Haber");
        kanallar.add(bloom);
        HaberKanali cnn=new HaberKanali("CNN",2,"Genel Haber");
        kanallar.add(cnn);
        HaberKanali bein=new HaberKanali("BeinSports",3,"Spor Haber");
        kanallar.add(bein);
        MuzikKanali power=new MuzikKanali("Power",4,"Pop");
        kanallar.add(power);
        MuzikKanali numberOne=new MuzikKanali("Number1",5,"R&B");
        kanallar.add(numberOne);

    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    @Override
    public String toString() {
        return "Televizyon{" +
                "marka='" + marka + '\'' +
                ", boyut='" + boyut + '\'' +
                '}';
    }
}
class Kanal{
    private String kanalAdi;
    private int kanalNo;

    public Kanal(String kanalAdi, int kanalNo) {
        this.kanalAdi = kanalAdi;
        this.kanalNo = kanalNo;
    }

    public String getKanalAdi() {
        return kanalAdi;
    }

    public void setKanalAdi(String kanalAdi) {
        this.kanalAdi = kanalAdi;
    }

    public int getKanalNo() {
        return kanalNo;
    }

    public void setKanalNo(int kanalNo) {
        this.kanalNo = kanalNo;
    }
    public String yazdir(){
        return "Kanal Adi " +kanalAdi+" No " +kanalNo;

    }
}
class HaberKanali extends Kanal{
    private String turu;
    public HaberKanali(String kanalAdi, int kanalNo,String turu) {
        super(kanalAdi, kanalNo);
        this.turu=turu;
    }
}
class MuzikKanali extends Kanal{
    private String Muzikturu;

    public MuzikKanali(String kanalAdi, int kanalNo, String muzikturu) {
        super(kanalAdi, kanalNo);
        Muzikturu = muzikturu;
    }
}


