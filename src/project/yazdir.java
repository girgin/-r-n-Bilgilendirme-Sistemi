/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Caglar
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class yazdir {

    public static void main(String[] args) {

        int[][] ratings = new int[100][100];
        String[] EkSplit = new String[100];
        String[] split;
        String[] splitHeader;
        int[] ToplamMutlak=new int[100];
        int posisyon = 0;
        int deger = 0;
        int secim;
        
        int puan = 0;
        int[] GirilenPuan=new int[100];
        int[][] MutlakFark=new int[100][100];
        String tip;
      
        Scanner al = new Scanner(System.in);
        Customer[] customers = new Customer[200];

        fonksiyonlar f = new fonksiyonlar();

        int urunCount = 0, customerCount = 0;

        Scanner fileIn = null;  // Initializes fileIn to an empty object

        try {
            // Attempt to open the file
            fileIn = new Scanner(new FileInputStream("Firma.txt"));
            fileIn.useDelimiter(",|" + System.getProperty("line.separator"));
        } catch (FileNotFoundException e) {
            // If the file could not be found, this code is executed
            // and then the program exits
            System.out.println("File not found.");
            System.exit(0);
        }

        splitHeader = fileIn.nextLine().split(",");

        urunCount = Integer.parseInt(splitHeader[0]);

        while (fileIn.hasNextLine()) {

            split = fileIn.nextLine().split(",");

            if (split[0].equals("n")) {
                customers[customerCount] = new NationalCustomer(Integer.parseInt(
                        split[1]), split[2], split[3], Integer.parseInt(split[4]), split[5]);
                customerCount++;

            } else if (split[0].equals("i")) {
                customers[customerCount] = new InternationalCustomer(Integer.parseInt(
                        split[1]), split[2], split[3], split[4], split[5]);
                customerCount++;

            } else {
                for (int i = 0; i < urunCount; i++) {
                    ratings[customerCount - 1][i] = Integer.parseInt(split[i]);

                }

            }

        }
        fileIn.close();

        do {

            do {
                posisyon = 0;
                deger = f.menu();
                if (deger == 8) {
                    return;
                }
                if (deger < 1 || deger > 7) {
                    System.out.println("Yanlis bir deger girdiniz.Tekrar deneyiniz.(0,7)arsinda deger giriniz.");
                    posisyon = 1;
                }

            } while (posisyon != 0);

            switch (deger) {
                case 1: {
                    f.ToplamDerecele(customerCount, ratings, splitHeader);
                    System.out.println("\n");
                }
                break;
                case 2: {
                    f.ToplamNational(customers, customerCount, ratings, splitHeader);
                    System.out.println("\n");
                }
                break;
                case 3: {
                    f.ToplamInternational(customers, customerCount, ratings, splitHeader);
                    System.out.println("\n");
                }
                break;
                case 4: {
                    f.DoctorNational(customers, customerCount, ratings, splitHeader);
                    System.out.println("\n");

                }
                break;
                case 5: {
                    f.Nationalortalamaalti(customers, customerCount, ratings, splitHeader);
                    System.out.println("\n");

                }
                break;
                case 6: {
                    f.Internationaltoplam(customers, customerCount, ratings, splitHeader);
                    System.out.println("\n");
                }
                break;
                case 7: {

                    System.out.println("Customer tipini giriniz:(n/i)");
                    tip = al.next();

                    if (tip.equals("n")) {
                        System.out.println("ID");
                        EkSplit[0] = al.next();
                        System.out.println("AD");
                        EkSplit[1] = al.next();
                        System.out.println("soyad");
                        EkSplit[2] = al.next();
                        System.out.println("Plaka");
                        EkSplit[3] = al.next();
                        System.out.println("Meslek");
                        EkSplit[4] = al.next();
                        customers[customerCount] = new NationalCustomer(Integer.parseInt(
                                EkSplit[0]), EkSplit[1], EkSplit[2], Integer.parseInt(EkSplit[3]), EkSplit[4]);
                        System.out.println(customers[customerCount]);
                        
                       for (int i = 0; i <urunCount-1; i++) {
                            
                            System.out.print(splitHeader[i+1] + " verdiginiz puanlari giriniz.");

                          GirilenPuan[i]= al.nextInt();
                          
                         }
                        
                        for (int i = 0; i <urunCount-1; i++)
                        {
                        for(int m=0;m<customerCount;m++)
                        {
                           MutlakFark[m][i]=ratings[m][i]-GirilenPuan[i];
                           
                        }
                        
                        }
                        
                        for (int i = 0; i <customerCount; i++)
                        {
                        for(int m=0;m<urunCount-1;m++)
                        {
                            ToplamMutlak[i]=MutlakFark[i][m]+ToplamMutlak[i];
                        }
                           
                        }
                        
                        int min;
                        int say=0;
                        int toplam=0;
                        min=ToplamMutlak[0];
                         for(int i=1;i<ToplamMutlak.length;i++)
                         {
                             
                             if(min>=ToplamMutlak[i])
                             {
                             min=ToplamMutlak[i];
                             
                             }
                         
                         }
                         
                          for(int i=0;i<ToplamMutlak.length;i++)
                         {
                           if(ToplamMutlak[i]==min)
                           {
                            toplam+=ratings[i][urunCount-1];
                            say++;
                           }
                         }
                         
                         GirilenPuan[urunCount-1]=toplam/say;
                         
                        
                         
                         for (int i = 0; i <urunCount; i++)
                        {
                       
                            ratings[customerCount][i]=GirilenPuan[i];
                            
                        }
                     
                       
                          System.out.println(customers[customerCount]);
                          customerCount++;
                          f.ToplamDerecele(customerCount, ratings, splitHeader);
                           
                          
                        
                 
                     
                    
                        
                        
                    } else if (tip.equals("i")) {

                        System.out.println("ID");
                        EkSplit[0] = al.next();
                        System.out.println("AD");
                        EkSplit[1] = al.next();
                        System.out.println("soyad");
                        EkSplit[2] = al.next();
                        System.out.println("Ulke");
                        EkSplit[3] = al.next();
                        System.out.println("Sehir");
                        EkSplit[4] = al.next();

                        customers[customerCount] = new InternationalCustomer(Integer.parseInt(
                                EkSplit[0]), EkSplit[1], EkSplit[2], EkSplit[3], EkSplit[4]);
                    
                         
                        for (int i = 0; i <urunCount-1; i++) {
                            
                            System.out.print(splitHeader[i+1] + " verdiginiz puanlari giriniz.");

                          GirilenPuan[i]= al.nextInt();
                          
                         }
                        
                        for (int i = 0; i <urunCount-1; i++)
                        {
                        for(int m=0;m<customerCount;m++)
                        {
                           MutlakFark[m][i]=ratings[m][i]-GirilenPuan[i];
                           
                        }
                        
                        }
                        
                        for (int i = 0; i <customerCount; i++)
                        {
                        for(int m=0;m<urunCount-1;m++)
                        {
                            ToplamMutlak[i]=MutlakFark[i][m]+ToplamMutlak[i];
                        }
                           
                        }
                        
                        int min;
                        int say=0;
                        int toplam=0;
                        min=ToplamMutlak[0];
                         for(int i=1;i<ToplamMutlak.length;i++)
                         {
                             
                             if(min>=ToplamMutlak[i])
                             {
                             min=ToplamMutlak[i];
                             
                             }
                         
                         }
                         
                          for(int i=0;i<ToplamMutlak.length;i++)
                         {
                           if(ToplamMutlak[i]==min)
                           {
                            toplam+=ratings[i][urunCount-1];
                            say++;
                           }
                         }
                         
                         GirilenPuan[urunCount-1]=toplam/say;
                         
                        
                         
                         for (int i = 0; i <urunCount; i++)
                        {
                       
                            ratings[customerCount][i]=GirilenPuan[i];
                            
                        }
                     
                       
                          System.out.println(customers[customerCount]);
                          customerCount++;
                          f.ToplamDerecele(customerCount, ratings, splitHeader);
                           
                          
                        
                 
                     
                    }  
                       

                           //buradan basla eleamnarı mutlak farkı al 
                   
                }
                break;

            }

            System.out.println("Baska islem yapmak istermisiniz.Evet(1)/Hayir(0)");
            secim = al.nextInt();

        } while (secim != 0);

    }

}
