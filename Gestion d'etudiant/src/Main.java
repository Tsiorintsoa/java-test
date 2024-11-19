import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaintenanceEtudiant maintenance = new MaintenanceEtudiant();
        int choix;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Afficher les étudiants");
            System.out.println("3. Mettre à jour un étudiant");
            System.out.println("4. Supprimer un étudiant");
            System.out.println("5. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom de l'étudiant : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom de l'étudiant : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Âge de l'étudiant : ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Filière de l'étudiant : ");
                    String filiere = scanner.nextLine();
                    maintenance.ajouterEtudiant(nom, prenom, age, filiere);
                    break;

                case 2:
                    // Afficher les étudiants
                    maintenance.afficherEtudiants();
                    break;

                case 3:
                    System.out.print("Entrez l'ID de l'étudiant à mettre à jour : ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nouveau nom : ");
                    String newNom = scanner.nextLine();
                    System.out.print("Nouveau prénom : ");
                    String newPrenom = scanner.nextLine();
                    System.out.print("Nouvel âge : ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nouvelle filière : ");
                    String newFiliere = scanner.nextLine();
                    maintenance.mettreAJourEtudiant(idUpdate, newNom, newPrenom, newAge, newFiliere);
                    break;

                case 4:
                    System.out.print("Entrez l'ID de l'étudiant à supprimer : ");
                    int idDelete = scanner.nextInt();
                    maintenance.supprimerEtudiant(idDelete);
                    break;

                case 5:
                    System.out.println("Merci d'avoir utilisé le programme !");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }

        } while (choix != 5);
    }
}
