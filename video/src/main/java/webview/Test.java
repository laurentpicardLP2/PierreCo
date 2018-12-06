package webview;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		new Thread(new Webviewer()).start();
		// this will call your Main 
		
		Webviewer.setID(Webviewer.THOVEX_ID);
		
		Scanner saisie = new Scanner(System.in);
		System.out.println("will now play an other video (after enter key)");
		saisie.nextLine();
		Webviewer.setID(Webviewer.THOVEX_ID);
		
		System.out.println("will now play an other video (after enter key)");
		saisie.nextLine();
		Webviewer.setID(Webviewer.NERY_ID);
		
		System.out.println("will pause (after enter key)");
		saisie.nextLine();
		Webviewer.pause();
		
		
		saisie.close();
        
        
    }


	
}
