package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String URL =
            "jdbc:postgresql://ep-blue-surf-b6g2wqm1-pooler.c-2.sa-east-1.aws.neon.tech/neondb?sslmode=require&channelBinding=require";
    private static final String USUARIO = "neondb_owner";
    private static final String SENHA = "npg_CzFm0IqByOK1";

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }
}