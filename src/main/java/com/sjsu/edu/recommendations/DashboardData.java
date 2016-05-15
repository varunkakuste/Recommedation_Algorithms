package com.sjsu.edu.recommendations;

import java.net.UnknownHostException;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;

public class DashboardData {

	final DashboardBean db = new DashboardBean();
	final MongoDBConnection mongodb = new MongoDBConnection();
	DBCollection dbobj = null;
	DBCursor dbCursor = null;

	public DashboardBean getDashBoardData(long userID) {
		try {

			long jobCount = getRecommendedJobCount(userID);
			long skillCount = getRecommendedSkillCount(userID);
			long appliedJobcount = getAppliedJobCount(userID);
			long savedJobCount = getSavededJobCount(userID);

			db.setNoOfRecommendedJobs(jobCount);
			db.setNoOfRecommendedSkills(skillCount);
			db.setNoOfAppliedJobs(appliedJobcount);
			db.setNoOfSavedJobs(savedJobCount);

		} catch (Exception e) {

		}
		return db;

	}

	public long getRecommendedJobCount(long userId)
			throws UnknownHostException, MongoException {
		dbobj = mongodb.getCollection("JobsRecommendations");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("user_id", userId);
		dbCursor = dbobj.find(whereQuery);
		BasicDBList jobCount = new BasicDBList();
		while (dbCursor.hasNext()) {
			jobCount = (BasicDBList) dbCursor.next().get("recommendedJobs");
		}

		return jobCount.size();

	}

	public long getRecommendedSkillCount(long userId)
			throws UnknownHostException, MongoException {

		dbobj = mongodb.getCollection("SkillsRecommendations");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("user_id", userId);
		dbCursor = dbobj.find(whereQuery);
		BasicDBList skillCount = new BasicDBList();
		while (dbCursor.hasNext()) {
			skillCount = (BasicDBList) dbCursor.next().get("recommendedSkills");
		}

		return skillCount.size();

	}

	public long getSavededJobCount(long userId) throws UnknownHostException,
			MongoException {
		dbobj = mongodb.getCollection("SavedJobs");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("user_id", userId);
		dbCursor = dbobj.find(whereQuery);
		BasicDBList savedJobCount = new BasicDBList();
		while (dbCursor.hasNext()) {
			savedJobCount = (BasicDBList) dbCursor.next().get("savedJobs");
		}

		return savedJobCount.size();

	}

	public long getAppliedJobCount(long userId) throws UnknownHostException,
			MongoException {
		dbobj = mongodb.getCollection("AppliedJobs");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("user_id", userId);
		dbCursor = dbobj.find(whereQuery);
		BasicDBList appliedJobCount = new BasicDBList();
		;
		while (dbCursor.hasNext()) {
			appliedJobCount = (BasicDBList) dbCursor.next().get("appliedJobs");
		}

		return appliedJobCount.size();

	}

}
