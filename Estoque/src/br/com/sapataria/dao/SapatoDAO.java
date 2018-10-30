package br.com.sapataria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.sapataria.config.BDConfig;
import br.com.sapataria.entidade.Sapato;

public class SapatoDAO {

	public List<Sapato> listarSapatos() throws Exception {
        List<Sapato> lista = new ArrayList<>();
 
        Connection conexao = BDConfig.getConnection();
 
        String sql = "SELECT * FROM tb_estoque";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
 
        while (rs.next()) {
			Sapato Sapato = new Sapato();
            Sapato.setId(rs.getInt("id"));
            Sapato.setNome(rs.getString("nome"));
            Sapato.setQuantidade(rs.getInt("quantidade"));
            Sapato.setPreco(rs.getDouble("preco"));
            Sapato.setNumero(rs.getInt("numero"));
 
            lista.add(Sapato);
        }
 
        return lista;
    }
     
    public Sapato buscarSapatoPorId(int idSapato) throws Exception {
        Sapato sapato = null;
 
        Connection conexao = BDConfig.getConnection();
 
        String sql = "SELECT * FROM tb_estoque WHERE id = ?";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, idSapato);
        ResultSet rs = statement.executeQuery();
 
        if (rs.next()) {
            sapato = new Sapato();
            sapato.setId(rs.getInt("id"));
            sapato.setNome(rs.getString("nome"));
            sapato.setQuantidade(rs.getInt("quantidade"));
            sapato.setPreco(rs.getDouble("preco"));
            sapato.setNumero(rs.getInt("numero"));
        }
 
        return sapato;
    }
    
    public List<Sapato> buscarSapatoPorNome(String nomeSapato) throws Exception {
    	List<Sapato> lista = new ArrayList<>();
    	 
        Connection conexao = BDConfig.getConnection();
 
        String sql = "SELECT * FROM tb_estoque WHERE nome = ?";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, nomeSapato);
        ResultSet rs = statement.executeQuery();
 
        while (rs.next()) {
			Sapato Sapato = new Sapato();
            Sapato.setId(rs.getInt("id"));
            Sapato.setNome(rs.getString("nome"));
            Sapato.setQuantidade(rs.getInt("quantidade"));
            Sapato.setPreco(rs.getDouble("preco"));
            Sapato.setNumero(rs.getInt("numero"));
 
            lista.add(Sapato);
        }
 
        return lista;
    }
 
    public int addSapato(Sapato sapato) throws Exception {
        int idGerado = 0;
        Connection conexao = BDConfig.getConnection();
 
        String sql = "INSERT INTO tb_estoque(nome, quantidade, preco, numero) VALUES(?, ?, ?, ?)";
 
        PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, sapato.getNome());
        statement.setInt(2, sapato.getQuantidade());
        statement.setDouble(3, sapato.getPreco());
        statement.setInt(4, sapato.getNumero());
        statement.execute();
         
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
         
        return idGerado;
    }
     
    public void editarSapato(Sapato sapato, int idSapato) throws Exception {
        Connection conexao = BDConfig.getConnection();
 
        String sql = "UPDATE tb_estoque SET nome = ?, quantidade = ?, preco = ?, numero = ? WHERE id = ?";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, sapato.getNome());
        statement.setInt(2, sapato.getQuantidade());
        statement.setDouble(3, sapato.getPreco());
        statement.setInt(4, sapato.getNumero());
        statement.setInt(5, idSapato);
        statement.execute();
    }
     
    public void removerSapato(int idSapato) throws Exception {
        Connection conexao = BDConfig.getConnection();
 
        String sql = "DELETE FROM tb_estoque WHERE id = ?";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, idSapato);
        statement.execute();
    }
	
}
