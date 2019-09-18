//Created by Sebastian for FooDB

//created 12/09/19
//updated 16/09/19

public class FoodEntry
{
	//food name
	private String foodName;

	final int NONE = 0;

	//
	//food data
	//

	//nutrition facts
	private double[] nutritionFact;
	final int CALORIES = 0;
	final int FAT = 1;
	final int CHOLESTEROL = 2;
	final int SODIUM = 3;
	final int CARBOHYDRATE = 4;
	final int FIBER = 5;
	final int SUGAR = 6;
	final int PROTEIN = 7;
	final int POTASSIUM = 8;
	final int IRON = 9;
	final int CALCIUM = 10;
	final int VITAMIN_A = 11;
	final int VITAMIN_B6 = 12;
	final int VITAMIN_B12 = 13;
	final int VITAMIN_C = 14;
	final int VITAMIN_D = 15;
	final int VITAMIN_E = 16;
	final int nutritionFact_LENGTH = 17;
	final double CALORIES_DV = 2000;//[kcal]
	//daily value amounts (assuming 2000-calorie diet) [g]
	//source: wolfram|alpha knowledgebase
	final double FAT_DV = 65;
	final double CHOLESTEROL_DV = 300*Math.pow(10,-3);
	final double SODIUM_DV = 2.4;
	final double CARBOHYDRATE_DV = 300;
	final double FIBER_DV = 25;
	final double SUGAR_DV = 50;
	final double PROTEIN_DV = 50;
	final double POTASSIUM_DV = 4700*Math.pow(10,-3);
	final double IRON_DV = 18*Math.pow(10,-3);
	final double CALCIUM_DV = 1300*Math.pow(10,-3);
	final double VITAMIN_A_DV = 900*Math.pow(10,-6);
	final double VITAMIN_B6_DV = 2*Math.pow(10,-3);
	final double VITAMIN_B12_DV = 6*Math.pow(10,-6);
	final double VITAMIN_C_DV = 90*Math.pow(10,-3);
	final double VITAMIN_D_DV = 20*Math.pow(10,-6);
	final double VITAMIN_E_DV = 15*Math.pow(10,-3);

	//food group
	private int foodGroup;
	final int GRAINS = 0;
	final int VEGETABLES = 1;
	final int FRUITS = 2;
	final int MEATS = 3;
	final int DAIRY = 4;

	//basic taste
	private double[] basicTaste;
	final int BITTER = 0;
	final int SALTY = 1;
	final int SAVORY = 2;
	final int SOUR = 3;
	final int SWEET = 4;
	final int BASICTASTE_LENGTH = 5;

	//spiciness
	private int[] spiceLimit;
	final int LOWER = 0;//[shu]
	final int UPPER = 1;//[shu]
	final int SPICELIMIT_LENGTH = 2;

	//caffeine
	private int caffeine;//[mg]

	//gluten
	private boolean gluten;

	//allergy information
	private boolean[] allergy;
	final int ALLERGY_EGG = 0;
	final int ALLERGY_MILK = 1;
	final int ALLERGY_PEANUT = 2;
	final int ALLERGY_SEAFOOD = 3;
	final int ALLERGY_SHELLFISH = 4;
	final int ALLERGY_SOY = 5;
	final int ALLERGY_TREENUT = 6;
	final int ALLERGY_WHEAT = 7;
	final int ALLERGY_LIMIT = 8;

	//constructor
	public FoodEntry()
	{
		//default name of the food
		foodName = "unnamed";

		//default every value to zero until set otherwise
		//nutrition facts
		nutritionFact = new double[nutritionFact_LENGTH];

		//food group
		foodGroup = NONE;

		//basic taste
		basicTaste = new double[BASICTASTE_LENGTH];

		//spiciness
		spiceLimit = new int[SPICELIMIT_LENGTH];

		//caffeine
		caffeine = NONE;

		//allergy information
		allergy = new boolean[ALLERGY_LIMIT];
	}

	//
	//setters and getters
	//

	//food name
	public void setFoodName(String name)
	{
		foodName = name;
	}
	public String getFoodName()
	{
		return foodName;
	}

	//nutrition facts
	public void setOneNutritionFact(int index, int value)
	{
		nutritionFact[index] = value;
	}
	public double getOneNutritionFact(int index)
	{
		return nutritionFact[index];
	}

	//food group
	public void setFoodGroup(int group)
	{
		foodGroup = group;
	}
	public int getFoodGroup()
	{
		return foodGroup;
	}

	//basic taste
	public void setOneBasicTaste(int index, double value)
	{
		basicTaste[index] = value;
	}
	public double getOneBasicTaste(int index)
	{
		return basicTaste[index];
	}

	//spiciness
	public void setOneSpiceLimit(int index, int value)
	{
		spiceLimit[index] = value;
	}
	public int getOneSpiceLimit(int index)
	{
		return spiceLimit[index];
	}

	//caffeine
	public void setCaffeine(int value)
	{
		caffeine = value;
	}
	public int getCaffeine()
	{
		return caffeine;
	}

	//gluten
	public void setGluten(boolean value)
	{
		gluten = value;
	}
	public boolean getGluten()
	{
		return gluten;
	}

	//allergy information
	public void setOneAllergy(int index, boolean value)
	{
		allergy[index] = value;
	}
	public boolean getOneAllergy(int index)
	{
		return allergy[index];
	}
}
