/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;

/**
 *
 * @author sedat
 */
public class fonksiyonlar {

    public void ToplamDerecele(int musterisayisi, int[][] ratings, String[] splitHeader) {

        int[] toplamderece = new int[Integer.parseInt(splitHeader[0])];

        for (int i = 0; i < Integer.parseInt(splitHeader[0]); i++) {
            for (int m = 0; m < musterisayisi; m++) {
                toplamderece[i] = toplamderece[i] + ratings[m][i];
            }
        }
        for (int i = 0; i < Integer.parseInt(splitHeader[0]); i++) {
            System.out.print(splitHeader[i + 1] + ":");
            System.out.println((float) toplamderece[i] / musterisayisi);
        }

    }

    public void ToplamNational(Customer[] customers, int customerCount, int[][] ratings, String[] splitHeader) {

        int[] toplam = new int[Integer.parseInt(splitHeader[0])];
        float NationalSayisi = 0;
        int sayac = 0;
        for (int m = 0; m < Integer.parseInt(splitHeader[0]); m++) {
            for (int i = 0; i < customerCount; i++) {
                if (customers[i] instanceof NationalCustomer) {

                    toplam[m] = toplam[m] + ratings[i][m];
                    sayac++;
                }
            }
        }

        NationalSayisi = sayac / Integer.parseInt(splitHeader[0]);

        for (int i = 0; i < Integer.parseInt(splitHeader[0]); i++) {

            System.out.print(splitHeader[i + 1] + ":");
            System.out.println((float) toplam[i] / NationalSayisi);

        }

    }

    public void ToplamInternational(Customer[] customers, int customerCount, int[][] ratings, String[] splitHeader) {
        int[] toplam = new int[Integer.parseInt(splitHeader[0])];
        int InternationalSayisi = 0;
        int sayac = 0;
        for (int m = 0; m < Integer.parseInt(splitHeader[0]); m++) {
            for (int i = 0; i < customerCount; i++) {
                if (customers[i] instanceof InternationalCustomer) {
                    toplam[m] = toplam[m] + ratings[i][m];
                    sayac++;

                }
            }

        }
        InternationalSayisi = sayac / Integer.parseInt(splitHeader[0]);

        for (int i = 0; i < Integer.parseInt(splitHeader[0]); i++) {

            System.out.print(splitHeader[i + 1] + ":");
            System.out.println((float) toplam[i] / InternationalSayisi);

        }
    }

    public void DoctorNational(Customer[] customers, int customerCount, int[][] ratings, String[] splitHeader) {
        int[] toplam = new int[Integer.parseInt(splitHeader[0])];
        int sayac = 0;
        int DoktorSayisi = 0;
        for (int m = 0; m < Integer.parseInt(splitHeader[0]); m++) {
            for (int i = 0; i < customerCount; i++) {
                if (customers[i] instanceof NationalCustomer) {
                    if (((NationalCustomer) customers[i]).getOccupation().equals("Doktor")) {
                        toplam[m] = toplam[m] + ratings[i][m];
                        sayac++;
                    }
                }
            }

        }
        DoktorSayisi = sayac / Integer.parseInt(splitHeader[0]);

        for (int i = 0; i < Integer.parseInt(splitHeader[0]); i++) {

            System.out.print(splitHeader[i + 1] + ":");
            System.out.println((float) toplam[i] / DoktorSayisi);

        }

    }

    public void Nationalortalamaalti(Customer[] customers, int customerCount, int[][] ratings, String[] splitHeader) {
        float[] ortalama = new float[Integer.parseInt(splitHeader[0])];

        float[] toplamderece = new float[Integer.parseInt(splitHeader[0])];

        for (int i = 0; i < Integer.parseInt(splitHeader[0]); i++) {
            for (int m = 0; m < customerCount; m++) {
                toplamderece[i] = toplamderece[i] + ratings[m][i];
            }
        }

        for (int i = 0; i < Integer.parseInt(splitHeader[0]); i++) {
            ortalama[i] = (float) toplamderece[i] / customerCount;
        }

        for (int m = 0; m < Integer.parseInt(splitHeader[0]); m++) {
            System.out.println(splitHeader[m + 1] + " için ortalamanin altinda puan vermis national customerler.");
            for (int i = 0; i < customerCount; i++) {
                if (customers[i] instanceof NationalCustomer) {
                    if (ratings[i][m] < ortalama[m]) {

                        System.out.println(customers[i]);

                    }

                }

            }
            System.out.println(" ");

        }

    }

    public void Internationaltoplam(Customer[] customers, int customerCount, int[][] ratings, String[] splitHeader) {
        float[] ortalama = new float[Integer.parseInt(splitHeader[0])];

        float[] toplamderece = new float[Integer.parseInt(splitHeader[0])];

        for (int i = 0; i < Integer.parseInt(splitHeader[0]); i++) {
            for (int m = 0; m < customerCount; m++) {
                toplamderece[i] = toplamderece[i] + ratings[m][i];
            }
        }

        for (int i = 0; i < Integer.parseInt(splitHeader[0]); i++) {
            ortalama[i] = (float) toplamderece[i] / customerCount;
        }

        for (int m = 0; m < Integer.parseInt(splitHeader[0]); m++) {
            System.out.println(splitHeader[m + 1] + " için ortalamanin altinda puan vermis International customerlar.");
            for (int i = 0; i < customerCount; i++) {
                if (customers[i] instanceof InternationalCustomer) {
                    if (ratings[i][m] < ortalama[m]) {

                        System.out.println(customers[i]);

                    }

                }

            }
            System.out.println(" ");

        }

    }

   

    public int menu() {
        int secim2 = 0;
        Scanner secim = new Scanner(System.in);
        System.out.println("            MENU                 ");
        System.out.println("1.Her bir urun icin o urune ait ortalama derecelendirme puanini. ");
        System.out.println("2. Her bir urunn icin sadece ulusal musterileri dikkate alarak elde edilen ortalama derecelendirme puani.");
        System.out.println("3.Her bir urun icin sadece uluslararası müsterileri dikkate alarak elde edilen ortalama derecelendirme puani.");
        System.out.println("4.Her bir urun icin sadece ulusal musterilerden meslegi doktor olanlarrin ortalama derecelendirme puani");
        System.out.println("5. Her bir urun için, o urune ait ortalama derecelendirmenin altinda puan vermis olan ulusal musterilerin bilgileri.");
        System.out.println("6. Her bir urn icin, o urune ait ortalama derecelendirmenin altinda puan vermis olan uluslararasi musterilerin bilgileri. ");
        System.out.println("7.Yeni bir musteri ekleyip bu musterinin n-1 ci urune verdigi puaani hesaplayip ortalamayi yazdirma.");
        System.out.println("8.Cikis icin.");
        System.out.print("Secim yapiniz:");
        secim2 = secim.nextInt();

        return secim2;
    }

}
