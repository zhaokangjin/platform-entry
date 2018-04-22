package entry.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageHelper;

import entry.condition.Page;

public class PageUtils {
	private final static Logger logger = LoggerFactory.getLogger(PageUtils.class);
	/**
	 * 分页设置
	 * @Title: setPageByCondition   
	 * @Description: 注意：重要的规则说三遍，这个利用的是反射，没有泛型约束。所以必须严格按照以下规则，否则分页会不成功
	 * 1、前台或中台传递的Object 如果需要分页，则必须传递page属性，该属性是com.flat.paas.common.util.data.Page 对象，该对象必须包含pageNum,pageSize两个int类型的分页设置，否则会报错
	 * 2、前台或中台传递的Object 对象 fieldName 和 sort 必须同时传，也就是说要么都传，要么都不传，这个设置是指定按哪个字段进行升序或降序排序
	 * fieldName 属性必须是要查询的表（表的字段）对应的domain对象的属性，否则反射失败;sort 只有两种方式 DESC（降序 ） 或ASC（升序）
	 * @param object  前台形如：{"page":{"pageNum":1,"pageSize":6},"fieldName":"createTime","sort":"DESC"}
	 */
	public static void setPageByCondition(Object object){
		try {
			String field=(String) BeanUtils.getFieldValue(object,"fieldName");
			String sort=(String) BeanUtils.getFieldValue(object,"sort");
			String fieldValue=null;
			String sortByField="";
			if(null!=field && !field.trim().equals("") && null!=sort && !sort.trim().equals("")){
				fieldValue=field.replaceAll("[A-Z]", "_$0").toUpperCase();
				sortByField=fieldValue+" "+sort.toUpperCase();
			}
			Page page=(Page)BeanUtils.getFieldValue(object,"page");
			if(null!=page){
				int pageNum=page.getPageNum();
				int pageSize=page.getPageSize();
				if(pageNum>0 && pageSize>0){
					//分页查询
					PageHelper.startPage(pageNum, pageSize,sortByField);  
				}
			}
		} catch (Exception e) {
			logger.error("BeanUtils>>>getPageByCondition>>>error:" + e);
		}
	}
}
