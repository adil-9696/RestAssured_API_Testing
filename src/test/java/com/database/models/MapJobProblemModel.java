package com.database.models;

public class MapJobProblemModel {

	
	private int id;
	private int tr_job_head_id;
	private int mst_problem_id;
	private String remark;
	
	
	
	
	public MapJobProblemModel() {
		super();
	}




	public MapJobProblemModel(int id, int tr_job_head_id, int mst_problem_id, String remark) {
		super();
		this.id = id;
		this.tr_job_head_id = tr_job_head_id;
		this.mst_problem_id = mst_problem_id;
		this.remark = remark;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getTr_job_head_id() {
		return tr_job_head_id;
	}




	public void setTr_job_head_id(int tr_job_head_id) {
		this.tr_job_head_id = tr_job_head_id;
	}




	public int getMst_problem_id() {
		return mst_problem_id;
	}




	public void setMst_problem_id(int mst_problem_id) {
		this.mst_problem_id = mst_problem_id;
	}




	public String getRemark() {
		return remark;
	}




	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	
}
