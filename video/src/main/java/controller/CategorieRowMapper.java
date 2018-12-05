package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Categorie;

public class CategorieRowMapper implements RowMapper<Categorie>{

	@Override
	public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Categorie(rs.getInt("id"), rs.getString("intitule"));
	}
}