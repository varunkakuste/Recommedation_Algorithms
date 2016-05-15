package com.sjsu.edu.recommendations;

import java.net.UnknownHostException;

import com.mongodb.MongoException;


public class JobRecommendations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	
			JobRecommendationBasedOnUserProfile generateRecommendations = new JobRecommendationBasedOnUserProfile();
			generateRecommendations.addUserProfile();
			DashboardData db = new DashboardData();
			System.out.println(db.getDashBoardData(10018450).getNoOfAppliedJobs());
			System.out.println(db.getDashBoardData(10018450).getNoOfRecommendedJobs());
			System.out.println(db.getDashBoardData(10018450).getNoOfRecommendedSkills());
			System.out.println(db.getDashBoardData(10018450).getNoOfSavedJobs());
			try {
			ExistingSkills getExistinSkills = new ExistingSkills();
			getRecommendedJobsBean getRecommendedJobBean = new getRecommendedJobsBean();
			getRecommendedJobBean.getRecommendedJobData();
			
				getExistinSkills.getExistingSkills(10018450);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MongoException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
	}

}
