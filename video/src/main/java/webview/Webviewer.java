package webview;

import java.text.MessageFormat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class Webviewer extends Application implements Runnable {

	private final static String URL="http://www.youtube.com/embed/{0}?autoplay=1";


	public static String NERY_ID = "uQITWbAaDx0";
	public static String THOVEX_ID = "yKP7jQknGjs";
	

	private static WebView webview;
	
	private static Stage primaryStage;

	@Override
	public void start(Stage primaryStage0) {
		try {
			webview = new WebView();
			primaryStage = primaryStage0;
			
			BorderPane root = new BorderPane(webview);
			
			  //String id = getParameters().getRaw().get(0);
	            //webview.getEngine().load(MessageFormat.format(URL, id));

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			Platform.setImplicitExit(true);
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//String id = args[0];
		//System.out.println(args[0]);
		//Webviewer.setID(Webviewer.THOVEX_ID);
		String id = THOVEX_ID;
		launch(id);
	}

	@Override
	public void run() {
		launch();
	}
	
	public static void pause() {
		Platform.runLater(new Runnable(){
            @Override
            public void run(){
            	primaryStage.hide();
            }
        });
	}
	
	
	public static void setID(String id) {
		Platform.runLater(new Runnable(){
            @Override
            public void run(){
            	primaryStage.show();
            }
        });
		Platform.runLater(new Runnable(){
            @Override
            public void run(){
            	webview.getEngine().load(MessageFormat.format(URL, id));
            }
        });

	}

}
