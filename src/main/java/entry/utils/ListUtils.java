package entry.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {
	public static String join( List<String> list,String symbol) {
		if(null==list || list.size()==0){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				sb.append(list.get(i));
			} else {
				sb.append(list.get(i)).append(symbol);
			}
		}
		return sb.toString();
	}
	public static String join(String[] str,String symbol) {
		List<String> list=new ArrayList<String>(Arrays.asList(str));
		return join(list,symbol);
	}
}
