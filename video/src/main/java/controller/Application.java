package controller;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;


import model.Categorie;
import model.Video;
import webview.*;

import javax.management.Query;
import menu.GestionMenu;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
    	SpringApplication.run(Application.class, args);   
         
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
    	int choix;
    	createTable();
    	insertValues();
    	new Thread(new Webviewer()).start();
    	
    	do {
    		choix = GestionMenu.AffichMenu();
    		switch(choix) {
    		case 1 : insertVideo();
    			break;
    		case 2 : findByTitle();
    			break;
    		}
    		
    	}while(choix != 3);

    	
    }
    
    public void insertVideo() {
    	
    }
    
    public void findByTitle() throws InterruptedException{
    	String title = GestionMenu.showVideo();
    	List<Video> videos =  jdbcTemplate.query(
                "select * from videos WHERE title like ?", new Object[] {title },
                new VideoRowMapper());
    	Video video = videos.get(0);
    	
    	//Webviewer.main(null);
    	
   
    	Thread thread = new Thread(new Runnable() {
   		 @Override
            public void run() {
   			String[] args = new String[1];
			args[0] = video.getLinkId();
			//Webviewer.main(args); //.main(video.getLinkId());
			Webviewer.setID(Webviewer.THOVEX_ID);
			
   		 }
   	 });
   	 //thread.setDaemon(true);
        thread.start();
    	
    	
    	//Main.MainVideo(video.getLinkId());
    	
    }

	public void createTable() {
    	 log.info("Creating tables");

         jdbcTemplate.execute("DROP TABLE IF EXISTS videos");

         jdbcTemplate.execute("DROP TABLE IF EXISTS categories");
         jdbcTemplate.execute("CREATE TABLE categories(id Int  Auto_increment  NOT NULL ,intitule Varchar (255) NOT NULL,CONSTRAINT categories_PK PRIMARY KEY (id))ENGINE=InnoDB;");
         
         jdbcTemplate.execute("CREATE TABLE videos(linkId Varchar (255) NOT NULL ,title Varchar (255) NOT NULL ,categorieId          Int NOT NULL,CONSTRAINT videos_PK PRIMARY KEY (linkId),CONSTRAINT videos_categories_FK FOREIGN KEY (categorieId) REFERENCES categories(id))ENGINE=InnoDB;");
    }
    /**
     * @param newCusto : the Customer to be added in database
     */
	
	public void insertValues() {
		Categorie cat1 = new Categorie(1, "Comedie");
    	Categorie cat2 = new Categorie(2, "Science-fiction");
    	Categorie cat3 = new Categorie(3, "Aventure");
    	Categorie cat4 = new Categorie(4, "Documentaire");
		
    	List<Categorie> categories = Arrays.asList(cat1, cat2, cat3, cat4);
    	for(Categorie categorie : categories) {
    		insertCategorie(categorie);
    	}
    	
    	Video vid1 = new Video("uQITWbAaDx0", "NeryPool", 4);
    	Video vid2 = new Video("yKP7jQknGjs", "Thovex", 3);
    	List<Video> videos = Arrays.asList(vid1, vid2);
    	for(Video video : videos) {
    		insertVideos(video);
    	}
		
	}
	
	public void insertCategorie(Categorie newCat) {
		jdbcTemplate.update(
    			"INSERT INTO categories(intitule) VALUES (?)",
    			newCat.getIntitule()
    			);
	}
	
	public void insertVideos(Video newVid) {
		jdbcTemplate.update(
    			"INSERT INTO videos(linkId, title, categorieId) VALUES (?, ?, ?)",
    			newVid.getLinkId(),
    			newVid.getTitle(),
    			newVid.getCategorieId()
    			);
	}	
	

}