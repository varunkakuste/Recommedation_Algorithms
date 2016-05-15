package com.sjsu.edu.recommendations;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVStrategy;

import com.mongodb.BasicDBList;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class GenerateCSVForJobs {

	public static void main(String[] args) {
		try {
			writeCSVforJobRecommmendation();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void writeCSVforJobRecommmendation() throws IOException
	{
		
		FileWriter userJobRecommendation = new FileWriter("C:\\VARUN\\D\\SPRING_2016\\295B\\Project_Coding\\JobRecommendationInputFile.csv", true);
		CSVPrinter csvFilePrinter = null;
		//HashMap<Long,Long> userSkills = getUserSkills(userId);
		
		MongoDBConnection mongodb=new MongoDBConnection();
		DBCollection dbobj=mongodb.getCollection("Jobs");
		DBCursor cursor = dbobj.find();
		
		System.out.println("#############Cursor Count#############3333");
		System.out.println(cursor.count());

		try {
			csvFilePrinter = new CSVPrinter(userJobRecommendation, new CSVStrategy(',', '\n', ':'));

			while(cursor.hasNext())
			{
				DBObject jobSkillDetail = cursor.next();
				int jobID = (Integer)jobSkillDetail.get("JobID");
				BasicDBList requiredSkills = (BasicDBList)jobSkillDetail.get("RequiredSkills");
				System.out.println("#############Required Skills#############3333");
				System.out.println(requiredSkills);
				for(Object i : requiredSkills)
				{
				
				csvFilePrinter.print(String.valueOf((int) jobID));
				csvFilePrinter.print(""+i);
				csvFilePrinter.print(""+1);
				csvFilePrinter.println();
				}
			}
			System.out.println("Latest created Skill Set  Map");
			
			userJobRecommendation.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}

}
