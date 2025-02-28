package models.Metier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connextionDB.ConnextionDatabase;
import models.Personne;
public class PeronneMetier {

	public static List<Personne> ListPersonnes() {
	    List<Personne> list = new ArrayList<>();
	    String query = "SELECT * FROM personne";
	    
	    try {
	        Statement stm = ConnextionDatabase.getConnextion().createStatement();
	        ResultSet rs = stm.executeQuery(query);
	        
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nom = rs.getString("nom");
	            String prenom = rs.getString("prenom");
	            int age = rs.getInt("age");
	            list.add(new Personne(id, nom, prenom, age));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    System.out.println("Liste des personnes : " + list); // Vérifie si la liste est bien remplie
	    return list;
	}

		

		public void ajouterPersonne(Personne Personne) {
			
			String query = "INSERT INTO personne (nom,prenom,age) VALUES(?,?,?)";
			
			try {
				PreparedStatement prs = ConnextionDatabase.getConnextion().prepareStatement(query);
				prs.setString(1, Personne.getNom());
				prs.setString(2, Personne.getPrenom());
				prs.setInt(3, Personne.getAge());
				prs.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		public void supprimerPersonne(int id) {

			String query = "DELETE FROM personne WHERE id = ?";
			
			try  {
					PreparedStatement prs = ConnextionDatabase.getConnextion().prepareStatement(query);
			        prs.setInt(1, id);
			        int rowsAffected = prs.executeUpdate();
			        if (rowsAffected > 0) {
			            System.out.println(" personnesupprimé avec succès !");
			        } else {
			            System.out.println("Aucun personnes trouvé avec l'ID : " + id);
			        }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
						
		
		// TODO Auto-generated constructor stub
	}

}
