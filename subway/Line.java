package subway;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private Station start;
	private Station over;
	private int distance = 0;
	private List<Station> pass = new ArrayList<>();
	
	public void setStart(Station start) {
		this.start = start;
	}
	public Station getStart() {
		return start;
	}
	
	public void setOver(Station over) {
		this.over = over;
	}
	public Station getOver() {
		return over;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getDistance() {
		return distance;
	}
	
	public void setPass(List<Station> pass) {
		this.pass = pass;
	}
	public List<Station> getPass() {
		return pass;
	}
	

	public Line(Station start, Station over, int distance) {
        this.start = start;
        this.over = over;
        this.distance = distance;
    }
	
	public Line() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
        return "Result{" +
                "start=" + start +
                ", over=" + over +
                ", distance=" + distance +
                ", passStations=" + pass +
                '}';
    }

}