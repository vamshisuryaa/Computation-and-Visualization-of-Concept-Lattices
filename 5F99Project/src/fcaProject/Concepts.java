package fcaProject;

import java.util.*;


public class Concepts {


	public void Extents(int array[][])
	{
		
		/*System.out.println();
		System.out.println("=================================================================================");
		System.out.println("FORMAL CONCEPT ANALYSIS APPROACH");
		System.out.println("=================================================================================");
		System.out.println();
		*/	
		
		
		//Copying array items to lists
		
		ArrayList<ArrayList<Integer>> manylists = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> templist=new ArrayList<Integer>();
		
		/*System.out.println("=================================================================================");
		System.out.println("Copying Array items to lists");
		System.out.println("=================================================================================");
	*/
		for (int i=0;i<array.length;i++)
		{
			for(int j=0;j<array[0].length;j++)
			{
				templist.add(array[i][j]);
			}
			manylists.add(new ArrayList<Integer>());
			manylists.get(i).addAll(templist);
			templist.clear();
			}
		// System.out.println(manylists.size());
		//System.out.println(manylists);

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//		
		
		ArrayList<ArrayList<Integer>> extents = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> intents = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> extentstemp=new ArrayList<Integer>();
		
		for(int i=0;i<array[0].length;i++)
		{
			for(int j=0;j<array.length;j++)
			{
					if(array[j][i]==1)
					{
						extentstemp.add(j+1);
					}
					else
						continue;
			}
		
		//	extents.add(new ArrayList<Integer>());
			extents.add(new ArrayList<Integer> (extentstemp));
			ArrayList<Integer> intent4extent=intents(extentstemp,manylists);
			intents.add(intent4extent);
			//System.out.println(extentstemp);
			extentstemp.clear();
		}
		//System.out.println("=================================================================================");
		//System.out.println("Extents directly from Object- Attribute table");
		//System.out.println("=================================================================================");
		
		//System.out.println(extents);
		
		
		//Adding a full set for intents if extent is empty
		ArrayList<Integer> temp2= new ArrayList<Integer>();
		for(int m=0;m<array[0].length;m++)
		{
			temp2.add(m+1);
		}

				
		// Computing Extents and their intersections
			int i=0;
			while(i != extents.size())
			{
				for(int j=0;j<extents.size();j++)
				{
					ArrayList<Integer> intersection=new ArrayList<Integer>(extents.get(i));
					intersection.retainAll(extents.get(j));
					if(intersection.size()>0)
					{
						if(extents.contains(intersection))
						{
							continue;
						}
						else
						{
							extents.add(new ArrayList<Integer>(intersection));
						ArrayList<Integer> intent4extent=intents(intersection,manylists);
						if(intent4extent.size()==0)
						{
							intents.add(new ArrayList<Integer>());
						}
						else
						{
							intents.add(intent4extent);
						}
					}
				}
					else if(intersection.isEmpty() && !extents.contains(intersection))
					{
						extents.add(new ArrayList<Integer>());
						intents.add(temp2);
						
					}
				}
				i++;
			}
			
			
			

			//Adding a full set if not already present for extents
			ArrayList<Integer> temp1=new ArrayList<Integer>();
			
			for(int m=0;m<array.length;m++)
			{
				temp1.add(m+1);
			}
			
			
			if(extents.contains(temp1)) 
			{
				}
			else {
			extents.add(new ArrayList<Integer>(temp1));
			intents.add(new ArrayList<Integer>());
			}
			
			  //Converting arraylists to hashsets for extents
			
			 LinkedHashSet<ArrayList<Integer>> myextents=new LinkedHashSet<ArrayList<Integer>>();
			 ArrayList<ArrayList<Integer>> extentsForDiagram=new ArrayList<ArrayList<Integer>>();
			  
			  for(int a=0;a<extents.size();a++)
			  {
				  myextents.add(new ArrayList<Integer>(extents.get(a)));
				  if(!extentsForDiagram.contains(extents.get(a)))
					  extentsForDiagram.add(extents.get(a));
			  }
			  SharedResult.extents = extentsForDiagram;
		
			  
		//	 System.out.println(SharedResult.extents);
			
		
			
			
			 //Converting arraylists to hashsets for intents
			  LinkedHashSet<ArrayList<Integer>> myintents=new LinkedHashSet<ArrayList<Integer>>();
			  ArrayList<ArrayList<Integer>> intentsForDiagram=new ArrayList<ArrayList<Integer>>();
			  
			 
			  for(int b=0;b<intents.size();b++)
			  {
				  myintents.add(new ArrayList<Integer>(intents.get(b)));
				  if(!intentsForDiagram.contains(intents.get(b)))
					  intentsForDiagram.add(intents.get(b));
			  }
			  SharedResult.intents = intentsForDiagram;
			  
		//	  System.out.println("==================Intents for Diagram====================");
		//	  System.out.println(intentsForDiagram);
			  
		
			//  System.out.println(myintents);

			
		/*	System.out.println("=================================================================================");
			System.out.println("Extents for this example before converting to Linked HashSets : ");
			System.out.println("=================================================================================");
			System.out.println(extents);
			System.out.println("=================================================================================");
			System.out.println("Intents for this example before converting to Linked HashSets :");
			System.out.println("=================================================================================");
			System.out.println(intents);
		 */
			
			/*System.out.println("=================================================================================");
			System.out.println("Extents : ");
			System.out.println("=================================================================================");
			System.out.println(myextents);
			//System.out.println(SharedResult.extents);
				
				
				
			System.out.println("=================================================================================");
			System.out.println("Intents :");
			System.out.println("=================================================================================");
			System.out.println(myintents);
			
			//	ConceptLattice cl=new ConceptLattice();
			//cl.getExtentsandIntents(myextents,myintents);
*/
			
			
}

	
	//Computing Intents for each extent 
	private ArrayList<Integer> intents(ArrayList<Integer> intersection, ArrayList<ArrayList<Integer>> manylists) 
	{
		ArrayList<ArrayList<Integer>> all=new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp=new ArrayList<Integer>();
			
		int i=0;
		while(i!= intersection.size())
		{
			for(int j=0;j<manylists.get(i).size();j++)
			{
					if(manylists.get((intersection.get(i)-1)).get(j)==1)
					{
						temp.add(j+1);
					}
					else
						continue;
					
				}
			all.add(new ArrayList<Integer>(temp));
			temp.clear();
			i++;
			}
		
			
		ArrayList<Integer> intent=new ArrayList<Integer>();
		
		if(all.size()>0) {
		 intent=new ArrayList<Integer>(all.get(0));
		}
		
		//Intersections of each and every element from extents 
		for(int m=1;m<all.size();m++)
		{
			intent.retainAll(all.get(m));
		}
		
		return intent;
		
		
	}
}

