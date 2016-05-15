package com.sjsu.edu.recommendations;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class SkillRecommendations {

	public static void main(String[] args) throws UnknownHostException,
			TasteException {
		// TODO Auto-generated method stub

		System.out.println("Hello World!");

		// MongoDBDataModel dbm = new MongoDBDataModel("ds019970.mlab.com",
		// 19970, "career_recommendation", "Ratings", true, true,
		// null,"Bharat","temp","user_id","item_id","preference","Ratings");
		// MongoDBDataModel dbm = new MongoDBDataModel("localhost", 27017,
		// "local", "ratings1", true, true,
		// null);//,"user_id","item_id","preference","ratings1");
		// SVDRecommender svd = new SVDRecommender(dbm, new ALSWRFactorizer(dbm,
		// 1, 0.05f, 5));
		// List<RecommendedItem> recommendations = svd.recommend(1, 10);
		// for (RecommendedItem recommendedItem : recommendations) {
		// System.out.println(recommendations);
		// }

		try {
			DataModel dbm = new FileDataModel(
					new File(
							"C:\\VARUN\\D\\SPRING_2016\\295B\\Project_Coding\\tempdata.csv"));

			// UserSimilarity userSimilarity = new
			// PearsonCorrelationSimilarity(dbm);
			// UserSimilarity userSimilarity = new LogLikelihoodSimilarity
			// (dbm);
			UserSimilarity userSimilarity = new UncenteredCosineSimilarity(dbm);
			System.out.println("##################");
			// System.out.println(userSimilarity.userSimilarity(100000000,
			// 100000001));
			// System.out.println(userSimilarity.userSimilarity(100000002,
			// 100000000));
			// System.out.println(userSimilarity.userSimilarity(100000002,
			// 100000001));
			// System.out.println(userSimilarity.userSimilarity(100000008,
			// 100000000));
			System.out.println("##################");
			// UserNeighborhood neighborhood = new
			// ThresholdUserNeighborhood(0.0, userSimilarity, dbm);
			NearestNUserNeighborhood userneighborhood1 = new NearestNUserNeighborhood(
					10, userSimilarity, dbm);

			// System.out.println(neighborhood.getUserNeighborhood(10018450));
			Recommender recommender = new GenericUserBasedRecommender(dbm,
					userneighborhood1, userSimilarity);
			// Recommender cachingRecommender = new
			// CachingRecommender(recommender);
			System.out.println("----------------------------------");
			// System.out.println(Long.valueOf("2"));
			// List<RecommendedItem> recommendations =
			// recommender.recommend(1119990, 2);
			// System.out.println(recommendations);
			// for (RecommendedItem recommendation : recommendations) {
			// System.out.println("Hi");
			// System.out.println(recommendation);
			// }
			List<RecommendedItem> recommendations;
			HashMap<Long, List<Long>> recommendedSkills = new HashMap<Long, List<Long>>();
			System.out.println(dbm.getUserIDs().hasNext());
			ArrayList<Long> userSkills = new ArrayList<Long>();
			ArrayList<Long> userSkillsInsert;

			for (LongPrimitiveIterator users = dbm.getUserIDs(); users
					.hasNext();) {
				long userId = users.nextLong();
				System.out.println(userId);
				recommendations = recommender.recommend(userId, 10);
				System.out.println("All Recommendartions " + recommendations);
				for (RecommendedItem recommendation : recommendations) {
					System.out.println("Check Here");
					System.out.println(recommendation.getItemID());
					userSkills.add(recommendation.getItemID());
					System.out.println(userSkills);
				}
				userSkillsInsert = new ArrayList<Long>(userSkills);
				recommendedSkills.put(userId, userSkillsInsert);
				userSkills.clear();

			}
			System.out.println(recommendedSkills);
			InsertSkill skills = new InsertSkill();
			skills.insertSkills(recommendedSkills);

			for (LongPrimitiveIterator users = dbm.getUserIDs(); users
					.hasNext();) {
				long userId = users.nextLong();
				System.out.println("Hello  "
						+ skills.getRecommendedSkills(userId));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
