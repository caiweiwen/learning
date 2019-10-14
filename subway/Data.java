package subway;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Data {

	public static LinkedHashSet<List<Station>> lineSet = new LinkedHashSet<>();//List<Station>����
	
	public static void TxttoData(String filePath) {
		try {
			File file = new File(filePath);

			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����

				FileInputStream fis = new FileInputStream(file);
				InputStreamReader read = new InputStreamReader(fis, "GBK");
				BufferedReader br = new BufferedReader(read);
				
				String ttxt = null;
				while ((ttxt = br.readLine()) != null) {//br.readLine()ÿִ��һ�����¶�һ��
					
					  List<Station> Linelist = new ArrayList<Station>();
					  
		        	  String[] line = ttxt.split(" ");//�ָ���
		        	 
		        	  for(int i=1;i<line.length;i++) {
		        		  
		        		  Linelist.add(new Station(line[0],line[i]));//Station:��·��,վ��
		        		  
		        	  }		        	
		        	  lineSet.add(Linelist);
				}
				read.close();
			} else {
				System.out.println("�ļ�������");
			}
		} catch (Exception e) {
			System.out.println("��ȡ����");
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
