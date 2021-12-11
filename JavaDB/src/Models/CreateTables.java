/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Leo
 */
public class CreateTables {
    public void create() throws SQLException {
        // Connection Configuration
        Properties connConfig = new Properties();
        connConfig.setProperty("user", "root");
        connConfig.setProperty("password", "1234");
        //connConfig.setProperty("useSsl", "true");
        //connConfig.setProperty("serverSslCert", "/path/to/ca-bundle.pem");

        // Create Connection to MariaDB Enterprise
        try (Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306", connConfig)) {

            // Disable Auto-Commit
            conn.setAutoCommit(false);

            // user
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.user ("
                        + "usid INT PRIMARY KEY AUTO_INCREMENT,"
                        + "name VARCHAR(25),"
                        + "type VARCHAR(25))"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // publisher
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.publisher ("
                        + "puid INT PRIMARY KEY AUTO_INCREMENT,"
                        + "name VARCHAR(25),"
                        + "author VARCHAR(25),"
                        + "email VARCHAR(100))"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // author
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(
                        "CREATE TABLE IF NOT EXISTS library.author ("
                        + "auid INT PRIMARY KEY AUTO_INCREMENT,"
                        + "name VARCHAR(25))"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // book
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.books ("
                        + "boid INT PRIMARY KEY AUTO_INCREMENT,"
                        + "title VARCHAR(25),"
                        + "author VARCHAR(25),"
                        + "email VARCHAR(100),"
                        + "fkpuid INT NOT NULL,"
                        + "fkauid INT NOT NULL,"
                        + "CONSTRAINT FK_puid FOREIGN KEY (fkpuid)"
                        + " REFERENCES LIBRARY.publisher(puid),"
                        + "CONSTRAINT FK_auid FOREIGN KEY (fkauid)"
                        + " REFERENCES LIBRARY.author(auid))"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // order itens
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.orderitens ("
                        + "auid INT PRIMARY KEY AUTO_INCREMENT,"
                        + "fkorid INT NOT NULL," //id da venda
                        + "fkboid INT NOT NULL," //id do livro
                        + "CONSTRAINT FK_orid FOREIGN KEY (fkorid)"
                        + " REFERENCES LIBRARY.order(orid),"
                        + "CONSTRAINT FK_boid FOREIGN KEY (fkboid)"
                        + " REFERENCES LIBRARY.book(boid)"
                        + ")"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }
            // order
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.order ("
                        + "orid INT PRIMARY KEY AUTO_INCREMENT,"
                        + "date VARCHAR(8),"
                        + "numberofbooks INT(6) NOT NULL,"
                        + "fkusid INT NOT NULL,"
                        + "CONSTRAINT FK_pusid FOREIGN KEY (fkusid)"
                        + " REFERENCES LIBRARY.user(usid))"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
