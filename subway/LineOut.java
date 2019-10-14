package subway;

public class LineOut {
	
	public String LineOut(Station startAddress,Station endAddress) {
		StringBuffer sb = new StringBuffer();

		Line result = Dijkstra.set(startAddress, endAddress);
		sb.append("经过站点数：" + result.getPass().size()+"\n");
		
		sb.append("->乘坐"+result.getPass().get(0).getLine()+"\n");
		sb.append(startAddress.getname()+"\n");
		for(int i=0;i<result.getPass().size()-1;i++) {
			sb.append(result.getPass().get(i).getname()+"\n");
        	if(!result.getPass().get(i+1).getLine().equals(result.getPass().get(i).getLine())){
        		sb.append("->换乘"+result.getPass().get(i+1).getLine()+"\n");
        	}
        }
		sb.append(endAddress.getname()+"\n");
		return sb.toString();
	}


}