package serverpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.net.ssl.SSLContext;
import javax.print.attribute.standard.DateTimeAtCompleted;

public class server {
	static BufferedWriter bw = null;
	static BufferedReader br = null;
	static ServerSocket ss = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
	Timestamp time = new Timestamp(System.currentTimeMillis());
	String timenow = sdf.format(time);
	
		
		Logger.setPath("D://Files//RS_log.txt");
		try (ServerSocket ss = new ServerSocket(45000);)	
		{
			Logger.LogMessage(timenow + " Server gestartet");
			while(true)
			{
				Socket cls = ss.accept();
				File f = new File("D://Files//Mapdata.txt");
				
				bw = new BufferedWriter(new OutputStreamWriter(cls.getOutputStream()));
				br = new BufferedReader(new InputStreamReader(cls.getInputStream()));
				bw.write("Verbindung erfolgreich hergestellt");
				bw.newLine();
				bw.write("Verfügbare Befehle");
				bw.write("START:IHR STANDORT, ZIEL:GEWÜNSCHTES ZIEL, EXIT");
				bw.flush();
				String[] commands = {"ROUTE","START","ZIEL","EXIT"};
				String line;
				String start = null,ziel=null;
				while((line = br.readLine()) != null) 
				{
					//variante 1
					if(line.split(":")[0].equals(commands[0]))
					{
						bw.write("bitte aktuellen Standort eingeben eingeben");
						bw.flush();
					}
					if(line.split(":")[0].equals(commands[0]))
					{
						bw.write("bitte aktuellen Standort eingeben eingeben");
						bw.flush();
					}
					else if(line.split(":")[0].equals(commands[1]))
					{
						start = line.split(":")[1];
						bw.write("Ihr Standort lautet: " + start);
						bw.flush();
					}
					else if(line.split(":")[0].equals(commands[2]))
					{
						ziel = line.split(":")[1];
						bw.write("Ihr Ziel lautet: " + ziel);
						bw.flush();
						if(start != null && ziel != null && ziel != start)
						bw.write("Ihre Strecke von " + start + " nach " +  ziel + " wird berechnet.");
						bw.flush();
					}
					else if(line.split(":")[0].equals(commands))
					{
						bw.write("Ungültiger Befehl");
						bw.flush();
					}
					else if(line.split(":")[0].equals(commands[3]))
					{
						bw.write("Verbindung wird getrennt");
						bw.flush();
						close();
					} 
					
						
				}
			}
		} 	
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			Logger.LogMessage(timenow + "Server kann nicht gestartet werden, Port überprüfen");
		
		}
		
		
	
		
	}
	public static void close() 
	{
		try {
			br.close();
			bw.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
