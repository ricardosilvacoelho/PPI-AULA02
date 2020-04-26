import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaisDAO {

	public int incluir(Pais pais) {
		String sqlInsert = "INSERT INTO pais(id, nome, populacao,area) VALUES (?, ?, ?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, pais.getId());
			stm.setString(2, pais.getNome());
			stm.setLong(3, pais.getPopulacao());
			stm.setDouble(4, pais.getArea());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pais.getId();
	}

	public void atualizar(Pais pais) {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		// usando o try with resources do Java 7, quefecha o queabriu
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.setInt(4, pais.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Pais pais) {
			String sqlDelete = "DELETE FROM pais WHERE id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.conectar();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, pais.getId());
			stm.execute();
			} catch (Exception e) {
			e.printStackTrace();
			}
			}

	public Pais carregar(int id) {
			Pais pais = new Pais();
			String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.conectar();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
			pais.setNome(rs.getString("nome"));
			pais.setPopulacao(rs.getLong("populacao"));
			pais.setArea(rs.getDouble("area"));
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
			} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
			}
			return pais;
			}

}