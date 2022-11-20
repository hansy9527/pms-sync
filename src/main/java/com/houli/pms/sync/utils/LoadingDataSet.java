package com.houli.pms.sync.utils;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @description 将存储过程返回的多个表装填到List<?>中
 * @version 20140822
 */
public class LoadingDataSet implements CallableStatementCallback<List<Map<String, List<Map<String, Object>>>>> {

	private List<Object> parameters = null;
	private List<String> tabNames = null;

	public LoadingDataSet(){
	}
	
	/**
	 * @description 初始化类
	 * 
	 * @param :
	 * 					"parameters"——存储过程参数
	 * 					"tabNames"——表名（注：表名可以多于存储过程返回的表的数量，但不能少于。这样可以适用于存储过程返回的表的数量不固定。）
	 * @return BeanData
	 */
	public LoadingDataSet(List<Object> parameters, List<String> tabNames) throws Exception {
		this.parameters = parameters;
		this.tabNames = tabNames;
	}

	@Override
	public List<Map<String, List<Map<String, Object>>>> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
		if (this.parameters != null && this.parameters.size() > 0) {
			for (int i = 0; i < this.parameters.size(); i++) {
				cs.setObject(i + 1, this.parameters.get(i));
			}
			parameters.clear();
			parameters = null;
		}

		List<Map<String, List<Map<String, Object>>>> listDataSet = new ArrayList<Map<String, List<Map<String, Object>>>>();
		Map<String, List<Map<String, Object>>> mapDataTable = new LinkedHashMap<String, List<Map<String, Object>>>();
		boolean hasResultSet = false;
		hasResultSet = cs.execute();
		ResultSet rs = null;
		Integer iCounter = 0;

		while (hasResultSet) {
			rs = cs.getResultSet();
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					map.put(rs.getMetaData().getColumnLabel(i), rs.getObject(i));
				}
				list.add(map);
			}
			mapDataTable.put(this.tabNames.get(iCounter), list);
			iCounter++;
			hasResultSet = cs.getMoreResults();
		}
		
		listDataSet.add(mapDataTable);

		if (rs != null) {
			rs.close();
		}
		return listDataSet;
	}

}