package com.istudy.server.common.dao.handler;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.istudy.server.common.exception.CMSException;

import static com.istudy.server.common.utils.CommonUtils.*;

public class DateTypeHandler extends BaseTypeHandler<String>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			String parameter, JdbcType jdbcType) throws SQLException {
		if(isNull(parameter)){
			ps.setTimestamp(i, null);
			return ;
		}
		try {
			ps.setTimestamp(i, new Timestamp(BASIC_DATE_FORMAT.parse(parameter).getTime()));
		} catch (ParseException e) {
			throw new CMSException(e);
		}
	}
	@Override
	public String getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		Timestamp date = rs.getTimestamp(columnName);
		if(date==null){
			return null;
		}
		return BASIC_DATE_FORMAT.format(date);
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		Timestamp date = rs.getTimestamp(columnIndex);
		if(date==null){
			return null;
		}
		return BASIC_DATE_FORMAT.format(date);
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		Timestamp date = cs.getTimestamp(columnIndex);
		if(date==null){
			return null;
		}
		return BASIC_DATE_FORMAT.format(date);
	}

}
