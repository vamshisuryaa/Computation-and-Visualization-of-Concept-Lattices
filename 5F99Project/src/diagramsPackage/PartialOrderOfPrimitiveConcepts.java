package diagramsPackage;


import java.util.*;
import java.io.*;
import org.latdraw.orderedset.*;
import org.latdraw.sample.ObjAttTable;
import fcaProject.SharedResult;
import org.latdraw.fca.*;
import org.latdraw.diagram.*;
import org.latdraw.beans.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


@SuppressWarnings("deprecation")
public class PartialOrderOfPrimitiveConcepts extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static final Color OBJ_COLOR = new Color(204, 255, 204); //light green
  public static final Color ATT_COLOR = new Color(204, 204, 255); //light blue


  public DrawPanel drawPanel;
  private JPanel mainPanel;
  private JPanel appPanel;
  private JScrollPane objScrollPane;
  private JScrollPane attScrollPane;
  public JToolBar toolBar;
private ObjAttTable objTable;
private ObjAttTable attTable;
private ConceptLattice conceptLattice;
public static JLabel Label;


private static final Dimension scrollDim = new Dimension(200, 250);
  
  public PartialOrderOfPrimitiveConcepts() {
    this(null, null);
  }

  public PartialOrderOfPrimitiveConcepts(Diagram diag) {
    this(diag, null);
  }

  public PartialOrderOfPrimitiveConcepts(Diagram diag, ConceptLattice cl) {
    super("Partial Order Of Primitive Concepts");
    conceptLattice = cl;
    drawPanel = new DrawPanel(diag);
    PropertyChangeListener changeListener = new PropertyChangeListener() {
        public void propertyChange(PropertyChangeEvent e) {
          if (e.getPropertyName().equals(ChangeSupport.VERTEX_PRESSED)) {
            Diagram diag = drawPanel.getDiagram();
            diag.resetVertices();
            diag.hideLabels();          
          }
        }
    };
    drawPanel.getChangeSupport().addPropertyChangeListener(changeListener);
    drawPanel.setFocusable(true);
    drawPanel.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
          drawPanel.requestFocus();
        }
      });
    drawPanel.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
          char key = e.getKeyChar();
          if (key == 'r' || key == 'R') {
            if (drawPanel.isRotating()) drawPanel.stopRotation();
            else drawPanel.startRotation();
          }
          if (key == 's' || key == 'S') drawPanel.stopRotation();
          if (key == '.' || key == '>') drawPanel.rotateOnce();
          if (key == ',' || key == '<') drawPanel.rotateLeft();
          if (key == 'd' || key == 'D') drawPanel.setDraggingAllowed(
                                          !drawPanel.isDraggingAllowed());
          if (key == 'h' || key == 'H') drawPanel.setDraggingHorizontal(
                                          !drawPanel.isDraggingHorizontal());
          if (key == 'i') drawPanel.improveWithDelay(40);
          if (key == 'I') drawPanel.improve();
          if (key == 'p') drawPanel.printDialog();
          if (key == 'P') drawPanel.writeRSFDiagram("outx.ps");
          if (key == '+') {
            drawPanel.increaseReplusion();
            drawPanel.decreaseAttraction();
          }
          if (key == '-') {
            drawPanel.increaseAttraction();
            drawPanel.decreaseReplusion();
          }
          if (key == 'q' || key == 'Q') System.exit(0);
        }
      });
    
    if(cl!=null)
    {
    	objTable.setSelectionBackground(OBJ_COLOR);
    }
    
    buildMenuBar();
    toolBar = makeToolBar();
    appPanel = new JPanel();
    appPanel.setLayout(new BorderLayout());
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    setContentPane(mainPanel);
  }
  
  public DrawPanel getDrawPanel() { return drawPanel; }

  public ObjAttTable getObjTable() { return objTable; }

  public ObjAttTable getAttTable() { return attTable; }
  
  private void setConceptLattice(ConceptLattice cl) {
	    if (objScrollPane != null) {
	      appPanel.remove(objScrollPane);
	      appPanel.remove(attScrollPane);
	      mainPanel.remove(appPanel);
	    }
	    conceptLattice = cl;
	    if (cl != null) {

	      objScrollPane = new JScrollPane(objTable);
	      objTable.setSelectionBackground(OBJ_COLOR);
	      attScrollPane = new JScrollPane(attTable);
	      objScrollPane.setPreferredSize(scrollDim);
	      attScrollPane.setPreferredSize(scrollDim);
	      appPanel.add(attScrollPane, BorderLayout.NORTH);
	      appPanel.add(objScrollPane, BorderLayout.SOUTH);
	      mainPanel.add(appPanel, BorderLayout.WEST);
	    }
	    else {
	      objScrollPane = null;
	      attScrollPane = null;
	      objTable = null;
	      attTable = null;
	    }
	  }

 
  	public void setContent(JLabel  label,DrawPanel dp, JToolBar tb, ConceptLattice cl) {
	    drawPanel = dp;
	    conceptLattice = cl;
	   
	   
	    ArrayList<String> ll = new ArrayList<String>();
	    ll=SharedResult.actualHasseNodes;
	    
	    
	    System.out.println("actualHasseNodes" );
	    System.out.println(ll);
	    
	    ArrayList<String> m = new ArrayList<String>();
	    m= SharedResult.sameLabels;
	    
	    
	 //   System.out.println("SharedResult.sameLabels");
	   // System.out.println(m);
	    
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

	    for(int i=0;i<ll.size();i++)
	    {
	    	 ArrayList<String> temp = new ArrayList<String>();
	    for(int j=0;j<m.size();j=j+2)
	    {
	    	if(ll.get(i)==m.get(j))
	    			{
	    				temp.add(m.get(j+1));
	    			}
	    	  else
	    	continue ; 
	    }
	    if(temp.isEmpty())
	    {
	    	continue;
	    }
	    else {
	    	temp.add(0, ll.get(i));
	    map.put(ll.get(i), temp);
	    
	     }
	    }
	    
	  //  System.out.println("THIS IS A MAP");
	   // System.out.println(map);
	    
	    JLabel Label = new JLabel(" Equivalence Classes:"+map,JLabel.CENTER);
	 //   JLabel Label = new JLabel("<html><b><i>Equivalence Classes:\n<b><i><html>"+map,JLabel.CENTER);

	    JPanel rightPanel = new JPanel();
	    rightPanel.setLayout(new BorderLayout());
	    rightPanel.add(Label,BorderLayout.SOUTH);
	    rightPanel.add(tb, BorderLayout.NORTH);
	    rightPanel.add(drawPanel, BorderLayout.CENTER);
	    mainPanel.add(rightPanel, BorderLayout.CENTER);
	    
	    if (cl != null) setConceptLattice(cl);
	  }
  private void buildMenuBar() {
	    JMenuBar menuBar = new JMenuBar();

	    // File Menu
	    JMenu file = (JMenu) menuBar.add(new JMenu("File"));
	    file.setMnemonic(KeyEvent.VK_F);

	    ClassLoader cl = this.getClass().getClassLoader();
	    ImageIcon icon = new ImageIcon(cl.getResource(
	                              "org/latdraw/sample/images/Open16.gif"));

	    JMenuItem openMI = (JMenuItem)file.add(new JMenuItem("Open", icon));
	    openMI.setMnemonic(KeyEvent.VK_O);
	    KeyStroke cntrlO = KeyStroke.getKeyStroke(KeyEvent.VK_O,Event.CTRL_MASK);
	    openMI.setAccelerator(cntrlO);

	    file.add(new JSeparator());

	    JMenuItem exitMI = (JMenuItem)file.add(new JMenuItem("Exit"));
	    exitMI.setMnemonic(KeyEvent.VK_X);
	    KeyStroke cntrlQ = KeyStroke.getKeyStroke(KeyEvent.VK_Q,Event.CTRL_MASK);
	    exitMI.setAccelerator(cntrlQ);

	    exitMI.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          System.exit(0);
	        }
	      });

	    JMenu dragging = (JMenu)menuBar.add(new JMenu("Dragging"));
	    ButtonGroup draggingGroup = new ButtonGroup();
	    JRadioButtonMenuItem noDrag = new JRadioButtonMenuItem("None");
	    JRadioButtonMenuItem horizDrag = new JRadioButtonMenuItem("Horizontal");
	    JRadioButtonMenuItem allDrag = new JRadioButtonMenuItem("All");
	    noDrag.setMnemonic(KeyEvent.VK_N);
	    horizDrag.setMnemonic(KeyEvent.VK_H);
	    allDrag.setMnemonic(KeyEvent.VK_A);
	    KeyStroke key = 
	        KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.SHIFT_MASK+Event.CTRL_MASK);
	    noDrag.setAccelerator(key);
	    key=KeyStroke.getKeyStroke(KeyEvent.VK_H,Event.SHIFT_MASK+Event.CTRL_MASK);
	    horizDrag.setAccelerator(key);
	    key=KeyStroke.getKeyStroke(KeyEvent.VK_A,Event.SHIFT_MASK+Event.CTRL_MASK);
	    allDrag.setAccelerator(key);
	    noDrag.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          drawPanel.setDraggingAllowed(false);
	        }
	    });
	    horizDrag.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          drawPanel.setDraggingAllowed(true);
	          drawPanel.setDraggingHorizontal(true);
	        }
	    });
	    allDrag.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          drawPanel.setDraggingAllowed(true);
	          drawPanel.setDraggingHorizontal(false);
	        }
	    });
	    // start with horizontal only
	    horizDrag.setSelected(true);
	    drawPanel.setDraggingAllowed(true);
	    drawPanel.setDraggingHorizontal(true);
	    draggingGroup.add(noDrag);
	    dragging.add(noDrag);
	    draggingGroup.add(horizDrag);
	    dragging.add(horizDrag);
	    draggingGroup.add(allDrag);
	    dragging.add(allDrag);

	    JMenu labels = (JMenu)menuBar.add(new JMenu("Labeling"));
	    ButtonGroup labelsGroup = new ButtonGroup();
	    JRadioButtonMenuItem noLabels = new JRadioButtonMenuItem("No");
	    JRadioButtonMenuItem someLabels = new JRadioButtonMenuItem("Yes");
	    noLabels.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          drawPanel.getDiagram().setPaintLabels(false);
	          repaint();
	        }
	    });
	    someLabels.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          drawPanel.getDiagram().setPaintLabels(true);
	          repaint();
	        }
	    });
	 
	    // start without labels
	    noLabels.setSelected(true);
	    drawPanel.getDiagram().setPaintLabels(false);
	    labelsGroup.add(noLabels);
	    labels.add(noLabels);
	    labelsGroup.add(someLabels);
	    labels.add(someLabels);

	    setJMenuBar(menuBar);
	  }

  // move the tool bar stuff into DrawPanel
  public JToolBar makeToolBar() {
	    JToolBar toolBar = new JToolBar();
	    ClassLoader cl = this.getClass().getClassLoader();
	    ImageIcon icon = new ImageIcon
	      (cl.getResource("org/latdraw/sample/images/Forward16.gif"));
	    JButton forwardButton = new JButton(icon);
	    forwardButton.setPreferredSize(new Dimension(32, 32));
	    forwardButton.setToolTipText("Rotate forward");
	    forwardButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          drawPanel.rotateOnce();
	        }
	      });
	    toolBar.add(forwardButton);
	    icon = new ImageIcon(
	                 cl.getResource("org/latdraw/sample/images/Back16.gif"));
	    JButton backButton = new JButton(icon);
	    backButton.setPreferredSize(new Dimension(32, 32));
	    backButton.setToolTipText("Rotate back");
	    backButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          drawPanel.rotateLeft();
	        }
	      });
	    toolBar.add(backButton);
	    icon = new ImageIcon(
	                 cl.getResource("org/latdraw/sample/images/Redo16.gif"));
	    JButton rotButton = new JButton(icon);
	    rotButton.setPreferredSize(new Dimension(32, 32));
	    rotButton.setToolTipText("Rotate");
	    rotButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          if (drawPanel.isRotating()) drawPanel.stopRotation();
	          else drawPanel.startRotation();
	        }
	      });
	    toolBar.add(rotButton);
	    JButton inButton = new JButton("><");
	    inButton.setPreferredSize(new Dimension(32, 32));
	    inButton.setToolTipText("Push in horizontally");
	    inButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          drawPanel.increaseAttraction();
	          drawPanel.decreaseReplusion();
	          drawPanel.improveWithoutDelay(40);
	        }
	      });
	    toolBar.add(inButton);
	    JButton outButton = new JButton("<>");
	    outButton.setPreferredSize(new Dimension(32, 32));
	    outButton.setToolTipText("Push out horizontally");
	    outButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          drawPanel.increaseReplusion();
	          drawPanel.decreaseAttraction();
	          drawPanel.improveWithoutDelay(40);
	        }
	      });
	    toolBar.add(outButton);
	    JButton improveButton = new JButton("++");
	    improveButton.setPreferredSize(new Dimension(32, 32));
	    improveButton.setToolTipText("Improve the diagram");
	    improveButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          drawPanel.improve();
	        }
	      });
	    toolBar.add(improveButton);
	    return toolBar;
	  }
  
  public static void settingEquivalenceClasses() 
  {
	  ArrayList<String> ll = new ArrayList<String>();
	    ll=SharedResult.actualHasseNodes;
	    
	    
	 //   System.out.println("actualHasseNodes" );
	  //  System.out.println(ll);
	    
	    ArrayList<String> m = new ArrayList<String>();
	    m= SharedResult.sameLabels;
	    
	    
	    ArrayList<ArrayList<String>> relations = new ArrayList<ArrayList<String>>();
	    relations= SharedResult.hasseLabels;

	    //System.out.println("SharedResult.sameLabels");
	    //System.out.println(m);
	    
	    LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();

	    for(int i=0;i<ll.size();i++)
	    {
	    	 ArrayList<String> temp = new ArrayList<String>();
	  
	    	 for(int j=0;j<m.size();j=j+2)
	    {
	    	if(ll.get(i)==m.get(j))
	    			{
	    				temp.add(m.get(j+1));
	    			}
	    	  else
	    	continue ; 
	    }
	    	 temp.add(0, ll.get(i));
	    map.put(ll.get(i), temp);
	    	}

  for(int p=0;p<relations.size();p++)
  {
	  for(int q=0;q<relations.get(p).size();q++)
	  {
		  if(map.containsKey(relations.get(p).get(q)))
		  {
			    StringBuilder sb = new StringBuilder();
			    for (String s : map.get(relations.get(p).get(q)))
			  {
			      sb.append(s+",");
			  }
			    
			    String result = sb.toString();
			    if (result != null && result.length() > 0) {
			    	result = result.substring(0, result.length() - 1);
			    }
			    
			    relations.get(p).set(q, result);
		  }
		  
	  }
  }
 
  
  //System.out.println("THESE ARE RELATIONS AFTER SETTING EQUIVALENCE CLASSES");
  //System.out.println(relations);
 
  	SharedResult.finalrelations= relations;
  
  
  }
  
  public static OrderedSet makeExampleLat() throws NonOrderedSetException {
	    String n = "Test";
	    
	    settingEquivalenceClasses();
	    
	    ArrayList<ArrayList<String>> input =new ArrayList<ArrayList<String>>();
	    input= SharedResult.finalrelations;
	    

	    
	    LinkedHashSet<String> t=new LinkedHashSet<String>();
	    
	    for(int i=0;i<input.size();i++)
	    {
	    	t.add(input.get(i).get(0));
	    }
	    
	    ArrayList<String> inputnodes = new ArrayList<String>(t);
	    ArrayList<ArrayList<String>> l = new ArrayList<ArrayList<String>>();
	    
	    List p = new ArrayList(t);
	    
	    List temp;
	    List fin;
	    fin = new ArrayList();
	    
	   
	    for(int i=0;i<p.size();i++) {
	    	temp=new ArrayList();
	    	temp.add(p.get(i));
	    	l.add(new ArrayList<String>(temp));
	    	temp.clear();
	    	 }
	    
	    List finall; 
	    finall =new ArrayList<String>();
	    List  temp1 ;
	    List temp2;
	    
	    for(int i=0;i<input.size();i++)
	    {
	    	
	    	temp2=new ArrayList();
	    
	    	for (int j=0;j< input.get(i).size();j++)
	    	{
	    		temp1=new ArrayList();
	       		temp1.add(input.get(i).get(j));
	     		temp2.add(new ArrayList <String>(temp1));       
	    	}    
	    	finall.add(new ArrayList(temp2));
	    }
	    
	    List tmp;
	    
	    List something = new ArrayList();
	    List something2= new ArrayList();
	    
	    for(int i=0;i<l.size();i++)
	    {
	    	something= (List) finall.get(i);
	    	tmp = new ArrayList();
	    	
	    	
	    	for(int j=0;j<finall.size();j++)
	    		{
	    		something2=(List) finall.get(j);
	    		
	    		if (l.get(i).equals(something2.get(0)))
	    			{
	    				if(something2.get(0).equals(something2.get(1)))
	    				{
	    					continue;
	    				}
	    				else
	    				{
	    					List nay=new ArrayList();
	    					nay = (List) something2.get(1);
	    					tmp.add(new ArrayList(nay));

	    				}
	    			}
	    		}
	    		
	    	fin.add(new ArrayList(tmp));
	  }
	    

  
	    InputLattice i = new InputLattice(n, l, fin);
	    return new OrderedSet(i);
	  }


  public static void main(String[] args) 
          throws FileNotFoundException, IOException, NonOrderedSetException {
    OrderedSet test;
    ConceptLattice cl = null;
  
      test = makeExampleLat();
      
    Diagram testDiagram = new Diagram(test);
    test.card();


    PartialOrderOfPrimitiveConcepts frame = new PartialOrderOfPrimitiveConcepts(testDiagram);
    frame.setContent(Label,frame.drawPanel, frame.toolBar, cl);
    //frame.setLabels(testDiagram);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int height = (screenSize.height * 8) / 10;
    int width = height;
    frame.setLocation((screenSize.width - width) / 2,
                      (screenSize.height - height) / 2);
    frame.setSize(width, height);
    frame.isDefaultLookAndFeelDecorated();
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    Runnable  runner = new FrameShower(frame);
    EventQueue.invokeLater(runner);
  }

  private static class FrameShower implements Runnable {
    final JFrame frame;

    public FrameShower(JFrame frame) {
      this.frame = frame;
    }

    public void run() {
      frame.setVisible(true);
    }
  }

}

