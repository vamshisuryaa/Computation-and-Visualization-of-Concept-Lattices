 package fcaProject;

import java.util.*;


public class TablesClass {
	
	
	//Object-Object method
	
	public int[][] objecttable(int array[][])
	{
		int x=array.length;
		int ootable[][]=new int[x][x];

	/*	System.out.println();
		System.out.println("=================================================================================");
		System.out.println("PARTIAL ORDER OF PRIMITIVE CONCEPTS APPROACH");
		System.out.println("=================================================================================");
		System.out.println();
		*/
		
		
		//Setting all diagonal elements of object-object table to 1 and others to 0
		//System.out.println("=================================================================================");
		//System.out.println("Array formed after setting diagonal elements to 1 for object-object table");
		//System.out.println("=================================================================================");
		for(int row=0;row<ootable.length;row++) 
		{
			for(int column=0;column<ootable[row].length;column++) 
			{
				if(row==column)
					ootable[row][column]=1;
				else
					ootable[row][column]=0;
			
		//System.out.print(ootable[row][column]+"\t");
			}
		//System.out.println();
		}
		
	//Forward comparison of elements to form Upper Triangular Matrix of object-object table	
		for(int row=0;row<ootable.length;row++) 
		{
			for(int column=row+1;column<ootable[row].length;column++) 
			{
				if(row==column) {
					continue;
				}
				else {
					int val=1;                                                                                                                                                          
					for(int k=0;k<array[0].length;k++) 
					{
						if(array[row][k]==0 && array[column][k]==1) 
						{
							val=0;
							break;
						}
						else
						{
							continue;
						}
						
					}
					ootable[row][column]=val;
				}
				
			}
		}
		//Reverse comparison of elements to form lower triangular matrix of object-object table
		for(int row=0;row<ootable.length;row++) 
		{
			for(int column=row+1;column<ootable.length;column++)
			{
				if(row==column)
				{
					continue;
				}
				else
				{
					int val =1;
					for(int k=0;k<array[0].length;k++)
					{
						if(array[column][k]==0 && array[row][k]==1)
						{
							val=0;
							break;
						}
						else
						{
							continue;
						}
					}
					ootable[column][row]=val;
				}
			}
		}
		
	//	int [][] copy= Arrays.stream(ootable).map(int []::clone).toArray(int [][]::new);	
		
		
		//Printing the elements of object-object table to the screen
		System.out.println("==============================================");
		System.out.println("OBJECT - OBJECT TABLE:");
		System.out.println("==============================================");
		for(int row=0;row<ootable.length;row++)
		{
			for(int column=0;column<ootable[row].length;column++)
			{
				System.out.print(ootable[row][column]+"\t");
			}
			System.out.println();
		}
		return ootable;
	}	
		
	
	
		//Attribute-Attribute method
		
	
		public int[][] attributetable(int array[][]) {
		int y=array[0].length;
		int aatable[][]=new int[y][y];
		
		//Setting all diagonal elements of object-object table to 1 and others to 0
		//System.out.println("======================================================================================");
		//System.out.println("Array formed after setting diagonal elements to 1 for attribute-attribute table");
		//System.out.println("======================================================================================");
		for(int row=0;row<aatable.length;row++) 
		{
			for(int column=0;column<aatable[row].length;column++) 
			{
				if(row==column)
					aatable[row][column]=1;
				else
					aatable[row][column]=0;
			
		//System.out.print(aatable[row][column]+"\t");
			}
		//System.out.println();
		}
		
		
		//Forward comparison of elements to form upper triangular matrix of attribute-attribute table
		for(int row=0;row<aatable.length;row++)
		{
			for(int column=row+1;column<aatable[row].length;column++)                                                                           
			{
				if(row==column)
				{ 
					continue;
				}
				else
				{
					int val=1;
					for(int k=0;k<array.length;k++)
					{
						if(array[k][row]==1 && array[k][column]==0) 
						{
							val=0;
							break;
						}
						else
						{
							val=1;
						}
					}
					aatable[row][column]=val;
				}
			}
		}
		
		//Reverse comparison of elements to form lower triangular matrix of attribute-attribute table
		for(int row=0;row<aatable.length;row++) 
		{
			for(int column=row+1;column<aatable[row].length;column++)  
			{
				if(row==column)
				{
					continue;
				}
				else
				{
					int val =1;
					for(int k=0;k<array.length;k++)
					{
						if(array[k][column]==1 && array[k][row]==0)
						{
							val=0;
							break;
						}
						else
						{
							continue;
						}
					}
					aatable[column][row]=val;
				}
			}
		}
			
		System.out.println("===========================================");
		System.out.println("ATTRIBUTE - ATTRIBUTE TABLE:");
		System.out.println("===========================================");
			for(int row=0;row<aatable.length;row++)
			{
			for(int column=0;column<aatable[row].length;column++)
			{
				System.out.print(aatable[row][column]+"\t");
			}
			System.out.println();
		}
			return aatable;
		
	}
		
