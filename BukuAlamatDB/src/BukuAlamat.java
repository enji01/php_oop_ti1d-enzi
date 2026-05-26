import java.sql.*;

public class BukuAlamat {

    String url = "jdbc:mysql://localhost:3306/BukuAlamatDB";
    String user = "root";
    String password = "";

    public void tambahKontak(Kontak k) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO kontak (nama, telepon, email) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, k.nama);
            ps.setString(2, k.telepon);
            ps.setString(3, k.email);

            ps.executeUpdate();

            System.out.println("Kontak berhasil ditambahkan!");

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void tampilkanKontak() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM kontak");

            System.out.println("\nDaftar Kontak:");
            System.out.println("==============");

            while (rs.next()) {
                System.out.println("Nama   : " + rs.getString("nama"));
                System.out.println("Telepon: " + rs.getString("telepon"));
                System.out.println("Email  : " + rs.getString("email"));
                System.out.println("----------------------");
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}