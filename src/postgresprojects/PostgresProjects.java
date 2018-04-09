package postgresprojects;

import java.util.Scanner;

public class PostgresProjects {
    public static void main(String[] args) {
        
        String connectionURL = "jdbc:postgresql://localhost:5433/person";
        String userName = "postgres";
        String passWord = "root";
        
        PostgresSqlDatabase databaseOperation = new PostgresSqlDatabase(connectionURL, userName, passWord);
        Company databaseCompany = new Company();
        
        String deger = "";
        do{
            System.out.println("Yapmak istediğiniz işlemi seçiniz: ");
            System.out.println("1- Verileri Listele");
            System.out.println("2- Yeni Veri Ekle");
            System.out.println("3- Var Olan Veriyi Güncelle");
            System.out.println("4- Var Olan Veriyi Sil");
            Scanner tarayici = new Scanner(System.in);
            
            deger = tarayici.nextLine();
            if("1".equals(deger)){
                databaseOperation.databaseSelect();
            }
            if("2".equals(deger)){
                Scanner _scanner = new Scanner(System.in);
                System.out.println("Kullanıcının Adını giriniz: ");
                databaseCompany.setName(_scanner.next());
                System.out.println("Kullanıcının yaşını giriniz: ");
                databaseCompany.setAge(_scanner.nextInt());
                System.out.println("Kullanıcının şehrini giriniz: ");
                databaseCompany.setAddress(_scanner.next());
                System.out.println("Kullanıcının Maaşını giriniz: ");
                databaseCompany.setSalary(_scanner.nextInt());
                databaseOperation.insertData();
            }
            if("3".equals(deger)){
                System.out.println("Günceleyebileceğiniz değerler aşağıda yer aldığı gibidir. Öncelikle listelenen kullanıcılardan hangisinde değişiklik yapacak iseniz o kullanıcnın id değerini girdikten sonra, güncellemek istediğiniz değerin numarasını girmeniz yeterlidir: ");
                databaseOperation.databaseSelect();
                System.out.println("Güncellemek istediğiniz kullanıcının id değerini giriniz: ");
                databaseCompany.setId(tarayici.nextInt());
                databaseOperation.getIdData();
                do{
                    System.out.println("1- Kullanıcının Adı");
                    System.out.println("2- Kullanıcının Yaşı");
                    System.out.println("3- Kullanıcının Şehri");
                    System.out.println("4- Kullanıcının Maaşı");
                    System.out.println("Güncellemek yapmak için 6, çıkmak için 7 değerini giriniz:");
                    deger = tarayici.next();
                    if("6".equals(deger)){
                        System.out.println("Güncellemek istediğiniz değerin numarasını giriniz: ");
                        deger = tarayici.next();
                        if("1".equals(deger)){
                            System.out.println("Kullanıcının Adını Giriniz: ");
                            databaseCompany.setName(tarayici.next());
                        }
                        if("2".equals(deger)){
                            System.out.println("Kullanıcının Yaşını Giriniz: ");
                            databaseCompany.setAge(tarayici.nextInt());
                        }
                        if("3".equals(deger)){
                            System.out.println("Kullanıcının Şehrini Giriniz: ");
                            databaseCompany.setAddress(tarayici.next());
                        }
                        if("4".equals(deger)){
                            System.out.println("Kullanıcının Maaşını Giriniz: ");
                            databaseCompany.setSalary(tarayici.nextInt());
                        }
                        databaseOperation.updateTable(databaseCompany.getId());
                    }
                }while(!"7".equals(deger));
            }
            if("4".equals(deger)){
                databaseOperation.databaseSelect();
                Scanner tarayicim = new Scanner(System.in);
                System.out.println("Silmek istediğiniz kullanıcnın id değerini giriniz: ");
                databaseCompany.setId(tarayicim.nextInt());
                databaseOperation.deleteDataTable();
            }
            if(!"1".equals(deger)){
                databaseOperation.databaseSelect();   
            }
            
            //System.out.print("Çıkmak istemiyorsanız herhangi bir tuşa basını yoksa Çıkmak için 5'e basınız: ");
            deger = tarayici.nextLine();
        }while(!"5".equals(deger));
        System.out.print("İşlem döngüsünden çıkıldı.");
    }
}