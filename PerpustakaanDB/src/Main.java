import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
BukuDAO dao = new BukuDAO();

System.out.println("1. Tambah Buku");
System.out.println("2. Tampilkan Buku");
System.out.print("Pilih: ");
int pilih = input.nextInt();
input.nextLine();

if (pilih == 1) {
System.out.print("Judul: ");
String j = input.nextLine();
System.out.print("Penulis: ");
String p = input.nextLine();
System.out.print("Tahun: ");
int t = input.nextInt();

dao.tambahBuku(new Buku(j, p, t));
} else {
dao.tampilkanBuku();
}

input.close();
}
}