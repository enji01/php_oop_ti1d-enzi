import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BukuAlamat buku = new BukuAlamat();

        for(int i = 1; i <= 3; i++) {

            System.out.println("\nInput Kontak ke-" + i);

            System.out.print("Nama   : ");
            String nama = input.nextLine();

            System.out.print("Telepon: ");
            String telepon = input.nextLine();

            System.out.print("Email  : ");
            String email = input.nextLine();

            Kontak k = new Kontak(nama, telepon, email);

            buku.tambahKontak(k);
        }

        buku.tampilkanKontak();

        input.close();
    }
}