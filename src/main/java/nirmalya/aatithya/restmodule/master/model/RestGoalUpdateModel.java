package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestGoalUpdateModel {
	private String name;
	private String designation;
	private String goalId;
	private String goal;
	private String expectedResults;
	private String weightage;
	private String selfReview;
	private String managersReview;
	private String summary;
	private String recommendation;
	private String finalRating;
	private String promotion;
	private String designationTitle;
	private String bandId;
	private String band;
	private String ratings;
	public RestGoalUpdateModel() {
		super();
	}
	public RestGoalUpdateModel(Object goalId,Object goal,Object expectedResults,Object weightage,Object selfReview,
			Object managersReview,Object summary,Object recommendation,Object finalRating) {
		super();
		this.goalId = (String) goalId;
		this.goal = (String) goal;
		this.expectedResults = (String) expectedResults;
		this.weightage = (String) weightage;
		this.selfReview = (String) selfReview;
		this.managersReview = (String) managersReview;
		this.summary = (String) summary;
		this.recommendation = (String) recommendation;
		this.finalRating = (String) finalRating;
	}
	public RestGoalUpdateModel(Object bandId,Object band,Object designation,
			Object designationTitle) {
		super();
		this.bandId = (String) bandId;
		this.band = (String) band;
		this.designation = (String) designation;
		this.designationTitle = (String) designationTitle;
	}
	public RestGoalUpdateModel(Object recommendation,Object finalRating,Object promotion,
			Object designationTitle,Object ratings) {
		super();
		this.recommendation = (String) recommendation;
		this.finalRating = (String) finalRating;
		this.promotion = (String) promotion;
		this.designationTitle = (String) designationTitle;
		this.ratings = (String) ratings;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGoalId() {
		return goalId;
	}
	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getExpectedResults() {
		return expectedResults;
	}
	public void setExpectedResults(String expectedResults) {
		this.expectedResults = expectedResults;
	}
	public String getWeightage() {
		return weightage;
	}
	public void setWeightage(String weightage) {
		this.weightage = weightage;
	}
	public String getSelfReview() {
		return selfReview;
	}
	public void setSelfReview(String selfReview) {
		this.selfReview = selfReview;
	}
	public String getManagersReview() {
		return managersReview;
	}
	public void setManagersReview(String managersReview) {
		this.managersReview = managersReview;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getFinalRating() {
		return finalRating;
	}
	public void setFinalRating(String finalRating) {
		this.finalRating = finalRating;
	}
	
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getDesignationTitle() {
		return designationTitle;
	}
	public void setDesignationTitle(String designationTitle) {
		this.designationTitle = designationTitle;
	}
	public String getBandId() {
		return bandId;
	}
	public void setBandId(String bandId) {
		this.bandId = bandId;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}
}
