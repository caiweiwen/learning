package subway;

import java.util.ArrayList;
import java.util.List;

public class Station {
	
	private String name;
	private String line;
	private List<Station> links = new ArrayList<>();

    public void setname(String name) {
		this.name = name;
	}
    public String getname() {
		return name;
	}
	
	public void setLine(String line) {
		this.line = line;
	}
	public String getLine() {
		return line;
	}
	
	public void setLinks(List<Station> links) {
		this.links = links;
	}
	public List<Station> getLinks() {
		return links;
	}
	
	public Station(String name) {
        this.name = name;
    }
	public Station( String line,String name) {
        this.line = line;
        this.name = name;
        
    }
	public boolean equals(Object obj) {
        if(this == obj){
            return true;
        } else if(obj instanceof Station){
            Station s = (Station) obj;
            if(s.getname().equals(this.getname())){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

 
    public int hashCode() {
        return this.getname().hashCode();
    }

    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", line='" + line + '\'' +
                ", linkStations=" + links +
                '}';
    }
}