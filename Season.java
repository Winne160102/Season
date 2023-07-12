package APIBaitap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.transform.Templates;

public class Season {
	//attributes
	private String name; // tên
	private String temprature; // nhiệt độ
	private String weather; // thời tiết 
	private String landscape; // cảnh quan
	private String activity; // hoạt động
	private String holiday; // ngày lễ
	
	//constructor all attributes
	public Season(String name, String temprature, String weather, String landscape, String activity, String holiday) {
		this.name = name;
		this.temprature = temprature;
		this.weather = weather;
		this.landscape = landscape;
		this.activity = activity;
		this.holiday = holiday;
	}
	
	//constructor
	public Season() {
		// TODO Auto-generated constructor stub
	}
	
	//get&set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTemprature() {
		return temprature;
	}
	public void setTemprature(String temprature) {
		this.temprature = temprature;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getLandscape() {
		return landscape;
	}
	public void setLandscape(String landscape) {
		this.landscape = landscape;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	//setall
	public void setall(String name, String temprature, String weather, String landscape, String activity, String holiday) {
		this.name = name;
		this.temprature = temprature;
		this.weather = weather;
		this.landscape = landscape;
		this.activity = activity;
		this.holiday = holiday;
	}
	
	//input
	public void inputSeason() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name Season: ");
		name = sc.nextLine();
		
		System.out.println("Enter Temprature Season: ");
		temprature = sc.nextLine();
		
		System.out.println("Enter Weather Season: ");
		weather = sc.nextLine();
		
		System.out.println("Enter Landscape Season: ");
		landscape = sc.nextLine();
		
		System.out.println("Enter Activity Season: ");
		activity = sc.nextLine();
		
		System.out.println("Enter Holiday Season: ");
		holiday = sc.nextLine();
		
	}
	
	//output
	public void outputSeason() {
		System.out.println("Name Season: " + getName());
		
		System.out.println("Temprature Season: " + getTemprature());
		
		System.out.println("Weather Season: " + getWeather());
		
		System.out.println("Landscape Season: " + getLandscape());
		
		System.out.println("Activity Season: " + getActivity());
		
		System.out.println("Holiday Season: " + getHoliday());
	}
	
	//input file
	public static ArrayList<Season> inputFile(){
		ArrayList<Season> list = new ArrayList<Season>();
		try {
			FileReader fReader = new FileReader("C:\\Users\\Admin\\Desktop\\lib java\\Java\\Season.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			while (true) {
				String line = bReader.readLine();
				if (line == "" || line == null) {
					String[] temp = line.split("[;]");
					Season data = new Season(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
					list.add(data);
				}
				bReader.close();
				fReader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//output file
	public void outputFile(ArrayList<Season> list) {
		try {
			FileWriter fWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\lib java\\Java\\Season1.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(Season data : list) {
				bWriter.write(data.getName() + ";" + data.getTemprature() + ";" + data.getWeather() + ";" + data.getLandscape() + ";" + data.getActivity() + ";" + data.getHoliday());
				bWriter.newLine();
			}
			bWriter.close();
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//output monitor
	public void outputMonitor() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Season> list = new ArrayList<Season>();
		boolean exit = false;
		System.out.println("Enter Your Choice: 1 - Input File, 2 - Output File, 3 - Enter Information For Season, 4 - Exit.");
		while (!exit) {
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				list = inputFile();
				System.out.println("Input File Created. ");
				break;
			
			case 2:
				outputFile(list);
				System.out.println("Output File Created. ");
				break;
			
			case 3:
				System.out.println("Enter Information For Season: ");
				inputSeason();
				outputSeason();
				break;
				
			case 4:
				exit = true;
				System.out.println("Program has been closed.");
				break;
			default:
				System.out.println("Invalid Choice!");
				break;
			}
		}
	}
	
	//main
	public static void main(String[] args) {
		Season season = new Season();
		season.outputMonitor();
	}
}
