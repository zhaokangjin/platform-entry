package entry.utils;

import entry.condition.BaseCondition;
import entry.condition.Distinct;

public class ConditionExampleMappingUtils {
	
	public static <T> T mapping(T example, BaseCondition baseCondition) {
		if(null==baseCondition){
			return null;
		}
		Distinct distinct=baseCondition.getDistinct();
		if(null!=distinct){
			if(distinct.isDistinct()){
				
			}else{
				
			}
		}
		
		
		
		
		return example;
	}
}
