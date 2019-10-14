package subway;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Data {

	public static LinkedHashSet<List<Station>> lineSet = new LinkedHashSet<>();//List<Station>集合
	
	public static void TxttoData(String filePath) {
		try {
			File file = new File(filePath);

			if (file.isFile() && file.exists()) { // 判断文件是否存在

				FileInputStream fis = new FileInputStream(file);
				InputStreamReader read = new InputStreamReader(fis, "GBK");
				BufferedReader br = new BufferedReader(read);
				
				String ttxt = null;
				while ((ttxt = br.readLine()) != null) {//br.readLine()每执行一次向下读一行
					
					  List<Station> Linelist = new ArrayList<Station>();
					  
		        	  String[] line = ttxt.split(" ");//分隔符
		        	 
		        	  for(int i=1;i<line.length;i++) {
		        		  
		        		  Linelist.add(new Station(line[0],line[i]));//Station:线路名,站名
		        		  
		        	  }		        	
		        	  lineSet.add(Linelist);
				}
				read.close();
			} else {
				System.out.println("文件不存在");
			}
		} catch (Exception e) {
			System.out.println("读取错误");
			e.printStackTrace();
		}

	}
    public static Station toStation(String station) {
    	for(List<Station> ls:Data.lineSet)
    		for(Station st:ls)
    			if(station.equals(st.getname()))
    			return st;
		return null;
           }
	
}