			//Attribute-Object method
				public int[][] attributeobjecttable(int array[][]) 
				{
					int x=array.length;
					int y=array[0].length;
					
					//Creating an array of dimensions attributes(rows) * objects(columns)
					int aotable[][]=new int[y][x];
					
					for(int i=0;i<array.length;i++)
					{
						for(int j=0;j<array[0].length;j++)
						{
							int val=1;
							ArrayList<Integer> oPrime=new ArrayList<Integer>();
							ArrayList<Integer> aPrime=new ArrayList<Integer>();
							ArrayList<Integer> temp1=new ArrayList<Integer>();
							ArrayList<Integer> temp2=new ArrayList<Integer>();
							
										for(int k=0;k<array[0].length;k++ )
										{
											temp1.add(array[i][k]);
										}
										aPrime=getAprime(temp1);
										//System.out.println("elements of aPrime list are"+aPrime);
									
										for(int l=0;l<array.length;l++)
										{
										temp2.add(array[l][j]);
										}
										oPrime=getOprime(temp2);
										//System.out.println("elements of oPrime list are"+oPrime);
						
							for(Integer a: aPrime )
							{
								for(Integer o:oPrime)
								{
								
									if(array[o][a]!=1)
									{
									//System.out.printf("comparisons between %d\t%d:", o,a);
									
										val=0;
										break;
									}
									else
									{
										continue;
									}
								}
							}
							aotable[j][i]=val;
						}
						
						
					}
					
					
					System.out.println("==========================================================================");
					System.out.println("ATTRIBUTE - OBJECT TABLE:");
					System.out.println("===========================================================================");
						
					for(int row=0;row<aotable.length;row++)
						{
						for(int column=0;column<aotable[row].length;column++)
						{
							System.out.print(aotable[row][column]+"\t");
						}
						System.out.println();
					}
						return aotable;
							
				}
					
					//method to determine the Object primes
					public ArrayList<Integer> getOprime(ArrayList<Integer> arr) 
					{
						ArrayList<Integer> trueA=new ArrayList<Integer>();
						
						for(int i=0;i<arr.size();i++)
							{
								if(arr.get(i)==1)
								{
									trueA.add(i);
								}
							//	System.out.println("elements of trueA list are"+trueA);
							}
						return trueA;
						}
						
					
					//method to determine the Attribute primes
					public ArrayList<Integer> getAprime(ArrayList<Integer> arr)
					{
						ArrayList<Integer> trueO=new ArrayList<Integer>();
						
						for(int i=0;i<arr.size();i++)
						{
								if(arr.get(i)==1)
								{
									trueO.add(i);
								}
							}
						return trueO;
					}		
			
				
					
				//MERGING ALL THE FOUR ARRAYS	
					
					public int[][] mergeaarray(int array[][],int ootable[][],int aatable[][],int aotable[][]) {
					int mergetable[][]=new int[ootable.length+aatable.length][ootable.length+aatable.length];
					
				//Adding object-object table to Union array 
							for(int m=0;m<ootable.length;m++)
							{
								for(int n=0;n<ootable[0].length;n++)
								{
									mergetable[m][n]=ootable[m][n];
								}
							}
							
					
				//Adding object-attribute table to Union array	
							
						for(int m=0;m<array.length;m++) 
							{
								for(int n=0;n<array[0].length;n++)
								{
									mergetable[m][ootable.length+n]=array[m][n];
								}
							}
						
					
				//Adding attribute-object table to Union array		
							
					for(int m=0;m<aotable.length;m++) 
					{
						for(int n=0;n<aotable[0].length;n++)
						{
							mergetable[m+ootable.length][n]=aotable[m][n];
						}
					}
					
				//Adding attribute-attribute table to Union array			
					
					for(int m=0;m<aatable.length;m++) 
					{
						for(int n=0;n<aatable[0].length;n++)
						{
							mergetable[m+ootable.length][n+ootable.length]=aatable[m][n];
						}
					}
					
					//Printing the elements of Union of four Arrays table to the screen
					
						System.out.println("=======================================================================");
						System.out.println("UNION TABLE:");
						System.out.println("=======================================================================");
						
						for(int row=0;row<mergetable.length;row++)
						{
							for(int column=0;column<mergetable[0].length;column++)
							{
								System.out.print(mergetable[row][column]+"\t");
							}
							System.out.println();
						
						}
			
						return mergetable;
					}
					
					//Copying Merge Array to list of lists for Rows calculation
				
					public  ArrayList<ArrayList<Integer>> toListRow(int [][] mergearray)
					{
						ArrayList<ArrayList<Integer>> manylistsrow = new ArrayList<ArrayList<Integer>>();
						ArrayList<Integer> templist=new ArrayList<Integer>();
						
						//System.out.println("=================================================================================");
						//System.out.println("Copying Array items to lists");
						//System.out.println("=================================================================================");
					
						for (int i=0;i<mergearray.length;i++)
						{
							for(int j=0;j<mergearray[0].length;j++)
							{
								templist.add(mergearray[i][j]);
							}
							manylistsrow.add(new ArrayList<Integer>());
							manylistsrow.get(i).addAll(templist);
							templist.clear();
							}
						// System.out.println(manylists.size());
						//System.out.println(manylists);
						return manylistsrow;
						
					}
					
