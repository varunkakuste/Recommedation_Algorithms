package job.recommendations;


import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.*;
import org.apache.mahout.cf.taste.impl.eval.*;
import org.apache.mahout.cf.taste.impl.neighborhood.*;
import org.apache.mahout.cf.taste.impl.recommender.*;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.Preference;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;

import java.io.*;
import java.util.*;

import org.apache.mahout.common.RandomUtils;
import org.apache.mahout.math.hadoop.similarity.cooccurrence.measures.CosineSimilarity;








public class Evaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



//randomUtils is used to make sure same dataset is picked for training the model

RandomUtils.useTestSeed();

DataModel model = null;
try {
	model = new FileDataModel(new File("C:\\VARUN\\D\\SPRING_2016\\295B\\Project_Coding\\SkillPreferencces.csv"));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//*Comment: This part of the code evaluates the recommender system

RecommenderBuilder builder = new RecommenderBuilder() 

{



public Recommender buildRecommender(DataModel model) throws TasteException {

//*Comment: Following are the item similarities we used for evaluating the model.

//LogLikelihoodSimilarity sim = new LogLikelihoodSimilarity(model);
	 UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(model);
   	//System.out.println(userSimilarity.userSimilarity(10018450, 1));
		//UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.0, userSimilarity, model);
		  NearestNUserNeighborhood userneighborhood1 = new NearestNUserNeighborhood(2, userSimilarity, model);
	      
		//System.out.println(neighborhood.getUserNeighborhood(10018450));
		Recommender recommender = new GenericUserBasedRecommender(model, userneighborhood1, userSimilarity);


PearsonCorrelationSimilarity sim = new PearsonCorrelationSimilarity(model);

//TanimotoCoefficientSimilarity sim = new TanimotoCoefficientSimilarity(model);

//EuclideanDistanceSimilarity sim = new EuclideanDistanceSimilarity(model);


return recommender;
//return new GenericItemBasedRecommender(model, sim);

}

};

//*Comment: Following are the two recommender evaluators we used for building the comparison matrix

//RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();

RecommenderEvaluator evaluator = new RMSRecommenderEvaluator();

//*Comment Results of prediction

double result = 0.0;
try {
	result = evaluator.evaluate(builder, null, model, 0.7, 1.0);
} catch (TasteException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

System.out.println(result);		
	}

}
