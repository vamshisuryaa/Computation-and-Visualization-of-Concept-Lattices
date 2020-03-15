package fcaProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.*;
import org.latdraw.diagram.Diagram;
import org.latdraw.fca.ConceptLattice;
import org.latdraw.orderedset.*;
import diagramsPackage.ConceptDiagram;
import diagramsPackage.PartialOrderOfPrimitiveConcepts;
import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.FileWriter;
import java.awt.Insets;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainClass extends JFrame {
	public MainClass() {
	}

	private static final long serialVersionUID = 1L;
	private static  JScrollPane jScrollPane;
	private static JScrollPane jScrollPaneATR;
	static String temp;
	static int objlength, atrlength;
	static ArrayList<String> objectnames = new ArrayList<String>();
	static ArrayList<String> attributenames = new ArrayList<String>();
	private static int[][] newNorm;
	static JPanel panell = new JPanel();
	static Integer indexer = 1;
	static List<JLabel> listOfLabels = new ArrayList<JLabel>();
	static List<JTextField> listOfTextFields = new ArrayList<JTextField>();
	static JPanel panellATR = new JPanel();
	static Integer indexerATR = 1;
	static List<JLabel> listOfLabelsATR = new ArrayList<JLabel>();
	static List<JTextField> listOfTextFieldsATR = new ArrayList<JTextField>();
	static JFrame frameObj;
	static JFrame frameATR;
	static JMenuBar menuBar;
	static JMenu filemenu, editmenu;
	static JMenu editsubmenu;
	static JMenu memu;
	static JMenuItem menuItem;
	static JMenuItem menuItem1;
	static JFrame tempframe;
	static  int count=0;
	static int inc=0;
   private static JFrame tableframe; 
   private static JFrame tableframe2; 
   static int array0 [][] = null;
   static int arraytest [][] = null;
   
	static MainClass mn = new MainClass();
	static MainClass p= new MainClass();
	static MainClass q= new MainClass();
	static MainClass menuthread= new MainClass();
	

	
	//Set the Destination Address of the CSV output file here
	static String OutputCSVAddress = "C:\\Users\\surya\\Desktop\\csv\\output.csv";

	 
	
	public static void main(String[] args) throws NonOrderedSetException, InterruptedException, IOException {
		
		 /* FOR OBJECTS */
	
		// Construct frame for objects
		frameObj = new JFrame();
		frameObj.getContentPane().setLayout(new GridBagLayout());
		frameObj.setPreferredSize(new Dimension(900, 900));
		frameObj.setTitle("ENTER THE NAMES OF OBJECTS HERE");
		//frameObj.setVisible(true);
		frameObj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

		// Frame constraints for objects
		GridBagConstraints frameConstraints = new GridBagConstraints();
		GridBagConstraints frameConstraints1 = new GridBagConstraints();

		// Construct button for objects
		JButton addButton = new JButton("ADD OBJECT");
		JButton saveButton = new JButton("SAVE AND CLOSE");
		saveButton.setPreferredSize(new Dimension(300,70));
		addButton.setPreferredSize(new Dimension(300,70));
		addButton.setSize(500, 500);
		saveButton.setSize(500,500);
		addButton.addActionListener(new ButtonListener1Obj());
		saveButton.addActionListener(new ButtonListenerObj());

		// Add button to frame for objects
		frameConstraints.gridx = 0;
		frameConstraints.gridy = 0;
		frameConstraints1.gridx = 0;
		frameConstraints1.gridy = 5;

		frameObj.getContentPane().add(addButton, frameConstraints);
		frameObj.getContentPane().add(saveButton, frameConstraints1);

		// Construct panel
		panell.setPreferredSize(new Dimension(820, 820));
		panell.setLayout(new GridBagLayout());
		panell.setBorder(LineBorder.createBlackLineBorder());
		panell.setBackground(new Color(169, 169, 169));

		frameObj.getContentPane().setBackground(new Color(235,245,225));
		

		jScrollPane = new JScrollPane(panell,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane.setPreferredSize(new Dimension(550,550));
	

		

		// Add panel to frame for objects
		frameConstraints.gridx = 0;
		frameConstraints.gridy = 1;
		frameConstraints.weighty = 1;
		frameObj.getContentPane().add(jScrollPane, frameConstraints);


		// Pack frame for objects
		frameObj.pack();

		frameObj.setLocationRelativeTo(null);
		// Make frame visible for objects
		

		/* FOR ATTRIBUTES */

		// Construct frame for attributes
		frameATR = new JFrame();
		frameATR.getContentPane().setLayout(new GridBagLayout());
		frameATR.setPreferredSize(new Dimension(900, 900));
		frameATR.setTitle("ENTER THE NAMES OF  ATTRIBUTES HERE");
		frameATR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Frame constraints for attributes
		GridBagConstraints frameConstraintsATR = new GridBagConstraints();
		GridBagConstraints frameConstraintsATR1 = new GridBagConstraints();

		// Construct button for attributes
		JButton addButtonATR = new JButton("ADD ATTRIBUTE");
		JButton saveButtonATR = new JButton("SAVE AND CLOSE");
		
		addButtonATR.setPreferredSize(new Dimension(300,70));
		saveButtonATR.setPreferredSize(new Dimension(300,70));
		addButtonATR.addActionListener(new ButtonListener1ATR());
		saveButtonATR.addActionListener(new ButtonListenerATR());

		// Add button to frame for attributes
		frameConstraintsATR.gridx = 0;
		frameConstraintsATR.gridy = 0;
		frameConstraintsATR1.gridx = 0;
		frameConstraintsATR1.gridy = 5;
		frameATR.getContentPane().add(addButtonATR, frameConstraintsATR);
		frameATR.getContentPane().add(saveButtonATR, frameConstraintsATR1);

		// Construct panel for attributes
		panellATR.setPreferredSize(new Dimension(820, 820));
		panellATR.setLayout(new GridBagLayout());
		panellATR.setBorder(LineBorder.createBlackLineBorder());
		
		panellATR.setBackground(new Color(169, 169, 169));
		
		frameATR.getContentPane().setBackground(new Color(235,245,225));

		
		jScrollPaneATR = new JScrollPane(panellATR,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPaneATR.setPreferredSize(new Dimension(550, 550));

		
		// Add panel to frame for attributes
		frameConstraints.gridx = 0;
		frameConstraints.gridy = 1;
		frameConstraints.weighty = 1;
		frameATR.getContentPane().add(jScrollPaneATR, frameConstraints);

		// Pack frame for attributes
		frameATR.pack();

		// Make frame visible for attributes
		frameATR.setLocationRelativeTo(null);
		//frameATR.setVisible(true);

		tempframe = new JFrame("SELECT HOW YOU WANT TO INPUT DATA?");
		tempframe.setVisible(true);
		tempframe.setSize(500,200);
		tempframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		  JPanel panel = new JPanel();
		  tempframe.getContentPane().add(panel);
		  JButton buttonp = new JButton("INPUT DATA MANUALLY");
		  buttonp.setForeground(new Color(69,69	,69));
		  buttonp.setPreferredSize(new Dimension(300,70));
		  panel.add(buttonp);
		  JButton button2p = new JButton("INPUT A CSV DATA FILE");
		  button2p.setPreferredSize(new Dimension(300,70));
		  panel.add(button2p);
		  tempframe.setLocationRelativeTo(null);

		  panel.setBackground(new Color(239,222,205));
		  //panel.setBackground(new Color(69,69	,69));
		  
			 buttonp.addActionListener(new ActionListener(){
		        	@Override
		        	public void actionPerformed(ActionEvent arg0)
		        	{
		        		
		        		objectnames.clear();
		        		attributenames.clear();
		        		panell.removeAll();
		        		panellATR.removeAll();
		        		frameObj.show();
		        		tempframe.dispose();
						
		        	}
		        
			 });
			 
			 button2p.addActionListener(new ActionListener(){
		        	@Override
		        	public void actionPerformed(ActionEvent arg0)
		        	{
			       		p.GUI(array0);
		        		tableframe.show();
		        		tempframe.dispose();		
			}
			 });
	 
		}
	private int[][] GUI(int a[][]) {

		int[][] initial = new int[objlength][atrlength];
		int[][] array1 = new int[objlength][atrlength];

		for (int i = 0; i < objlength; i++) {
			for (int j = 0; j < atrlength; j++) {
				initial[i][j] = 0;
			}
		}

		Object[] columns;
		columns = objectnames.toArray();
		// System.out.println(columns);

		Object[] attributes;
		attributes = attributenames.toArray();
		// System.out.println(attributes);

		String[] box = { "0", "1" };

		newNorm = new int[objlength][atrlength];
		
		if(a == null)
		{
			fillNewNorm(initial);
		}
		else
		{
			fillNewNorm(a);
			a=null;
		}
	
		ButtonGroup group = new ButtonGroup();

		JPanel header = new JPanel(new BorderLayout());
		header.add(new JLabel("Initially filled with:"), BorderLayout.NORTH);

		JComboBox<String> list = new JComboBox(box);
		TableModel dataModel = new AbstractTableModel() {
			@Override
			public int getColumnCount() {
				return atrlength + 1;
			}

			@Override
			public int getRowCount() {
				return objlength + 1;
			}

			@Override
			public Object getValueAt(int row, int col) {
				Object result = null;
				if (row == 0) {
					if (col == 0) {
						result = "*";
					} else {
						result = attributes[col - 1];
					}
				} else {
					if (col == 0) {
						result = columns[row - 1];
					} else {
						result = box[newNorm[row - 1][col - 1]];
					}
				}
				return result;
			}

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}

			@Override
			public Class getColumnClass(int c) {
				return String.class;
			}
		};
		JTable table = new JTable(dataModel) {
			@Override
			public void changeSelection(int row, int col, boolean toggle, boolean expand) {
				if (row != 0 && col != 0) {
					super.changeSelection(row, col, toggle, expand);
				}
			}
		};
		table.setCellSelectionEnabled(true);
		ListSelectionListener listener = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int i = table.getSelectedRow();
					int j = table.getSelectedColumn();
					if (i != -1) {
						newNorm[i - 1][j - 1] = list.getSelectedIndex();
						table.repaint();
					}
				}
			}
		};
		
		table.getSelectionModel().addListSelectionListener(listener);
		table.getColumnModel().getSelectionModel().addListSelectionListener(listener);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int col) {
				if (row == 0 || col == 0) {
					setBackground(Color.LIGHT_GRAY);
				} else {
					setBackground(Color.WHITE);
				}
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
			}
		};
		renderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, renderer);
		Font myFont = new Font("Times New Roman", Font.PLAIN, 12);
		AffineTransform affinetransform = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
		table.setFont(myFont);
	
        
		list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
			}
		});
		GridBagLayout layout = new GridBagLayout();
		JPanel dataPanel = new JPanel(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = 1;
		constraints.gridheight = 3;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.ipadx = 10;
		if (table.getPreferredSize().width > 300) {
			JScrollPane scroll = new JScrollPane(table);
			scroll.setPreferredSize(new Dimension(300, 300));
			layout.setConstraints(scroll, constraints);
			dataPanel.add(scroll);
		} else {
			layout.setConstraints(table, constraints);
			dataPanel.add(table);
		}
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.gridx = 1;
		constraints.gridy = 0;
		JLabel label = new JLabel("Current element:", JLabel.CENTER);
		layout.setConstraints(label, constraints);
		dataPanel.add(label);
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.NONE;
		layout.setConstraints(list, constraints);
		dataPanel.add(list);

		JButton resetButton = new JButton("Reset");
		group.add(resetButton);
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fillNewNorm(initial);
				table.clearSelection();
				table.repaint();
			}
		});
		JButton saveButton = new JButton("Save");
		group.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < newNorm.length; i++) {
					for (int j = 0; j < newNorm[0].length; j++) {
						array1[i][j] = newNorm[i][j];
					}
				}
				arraytest=array1;
				MainClass.save(array1);
				String path = OutputCSVAddress;
				MainClass.exportToCSV(table, path);
			}
		});

		JButton cancelButton = new JButton("Cancel");
		group.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableframe.dispose();
				
			}
		});

		JPanel buttonPanel = new JPanel();

		buttonPanel.add(resetButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);

		JPanel panel = new JPanel();
		panel.setSize(600, 600);
		panel.setLayout(new BorderLayout());
		panel.add(header, BorderLayout.NORTH);
		panel.add(dataPanel, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		
		 menuBar = new JMenuBar();

        //  Build the first menu.
		 JMenu  menu;
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("File");
        menuBar.add(menu);
        
      
        
        //  a group of JMenuItems
        menuItem = new JMenuItem("Open",KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Load the File");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent arg0)
        	{
        		
        	//	System.out.println("OPEN IS CLICKED");
        	     JFileChooser chooser = new JFileChooser();
        	   int returnvalue=chooser.showOpenDialog(null);
        	   
        	   if(returnvalue==JFileChooser.APPROVE_OPTION){
        		   {
        			   File selected= chooser.getSelectedFile();
        			  
        			   if(!(selected==null))
        				   {
        				   
        				   ArrayList<String[]> rowList = new ArrayList<String[]>();
        					try (BufferedReader br = new BufferedReader(
        							new FileReader(selected))) {
        						String line;
        						while ((line = br.readLine()) != null) {
        							String[] lineItems = line.split(",");
        							rowList.add(lineItems);
        						}
        						br.close();
        					} catch (Exception e) {
        						//For  Handling any I/O problems
        						e.printStackTrace();
        					}
        					String[][] matrix = new String[rowList.size()][];
        					for (int i = 0; i < rowList.size(); i++) {
        						String[] row = rowList.get(i);
        						matrix[i] = row;
        					}

        					/*for (int i = 0; i < matrix.length; i++) {
        						for (int j = 0; j < matrix[i].length; j++) {
        							System.out.println(matrix[i][j] + "\t");
        						}
        						System.out.println();
        					}*/

        					ArrayList<String> objname = new ArrayList<String>();
        					ArrayList<String> atrname = new ArrayList<String>();

        					for (int i = 1; i < matrix.length; i++) {
        						objname.add(matrix[i][0]);
        					}
        					//System.out.println(objname);

        					for (int i = 1; i < matrix[0].length; i++) {
        						atrname.add(matrix[0][i]);
        					}
        				//	System.out.println(atrname);

        					objlength = objname.size();
        					atrlength = atrname.size();

        					objectnames = objname;
        					attributenames = atrname;

        					String[][] array1 = new String[objlength][atrlength];

        					for (int i = 1; i < matrix.length; i++) {
        						for (int j = 1; j < matrix[i].length; j++) {
        							array1[i - 1][j - 1] = matrix[i][j];
        						}
        					}


        					int[][] a = new int[objlength][atrlength];

        					ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
        					ArrayList<Integer> temp = new ArrayList<Integer>();

        					for (int i = 0; i < array1.length; i++) {
        						for (int j = 0; j < array1[i].length; j++) {
        							temp.add(Integer.parseInt(array1[i][j]));
        						}
        						arrays.add(new ArrayList<Integer>(temp));
        						temp.clear();
        					}

        				//	System.out.println(arrays);

        					for (int i = 0; i < arrays.size(); i++) {
        						for (int j = 0; j < arrays.get(i).size(); j++) {
        							a[i][j] = arrays.get(i).get(j);
        						}
        					}       					
        					tableframe.dispose();
        				   p.GUI(a);
        				   
        				   }
        			
        		   }
        	   }   		
        	}  	
        });
 
        
        menuItem1 = new JMenuItem("Exit",KeyEvent.VK_U);
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem1.getAccessibleContext().setAccessibleDescription("EXIT");
        menu.add(menuItem1);
        
        menuItem1.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent arg1)
        	{
        	//	System.out.println("EXIT IS CLICKED");
        		System.exit(0);
        		
        	}       	
        });
        
        JMenu menu1;
        menu1=new JMenu("Go Back");
        menu1.setMnemonic(KeyEvent.VK_B);
        menu.getAccessibleContext().setAccessibleDescription("Go Back");
        menuBar.add(menu1);
        
        menuItem1 = new JMenuItem("Main Menu",KeyEvent.VK_Y);
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem1.getAccessibleContext().setAccessibleDescription("Change Input");
        menu1.add(menuItem1);
        menuItem1.addActionListener(new ActionListener(){
        	@SuppressWarnings("deprecation")
 			@Override
        	public void actionPerformed(ActionEvent arg0)
        	{
        		tableframe.dispose();
        		tempframe.show();	
        	}
        
        	});
      
 
       // For menu Action Listener
        

		JButton button1 = new JButton("Generate Concept Lattice Diagram");
		JButton button2 = new JButton("Generate Partial Order Of Primitive Concepts");

		button1.addActionListener(new Action());
		button2.addActionListener(new Action1());

		Box diagrambox = Box.createVerticalBox();
		diagrambox.add(button1);
		diagrambox.add(button2);

		panel.add(diagrambox, BorderLayout.EAST);

		tableframe = new JFrame();
		// panel.add(panel,BorderLayout.SOUTH);
		tableframe.setResizable(true);
		tableframe.setContentPane(panel);
		tableframe.pack();
		tableframe.setSize(850,650);
		tableframe.setVisible(true);
		tableframe.setLocationRelativeTo(null);
		tableframe.setJMenuBar(menuBar);
		tableframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		return array1;
	}

	
	private void fillNewNorm(int[][] initial) {
		for (int i = 0; i < objlength; i++) {
			for (int j = 0; j < atrlength; j++) {
				newNorm[i][j] = initial[i][j];
			}
		}
	}

	static class Action implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			OrderedSet test = null;
			ConceptLattice cl = null;

			try {
				test = ConceptDiagram.makeExampleLat();
			} catch (Exception e2) {
			//	System.out.println("Cannot generate Concept Lattice Diagram with the given Object - Attribute Table");
			}
			Diagram testDiagram = null;
			try {
					MainClass.save(arraytest);
					testDiagram = new Diagram(test);
					test.card();
					ConceptDiagram frame = new ConceptDiagram(testDiagram);
					JLabel CLabel = new JLabel();
					frame.setContent(frame.drawPanel, frame.toolBar, cl);
					// frame.ConceptDiagram.setLabels(testDiagram);
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int height = (screenSize.height * 9) / 10;
					int width = height;
					frame.setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
					frame.setSize(width, height);
					JFrame.isDefaultLookAndFeelDecorated();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.show();
					frame.getContentPane().add(CLabel);
					
				
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Click on \"Save\" button everytime before generating the diagram");
				System.out.println("Click on \"Save\" button everytime before generating the diagram");
				System.out.println("Note that no object or attribute can be entirely filled with 0's ");
			}				
		}
	}

	static class Action1 implements ActionListener {
		public void actionPerformed1(ActionEvent e) {
		}

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			OrderedSet test = null;
			ConceptLattice cl = null;
			try {
				test = PartialOrderOfPrimitiveConcepts.makeExampleLat();
			} catch (Exception e2) {
				//System.out.println("Cannot generate Concept Lattice Diagram with the given Object - Attribute Table");
			}
			// test = sampleapphasse.makeExampleLat();

			Diagram testDiagram = null;
			try {
				testDiagram = new Diagram(test);
				test.card();
				PartialOrderOfPrimitiveConcepts frame = new PartialOrderOfPrimitiveConcepts(testDiagram);
				JLabel Label = new JLabel();
				frame.setContent(Label, frame.drawPanel, frame.toolBar, cl);
				// frame.setLabels(testDiagram);
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int height = (screenSize.height * 9) / 10;
				int width = height;
				frame.setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
				frame.setSize(width, height);
				JFrame.isDefaultLookAndFeelDecorated();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.show();
				frame.getContentPane().add(Label);
		
		
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Click on \"Save\" button everytime before generating the diagram");
				System.out.println("Click on \"Save\" button everytime before generating the diagram");
				System.out.println("Note that no object or attribute can be entirely filled with 0's ");
			}
		}
	}

	public static boolean exportToCSV(JTable table, String path) {

		try {

			TableModel m = table.getModel();
			FileWriter csv = new FileWriter(new File(path));

			for (int i = 0; i < m.getColumnCount(); i++) {
				csv.write(m.getColumnName(i) + ",");
			}

			csv.write("\n");

			for (int i = 0; i < m.getRowCount(); i++) {
				for (int j = 0; j < m.getColumnCount(); j++) {
					csv.write(m.getValueAt(i, j).toString() + ",");
				}
				csv.write("\n");
			}

			csv.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void save(int array1[][]) {

		// Prints the object-attribute table after modifications in the GUI Table
		
		System.out.println("===========================================");
		System.out.println("OBJECT-ATTRIBUTE TABLE");
		System.out.println("============================================");
		for (int p = 0; p < objlength; p++) {
			for (int q = 0; q < atrlength; q++) {
				System.out.print(array1[p][q] + "\t");
			}
			System.out.println();
		}

		// Creating objects to send arrays to compute different tables and merging them
		TablesClass t = new TablesClass();
		int[][] ootable = t.objecttable(array1);
		int[][] aatable = t.attributetable(array1);
		int[][] aotable = t.attributeobjecttable(array1);
		int[][] mergearray = t.mergeaarray(array1, ootable, aatable, aotable);
		ArrayList<ArrayList<Integer>> alllistrow = t.toListRow(mergearray);
		//	ArrayList<ArrayList<Integer>>  alllistcolumn=t.toListColumn(mergearray);
		//System.out.println(alllistrow);

		HashSet<ArrayList<Integer>> hasseinput = new HashSet<ArrayList<Integer>>();
		hasseinput = t.duprows(alllistrow);
		ArrayList<ArrayList<Integer>> hasse = new ArrayList<ArrayList<Integer>>(hasseinput);

		// Creating objects to compute the extents and intents
		Concepts conObj = new Concepts();
		conObj.Extents(array1);

		// Retrieving the numbers to set labels to the Concept Lattice Diagram and Partial Order of Primitive Concepts
		ArrayList<ArrayList<Integer>> objExtents = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<String>> objlistExtents = new ArrayList<ArrayList<String>>();
		ArrayList<String> tempp = new ArrayList<String>();
		objExtents = SharedResult.extents;

		//System.out.println("Actual Intents and Extents");

		for (int i = 0; i < objExtents.size(); i++) {
			for (int j = 0; j < objExtents.get(i).size(); j++) {
				tempp.add(objectnames.get(objExtents.get(i).get(j) - 1));
			}
			objlistExtents.add(new ArrayList<String>(tempp));
			tempp.clear();
		}
		//System.out.println(objlistExtents);

		SharedResult.extentsLabels = objlistExtents;

		ArrayList<ArrayList<Integer>> atrIntents = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<String>> atrlistIntents = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp1 = new ArrayList<String>();
		atrIntents = SharedResult.intents;

		for (int i = 0; i < atrIntents.size(); i++) {
			for (int j = 0; j < atrIntents.get(i).size(); j++) {
				temp1.add(attributenames.get(atrIntents.get(i).get(j) - 1));
			}
			atrlistIntents.add(new ArrayList<String>(temp1));
			;
			temp1.clear();
		}
	//	System.out.println(atrlistIntents);

		SharedResult.intentsLabels = atrlistIntents;

		ArrayList<String> names = new ArrayList<String>();
		ArrayList<ArrayList<String>> has = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<String>();

		// ArrayList containing names of Indices for Hasse Diagram

		for (int i = 0; i < objectnames.size(); i++) {
			names.add(objectnames.get(i));
		}

		for (int i = 0; i < attributenames.size(); i++) {
			names.add(attributenames.get(i));
		}

		// Naming labels for Equivalence Classes

		ArrayList<String> sameLabels = new ArrayList<String>();

		for (int i = 0; i < SharedResult.same.size(); i++) {
			sameLabels.add(names.get(SharedResult.same.get(i) - 1));
		}

		SharedResult.sameLabels = sameLabels;

		//System.out.println("These are the actual names for the hasse Diagram");
		//System.out.println(names);

		SharedResult.actualHasseNodes = names;

		ArrayList<ArrayList<String>> p = new ArrayList<ArrayList<String>>();
		ArrayList<String> tempo = new ArrayList<String>();

		for (int i = 0; i < names.size(); i++) {
			tempo.add(names.get(i));
			p.add(new ArrayList<String>(tempo));
			tempo.clear();
		}

		SharedResult.hassenodes = (ArrayList<ArrayList<String>>) p;
		//System.out.println("THESE ARE ALL HASSE LABELS");
		//System.out.println(p);

		for (int i = 0; i < hasse.size(); i++) {
			for (int j = 0; j < hasse.get(i).size(); j++) {
				temp.add(names.get(hasse.get(i).get(j) - 1));
			}
			has.add(new ArrayList<String>(temp));
			temp.clear();
		}

		SharedResult.hasseLabels = has;
	}

	static class ButtonListener1Obj implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Clear panel
			panell.removeAll();
		
    	
			// Create label and text field
			JTextField jTextField = new JTextField();
			jTextField.setSize(100, 200);
			listOfTextFields.add(jTextField);
			listOfLabels.add(new JLabel("OBJECT " + indexer));

			// Create constraints
			GridBagConstraints textFieldConstraints = new GridBagConstraints();
			GridBagConstraints labelConstraints = new GridBagConstraints();

			// Add labels and text fields
			for (int i = 0; i < indexer; i++) {
				// Text field constraints
				textFieldConstraints.gridx = 1;
				textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
				textFieldConstraints.weightx = 0.5;
				textFieldConstraints.insets = new Insets(10, 10, 10, 10);
				textFieldConstraints.gridy = i;

				// Label constraints
				labelConstraints.gridx = 0;
				labelConstraints.gridy = i;
				labelConstraints.insets = new Insets(10, 10, 10, 10);

				// Add them to panel
				panell.add(listOfLabels.get(i), labelConstraints);
				panell.add(listOfTextFields.get(i), textFieldConstraints);
			}

			// Align components top-to-bottom
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = indexer;
			c.weighty = 1;
			panell.add(new JLabel(), c);

			// Increment indexer
			indexer++;
			panell.updateUI();		
		}
	}

	static class ButtonListenerObj implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			for (int i = 0; i < listOfLabels.size(); i++) {
				String textFromJLabel = listOfTextFields.get(i).getText();
				objectnames.add(textFromJLabel);
			}
			
			indexer = 1;

			int ObjectsNumber;
			ObjectsNumber = listOfTextFields.size();
			objlength = ObjectsNumber;
			
			listOfLabels.clear();
			listOfTextFields.clear();
			frameATR.show();
			frameObj.dispose();
		}
	}

	static class ButtonListenerATR implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			for (int i = 0; i < listOfLabelsATR.size(); i++) {
				String textFromJLabelAtr = listOfTextFieldsATR.get(i).getText();
				attributenames.add(textFromJLabelAtr);
			}
			atrlength = listOfTextFieldsATR.size();
			indexerATR=1;
			listOfLabelsATR.clear();
			listOfTextFieldsATR.clear();
			frameATR.dispose();
			p.GUI(array0);
		}
	}

	static class ButtonListener1ATR implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Clear panel
			panellATR.removeAll();

			// Create label and text field
			JTextField jTextField = new JTextField();
			jTextField.setSize(100, 200);
			jTextField.setPreferredSize(null);
			listOfTextFieldsATR.add(jTextField);
			listOfLabelsATR.add(new JLabel("ATTRIBUTE " + indexerATR));

			// Create constraints
			GridBagConstraints textFieldConstraints = new GridBagConstraints();
			GridBagConstraints labelConstraints = new GridBagConstraints();

			// Add labels and text fields
			for (int i = 0; i < indexerATR; i++) {
				// Text field constraints
				textFieldConstraints.gridx = 1;
				textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
				textFieldConstraints.weightx = 0.5;
				textFieldConstraints.insets = new Insets(10, 10, 10, 10);
				textFieldConstraints.gridy = i;

				// Label constraints
				labelConstraints.gridx = 0;
				labelConstraints.gridy = i;
				labelConstraints.insets = new Insets(10, 10, 10, 10);

				// Add them to panel
				panellATR.add(listOfLabelsATR.get(i), labelConstraints);
				panellATR.add(listOfTextFieldsATR.get(i), textFieldConstraints);

			}

			// Align components top-to-bottom
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = indexerATR;
			c.weighty = 1;
			panellATR.add(new JLabel(), c);

			// Increment indexer
			indexerATR++;
			panellATR.updateUI();
		}
		
}

}
