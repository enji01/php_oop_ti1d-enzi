import java.sql.*;

public class BukuDAO {

public void tambahBuku(Buku b) {
String sql = "INSERT INTO buku (judul, penulis, tahun) VALUES (?, ?, ?)";

try (Connection c = DBConnection.getConnection();
PreparedStatement ps = c.prepareStatement(sql)) {

ps.setString(1, b.judul);
ps.setString(2, b.penulis);
ps.setInt(3, b.tahun);
ps.executeUpdate();

System.out.println("Buku berhasil disimpan ke database.");

} catch (Exception e) {
e.printStackTrace();
}
}

public void tampilkanBuku() {
String sql = "SELECT * FROM buku";

try (Connection c = DBConnection.getConnection();
Statement s = c.createStatement();
ResultSet r = s.executeQuery(sql)) {

System.out.println("=== DAFTAR BUKU ===");
while (r.next()) {
System.out.println(
r.getInt("id") + " | " +

r.getString("judul") + " | " +
r.getString("penulis") + " | " +
r.getInt("tahun")
);
}

} catch (Exception e) {
e.printStackTrace();
}
}
}