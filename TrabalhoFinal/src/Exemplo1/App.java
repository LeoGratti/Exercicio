/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Leo
 */
public class App {

   public static void main(String[] argv) {

       // Connection Configuration
       Properties connConfig = new Properties();
       connConfig.setProperty("user", "root");
       connConfig.setProperty("password", "123");
       //connConfig.setProperty("useSsl", "true");
       //connConfig.setProperty("serverSslCert", "/path/to/ca-bundle.pem");

       // Create Connection to MariaDB Enterprise
       try (Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306", connConfig)) {

           // Disable Auto-Commit
           conn.setAutoCommit(false);

           // Use Statement to Create library.books table
           try (Statement stmt = conn.createStatement()) {
               stmt.execute(
                       "CREATE TABLE IF NOT EXISTS livraria.livros (" +
                          "id INT PRIMARY KEY AUTO_INCREMENT," +
                          "titulo VARCHAR(25)," +
                          "autor VARCHAR(25)," +
                          "email VARCHAR(100)," +
                          "numPags INT(5),"+
                          "qtd INT(5))" +
                        "ENGINE=InnoDB;");

               // Prepare INSERT Statement to Add Books
               try (PreparedStatement prep = conn.prepareStatement(
                           "INSERT INTO livraria.livros (titulo, autor, email, numPags, quantidade)"
                                   + " VALUES (?, ?, ?, ?, ?)",
                           Statement.RETURN_GENERATED_KEYS)) {

                   // Add book
                   prep.setString(1, "Matrix");
                   prep.setString(2, "Keanu Reeves");
                   prep.setString(3, "planeta@gmail.com"); //injecao de sql
                   prep.setInt(4, 5);
                   prep.setInt(5, 4);
                   prep.executeBatch();

                   // Add book
                   prep.setString(1, "O senhor dos Anéis");
                   prep.setString(2, "Frodo Baggins");
                   prep.setString(3, "frodo@teste.com");
                   prep.setInt(4, 7);
                   prep.setInt(5, 2);
                   prep.executeBatch();

                   // Add book
                   prep.setString(1, "Java Script");
                   prep.setString(2, "Leozim");
                   prep.setString(3, "leo@teste1.com");
                   prep.setInt(4, 2);
                   prep.setInt(5, 3);
                   prep.executeBatch();

                   // Execute Prepared Statements in Batch
                   System.out.println("Batch Counts");
                   int[] updateCounts = prep.executeBatch();
                   for (int count : updateCounts) {

                       // Print Counts
                       System.out.println(count);
                   }
             }

             // Prepare UPDATE Statement
             try (PreparedStatement prep = conn.prepareStatement(
                         "UPDATE livraria.livros " +
                         "SET email = ? WHERE id = ?")) {

                 // Change Email Address
                 prep.setString(1, "planeta@gmail.com");

                 // Change ID
                 prep.setInt(2, 1);
                 prep.execute();
             }

             // Prepare DELETE Statement
             try (PreparedStatement prep = conn.prepareStatement(
                         "DELETE FROM livraria.livros " +
                         "WHERE id = ?")) {

                 // ID of Row to Remove
                 prep.setInt(1, 3);
                 prep.execute();
             }

             // Commit Changes
             conn.commit();

             // Execute a SELECT Statement
             ResultSet book_list = stmt.executeQuery(
                     "SELECT titulo, autor, email " +
                     "FROM livraria.livros");

             // Iterate over the Result-set

             System.out.println("Books:");
             while (book_list.next()) {

                 // Print Row
                 System.out.println(
                         String.format(
                             "- %s %s <%s>",
                             book_list.getString("titulo"),
                             book_list.getString("autor"),
                             book_list.getString("email")));
             }
        }

        // Catch SQL Exceptions for Queries
        catch (SQLException exc) {
             exc.printStackTrace();
             conn.rollback();
        }
      }

      // Catch SQL Exceptions from Connection
      catch (SQLException e) {
         e.printStackTrace();
      }
   }
}