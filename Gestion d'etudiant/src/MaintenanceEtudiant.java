import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class MaintenanceEtudiant {

    public void ajouterEtudiant(String nom, String prenom, int age, String filiere) {
        String sqlInsert = "INSERT INTO etudiants (nom, prenom, age, filiere) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionBD.connect();
             PreparedStatement insertStatement = connection.prepareStatement(sqlInsert)) {

            insertStatement.setString(1, nom);
            insertStatement.setString(2, prenom);
            insertStatement.setInt(3, age);
            insertStatement.setString(4, filiere);

            int rowsInserted = insertStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("L'étudiant a été ajouté avec succès !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'ajout de l'étudiant");
        }
    }

    public void afficherEtudiants() {
        String sql = "SELECT * FROM etudiants";

        try (Connection connection = ConnectionBD.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                int age = resultSet.getInt("age");
                String filiere = resultSet.getString("filiere");

                System.out.println("ID: " + id + ", Nom: " + nom + ", Prénom: " + prenom +
                        ", Âge: " + age + ", Filière: " + filiere);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'affichage des étudiants");
        }
    }

    public void mettreAJourEtudiant(int id, String nom, String prenom, int age, String filiere) {
        String sqlUpdate = "UPDATE etudiants SET nom = ?, prenom = ?, age = ?, filiere = ? WHERE id = ?";

        try (Connection connection = ConnectionBD.connect();
             PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate)) {

            updateStatement.setString(1, nom);
            updateStatement.setString(2, prenom);
            updateStatement.setInt(3, age);
            updateStatement.setString(4, filiere);
            updateStatement.setInt(5, id);

            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Les informations de l'étudiant ont été mises à jour !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la mise à jour de l'étudiant");
        }
    }

    public void supprimerEtudiant(int id) {
        String sqlDelete = "DELETE FROM etudiants WHERE id = ?";

        try (Connection connection = ConnectionBD.connect();
             PreparedStatement deleteStatement = connection.prepareStatement(sqlDelete)) {

            deleteStatement.setInt(1, id);
            int rowsDeleted = deleteStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("L'étudiant a été supprimé !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la suppression de l'étudiant");
        }
    }
}
