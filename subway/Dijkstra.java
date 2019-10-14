package subway;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Dijkstra {

	private static HashMap<Station, Line> resultMap = new HashMap<>();//LinkedHashSet转为HashMap<over station,line>
	private static List<Station> liststation = new ArrayList<>();
	public static Line set(Station start,Station over) { 
		
        if (!liststation.contains(start)) {//起点站加入list
        	liststation.add(start);
        }
        
        if (start.equals(over)){//起点=终点
        	Line result = new Line(start, over, 0);
          
            resultMap.put(start, result);//存入HashMap
            
            return resultMap.get(start);
        }
        if (resultMap.isEmpty()) {//第一站
            List<Station> linkStations = getLinkStation(start);//获取相邻站
            
            for (Station station : linkStations) {//遍历
            	Line result = new Line();
                result.setStart(start);
                result.setOver(station);
                int distance = 1;
                result.setDistance(distance);
                result.getPass().add(station);
                resultMap.put(station, result);
            }
        }
        Station next = getNextStation();
        if (next==null){
        	Line result = new Line();
            result.setDistance(0);
            result.setStart(start);
            result.setOver(over);
            return resultMap.put(over, result);
        }
        if (next.equals(over)) {//找到终点
            return resultMap.get(next);
        }
        List<Station> nextLink = getLinkStation(next);
        for (Station after : nextLink) {
            if (liststation.contains(after)) {
                continue;
            }
            int distance =  resultMap.get(next).getDistance()+1;
            if( next.getname().equals(after.getname())){
                distance = 0;
            }
            List<Station> beforePass = resultMap.get(next).getPass();
            Line afterResult = resultMap.get(after);
            if (afterResult!=null){
                if (afterResult.getDistance() > distance) {
                	afterResult.setDistance(distance);
                	afterResult.getPass().clear();
                	afterResult.getPass().addAll(beforePass);
                	afterResult.getPass().add(after);
                }
            }
            else {
            	afterResult = new Line();
            	afterResult.setDistance(distance);
            	afterResult.setStart(start);
            	afterResult.setOver(after);
            	afterResult.getPass().addAll(beforePass);
            	afterResult.getPass().add(after);
            }
            resultMap.put(after, afterResult);
        }
        liststation.add(next);
        set(start, over);
        return resultMap.get(over);
    }

	private static List<Station> getLinkStation(Station station) {
        List<Station> linkedStaions = new ArrayList<Station>();
        for (List<Station> line : Data.lineSet) {//遍历线路集合
            for (int i = 0; i < line.size(); i++) {
                if (station.equals(line.get(i))) {
                    if (i == 0) {//线头
                        linkedStaions.add(line.get(i + 1));
                    } else if (i == (line.size() - 1)) {//线尾
                        linkedStaions.add(line.get(i - 1));
                    } else {
                        linkedStaions.add(line.get(i + 1));
                        linkedStaions.add(line.get(i - 1));
                    }
                }
            }
        }
        return linkedStaions;
    }

	private static Station getNextStation() {
        int min = 500;
        Station dots = null;
        
        for (Station station : resultMap.keySet()) {//遍历HashMap返回的所有键，即start station(Line是值)
            if (liststation.contains(station)) {
                continue;
            }
            Line result = resultMap.get(station);//返回station对应的value
            if (result.getDistance() < min) {
                min = result.getDistance();
                dots = result.getOver();
            }
        }
        return dots;
    }


}