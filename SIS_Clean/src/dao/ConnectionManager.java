package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionManager {
	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/SIS";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection connection = null;
		Class.forName(DRIVER_NAME);
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return connection;
	}

	private PreparedStatement getPreparedStatement(String query,
			ArrayList<Parameter> params, Connection connection)
			throws SQLException {

		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(query);
		if (params != null) {
			for (int i = 0; i < params.size(); i++) {
				addParameterToPS(i + 1, preparedStatement, params.get(i));
			}
		}
		return preparedStatement;
	}

	public ResultSet executeQuery(String query, ArrayList<Parameter> params) {
		ResultSet rs = null;
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement preparedStatement = getPreparedStatement(query,
					params, connection);
			rs = preparedStatement.executeQuery();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void executeUpdate(String query, ArrayList<Parameter> params) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement preparedStatement = getPreparedStatement(query,
					params, connection);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void addParameterToPS(int index, PreparedStatement ps,
			Parameter param) throws SQLException {
		switch (param.getParamType()) {
		case INT:
			ps.setInt(index, (Integer) param.getParamValue());
			break;
		case STRING:
			ps.setString(index, param.getParamValue().toString());
		}
	}
}

class Parameter<T> {
	private T paramValue;
	private PARAMETER_TYPE type;

	public Parameter(T val, PARAMETER_TYPE pt) {
		paramValue = val;
		type = pt;
	}

	public T getParamValue() {
		return paramValue;
	}

	public PARAMETER_TYPE getParamType() {
		return type;
	}
}

enum PARAMETER_TYPE {
	INT, STRING
}