package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Video;

public class VideoRowMapper implements RowMapper<Video>{

	@Override
	public Video mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Video(rs.getString("linkId"), rs.getString("title"), rs.getLong("categorieId"));
	}
}