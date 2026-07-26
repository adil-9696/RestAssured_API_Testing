package com.api.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.api.database.DataManagerHCP;
import com.api.database.DatabaseManager;
import com.database.models.MapJobProblemModel;

public class MapJobProblemDao {

	private static final String SQL_QUERY = """
			select * from map_job_problem where tr_job_head_id=?;
			""";

	public static MapJobProblemModel getProbleminfo(int tr_job_head_id) {

		Connection conn = DataManagerHCP.getConnection();
		MapJobProblemModel model=null;

		try {
			PreparedStatement statement = conn.prepareStatement(SQL_QUERY);
			statement.setInt(1, tr_job_head_id);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				model = new MapJobProblemModel(result.getInt("id"), result.getInt("tr_job_head_id"),
						result.getInt("mst_problem_id"), result.getString("remark"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}

}
