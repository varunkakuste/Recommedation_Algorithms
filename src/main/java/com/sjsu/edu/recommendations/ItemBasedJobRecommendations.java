package com.sjsu.edu.recommendations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;


public class ItemBasedJobRecommendations {

	
	
	 DataModel jobDataModel; //= new FileDataModel(new File("C:\\Users\\Bharat\\Downloads\\dataset.csv"));
	 ItemSimilarity sim ;//= new LogLikelihoodSimilarity(jobDataModel);
	//TanimotoCoefficientSimilarity sim = new TanimotoCoefficientSimilarity(dm);
	//ItemSimilarity sim = new PearsonCorrelationSimilarity(dm);
	List<RecommendedItem> recommendations;
	GenericItemBasedRecommender recommender;// = new GenericItemBasedRecommender(jobDataModel, sim);
	 
	
	public void itemBasedJobRecommmendations() {
		// TODO Auto-generated method stub
		
		
		
		
		try {
			
			 jobDataModel = new FileDataModel(new File("C:\\Users\\Bharat\\Downloads\\dataset.csv"));
			 sim = new LogLikelihoodSimilarity(jobDataModel);
			 recommender = new GenericItemBasedRecommender(jobDataModel, sim);
			 
			
				
			
			
		} catch (Exception e) {
			System.out.println("There was an error.");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Long> getItemBasedJobRecommendations(long jobID) throws TasteException {
		
		recommendations = recommender.mostSimilarItems(11, 4);
		
		for(RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation.getItemID() + "," + recommendation.getValue());
		
	}
		return null;
				
		
		
		
		
		
	}
	
	
	
	
}
