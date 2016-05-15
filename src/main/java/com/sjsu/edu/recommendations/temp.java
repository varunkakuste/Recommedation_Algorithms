package com.sjsu.edu.recommendations;



import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;


public class temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				try {
					DataModel dm = new FileDataModel(new File("C:\\Users\\Bharat\\Downloads\\datasettemp.csv"));
					
					ItemSimilarity sim = new LogLikelihoodSimilarity(dm);
					//TanimotoCoefficientSimilarity  = new TanimotoCoefficientSimilarity					
					//ItemSimilarity  = new PearsonCorrelationSimilarity(
					
					GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);
					 
				
					
						List<RecommendedItem>recommendations = recommender.recommend(2, 2);
						System.out.println(recommender.mostSimilarItems(12, 2));
						
						for(RecommendedItem recommendation : recommendations) {
							System.out.println(recommendation.getItemID() + "," + recommendation.getValue());
						
					}
								
					
					
				} catch (Exception e) {
					System.out.println("There was an error.");
					e.printStackTrace();
				}
				

			}
		
		
	

}
