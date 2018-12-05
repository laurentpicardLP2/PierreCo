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
import webview.Main;
import javax.management.Query;


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
    	//createTable();
    	//insertValues();
    	
		
    	
    	//Main.MainVideo();
    	//Main.launch("uQITWbAaDx0");args
    	
    	List<Video> videos= findBySurname("uQITWbAaDx0");
    	for (Video video : videos) {
    		log.info(video.toString());
    		Main.MainVideo(video.getLinkId());
    	}

    	

    	/*List<Customer> customers= findBySurname("Josh");
    	for (Customer customer : customers) {
    		log.info(customer.toString());
    		insertCustomer(customer);
    	}*/

    }

    /*private void insertValues() {
    	insertCustomer(new Customer(1, "John","Woo"));
    	insertCustomer(new Customer(2, "Josh", "Long"));
    	insertCustomer(new Customer(3, "Jeff"," Dean"));
    	insertCustomer(new Customer(4, "Josh", "Bloch"));
		
	}*/

	public void createTable() {
    	 log.info("Creating tables");

         jdbcTemplate.execute("DROP TABLE IF EXISTS videos");

         jdbcTemplate.execute("DROP TABLE IF EXISTS categories");
         jdbcTemplate.execute("CREATE TABLE categories(id Int  Auto_increment  NOT NULL ,intitule Varchar (255) NOT NULL,CONSTRAINT categories_PK PRIMARY KEY (id))ENGINE=InnoDB;");
         
         jdbcTemplate.execute("CREATE TABLE videos(linkId Varchar (255) NOT NULL ,titre Varchar (255) NOT NULL ,categorieId          Int NOT NULL,CONSTRAINT videos_PK PRIMARY KEY (linkId),CONSTRAINT videos_categories_FK FOREIGN KEY (categorieId) REFERENCES categories(id))ENGINE=InnoDB;");
    }
    /**
     * @param newCusto : the Customer to be added in database
     */
   /* public void insertCustomer(Customer newCusto) {
    	jdbcTemplate.update(
    			"INSERT INTO customers(first_name, last_name) VALUES (?,?)",
    			newCusto.getFirstName(),
    			newCusto.getLastName()
    			);
    }
    
    public List<Customer> findBySurname(String surname){
   	 log.info(MessageFormat.format("Querying for customer records where first_name = {0}:", surname));

        return jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] {surname },
                new CustomerRowMapper());
   } */
	
	public void insertValues() {
		//List<Categorie> customers= findBySurname("Josh");
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
    			"INSERT INTO videos(linkId, titre, categorieId) VALUES (?, ?, ?)",
    			newVid.getLinkId(),
    			newVid.getTitre(),
    			newVid.getCategorieId()
    			);
	}
	
/*	 public List<Video> findBySurname(String surname){
      	 log.info(MessageFormat.format("Querying for customer records where first_name = {0}:", surname));

           return jdbcTemplate.query(
                   "select * from Video WHERE intitule linkId ?", new Object[] {surname },
                   new VideoRowMapper());
      }*/
	
	 public List<Video> findBySurname(String surname){
      	 log.info(MessageFormat.format("Querying for customer records where first_name = {0}:", surname));

           return jdbcTemplate.query(
                   "select * from videos WHERE linkId like ?", new Object[] {surname },
                   new VideoRowMapper());
      }
	
	

}