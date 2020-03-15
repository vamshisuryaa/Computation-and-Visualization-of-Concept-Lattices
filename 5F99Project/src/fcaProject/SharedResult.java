package fcaProject;

import java.util.ArrayList;
import java.util.HashMap;

public class SharedResult {
	  public static  ArrayList<ArrayList<Integer>> concepts=new ArrayList<ArrayList<Integer>>();
	  public static  ArrayList<ArrayList<Integer>> extents=new ArrayList<ArrayList<Integer>>();
	  public static  ArrayList<ArrayList<Integer>> intents=new ArrayList<ArrayList<Integer>>();
	  public static  ArrayList<ArrayList<String>> extentsLabels=new ArrayList<ArrayList<String>>();
	  public static  ArrayList<ArrayList<String>> intentsLabels=new ArrayList<ArrayList<String>>();
	  public static ArrayList<ArrayList<String>> hasseLabels = new ArrayList<ArrayList<String>>();
	  public static ArrayList<Integer> same = new ArrayList<Integer>();
	  public static ArrayList<String> sameLabels = new ArrayList<String>();  
	  public static ArrayList<ArrayList<String>> hassenodes = new ArrayList<ArrayList<String>>();
	  public static HashMap<Integer, Integer> sameLabelsMap = new HashMap<Integer, Integer>(); 
	  public static ArrayList<ArrayList<String>> diag1nodes=new ArrayList<ArrayList<String>>();
	  public static ArrayList<ArrayList<String>> finalrelations= new ArrayList<ArrayList<String>>();
	  public static ArrayList<String> actualHasseNodes = new ArrayList<String>();	  
}