			/*		public  ArrayList<ArrayList<Integer>> toListColumn(int [][] mergearray)
					{
						ArrayList<ArrayList<Integer>> manylistscolumn = new ArrayList<ArrayList<Integer>>();
						ArrayList<Integer> templist=new ArrayList<Integer>();
						
						//System.out.println("=================================================================================");
						//System.out.println("Copying Array items to lists");
						//System.out.println("=================================================================================");
					
						for (int i=0;i<mergearray[0].length;i++)
						{
							for(int j=0;j<mergearray.length;j++)
							{
								templist.add(mergearray[j][i]);
							}
							manylistscolumn.add(new ArrayList<Integer>());
							manylistscolumn.get(i).addAll(templist);
							templist.clear();
							}
						// System.out.println(manylists.size());
						//System.out.println(manylists);
						return manylistscolumn;
						
					}*/
					
					//Removing duplicate lists from list of lists for Row
					
					public LinkedHashSet<ArrayList<Integer>> duprows(ArrayList<ArrayList<Integer>> allLists)
					{
							
						ArrayList<Integer> temp= new ArrayList<Integer>();
						
				//	System.out.println("=================================================================================");
				//	System.out.println("Lists after clearing duplicate lists");
				//	System.out.println("=================================================================================");
						
						for(int i=0;i<allLists.size();i++)
						{
							for(int j=0;j<allLists.size();j++)
							{
								if(i!=j && allLists.get(i).equals(allLists.get(j)) && !allLists.get(i).isEmpty() && !allLists.get(j).isEmpty())
								{
								//	System.out.printf(" row %d and row %d  are equal: \n ", (i+1),(j+1));
									temp.add(i+1);
									temp.add(j+1);
								
									SharedResult.sameLabelsMap.put(i+1, j+1);
									allLists.get(j).clear();
								}

								else
									continue;
									
							};
						}
		
					//	allLists.removeIf(a -> a != null && a.isEmpty());
						System.out.println(allLists);
					//	System.out.println(temp);
						System.out.println("=================================================================================");
						System.out.println("Remaining Lists after deleting Empty lists");
						System.out.println("=================================================================================");
								
						
						for(int i=0; i<allLists.size(); i++) {          
						    for(int j=0; j<allLists.get(i).size(); j++) {
						        System.out.print(allLists.get(i).get(j) + " ");    
						    }
						    System.out.println();
						 // System.out.println(allLists.size());
						}
						
						
						//Forming sets using arraylists
						
						ArrayList<ArrayList<Integer>> allsets=new ArrayList<ArrayList<Integer>>();
						ArrayList<Integer> hs = new ArrayList<Integer>();
						
							for(int i=0; i<allLists.size(); i++)
							{  
								
						    for(int j=0; j<allLists.get(i).size(); j++) 
						    {
						      	if( allLists.get(i).get(j)==1) 
						        {   
						      		
						        	hs.add(i+1);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
						        	hs.add(j+1);
						    	    allsets.add(new ArrayList<Integer>(hs));  	    
								    hs.clear();
								    
						         }
					        else
						        	continue;
						      }
						 }
							
						
						//	System.out.println(allsets);
						 
						  
						  
				//Setting equivalence relations of same rows 
						  
						  for(int i=0;i<allsets.size();i++)
						  {
							  for(int j=0;j<allsets.get(i).size();j++)
							  {
								  for(int k=1;k<temp.size();k=k+2)
								  {
									  
									  if(allsets.get(i).get(j)==temp.get(k))
									  {
										 allsets.get(i).set(j, temp.get(k-1));
									  }
									  else
										  continue;
								  }
								  
							  }
						  }
						  
						//  System.out.println(allsets);
						  
						  //Converting arraylists to hashsets
						  
						  LinkedHashSet<ArrayList<Integer>> sets=new LinkedHashSet<ArrayList<Integer>>();
						  
						  ArrayList<ArrayList<Integer>> conceptsForHasseDiagram=new ArrayList<ArrayList<Integer>>();
						  
						  for(int i=0;i<allsets.size();i++)
						  {
							  sets.add(new ArrayList<Integer>(allsets.get(i)));
							
							  if(!conceptsForHasseDiagram.contains(allsets.get(i)))
									  conceptsForHasseDiagram.add(allsets.get(i));
						  }
						  
						  SharedResult.concepts = conceptsForHasseDiagram;
						  
						  
					//	  System.out.println(sets);
						  
						  SharedResult.same = temp;
						  
						  return sets;
						 //  return allsets;
					}			
}