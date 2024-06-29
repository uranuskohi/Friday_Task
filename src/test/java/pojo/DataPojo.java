package pojo;

import java.io.Serializable;

public class DataPojo implements Serializable {
	private int id;
	private String name;
	private int year;
	private String color;
	private String pantoneValue;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setYear(int year){
		this.year = year;
	}

	public int getYear(){
		return year;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setPantoneValue(String pantoneValue){
		this.pantoneValue = pantoneValue;
	}

	public String getPantoneValue(){
		return pantoneValue;
	}

	@Override
 	public String toString(){
		return 
			"DataPojo{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",year = '" + year + '\'' + 
			",color = '" + color + '\'' + 
			",pantone_value = '" + pantoneValue + '\'' + 
			"}";
		}
}