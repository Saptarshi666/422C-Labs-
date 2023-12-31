/* CRITTERS GUI <Critter.java>
 * EE422C Project 5 submission by
 * Replace <...> with your actual data.
 * Samir Mohsin
 * ssm3392
 * 17830
 * Saptarshi Mondal
 * sm72999
 * 17810
 * Slip days used: <0>
 * Fall 2021
 */

package assignment5;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import assignment5.Main;


/*
 * See the PDF for descriptions of the methods and fields in this
 * class.
 * You may add fields, methods or inner classes to Critter ONLY
 * if you make your additions private; no new public, protected or
 * default-package code or data can be added to Critter.
 */

public abstract class Critter {

    /* START --- NEW FOR PROJECT 5 */
    public enum CritterShape {
        CIRCLE,
        SQUARE,
        TRIANGLE,
        DIAMOND,
        STAR
    }

    /* the default color is white, which I hope makes critters invisible by default
     * If you change the background color of your View component, then update the default
     * color to be the same as you background
     *
     * critters must override at least one of the following three methods, it is not
     * proper for critters to remain invisible in the view
     *
     * If a critter only overrides the outline color, then it will look like a non-filled
     * shape, at least, that's the intent. You can edit these default methods however you
     * need to, but please preserve that intent as you implement them.
     */
    public javafx.scene.paint.Color viewColor() {
        return javafx.scene.paint.Color.WHITE;
    }
    
    public javafx.scene.paint.Color viewOutlineColor() {
        return viewColor();
    }

    public javafx.scene.paint.Color viewFillColor() {
        return viewColor();
    }

    public abstract CritterShape viewShape();

    protected final String look(int direction, boolean steps) {
    	int x=0,y=0;
    	energy -=Params.LOOK_ENERGY_COST;
    	if(set)
    	{
    	if(steps)
    	{
    		if (direction == 0) {
        		x = old_x_coord + 1;
        	}
        	
        	else if (direction == 1) {
        		x = old_x_coord + 1;
        		y= old_y_coord +  1;
        	}
        	
        	else if (direction == 2) {
        		y = old_y_coord + 1;
        	}
        	
        	else if (direction == 3) {
        		x = old_x_coord -  1;
        		y = old_y_coord +  1;
        	}
        	
        	else if (direction == 4) {
        		x =old_x_coord - 1;
        	}
        	
        	else if (direction == 5) {
        		x = old_x_coord - 1;
        		y = old_y_coord - 1;
        	}
        	
        	else if (direction == 6) {
        		y = old_y_coord - 1;
        	}
        	
        	else if (direction == 7) {
        		x = old_x_coord + 1;
        		y = old_y_coord - 1;
        	}
    	}
    	else
    	{
    		if (direction == 0) {
        		x = old_x_coord + 2;
        	}
        	
        	else if (direction == 1) {
        		x = old_x_coord + 2;
        		y= old_y_coord +  2;
        	}
        	
        	else if (direction == 2) {
        		y = old_y_coord + 2;
        	}
        	
        	else if (direction == 3) {
        		x = old_x_coord -  2;
        		y = old_y_coord +  2;
        	}
        	
        	else if (direction == 4) {
        		x =old_x_coord - 2;
        	}
        	
        	else if (direction == 5) {
        		x = old_x_coord - 2;
        		y = old_y_coord - 2;
        	}
        	
        	else if (direction == 6) {
        		y = old_y_coord - 2;
        	}
        	
        	else if (direction == 7) {
        		x = old_x_coord + 2;
        		y = old_y_coord - 2;
        	}	
    	}
    	}
    	else
    	{
    		if(steps)
        	{
        		if (direction == 0) {
            		x = x_coord + 1;
            	}
            	
            	else if (direction == 1) {
            		x = x_coord + 1;
            		y= y_coord +  1;
            	}
            	
            	else if (direction == 2) {
            		y = y_coord + 1;
            	}
            	
            	else if (direction == 3) {
            		x = x_coord -  1;
            		y = y_coord +  1;
            	}
            	
            	else if (direction == 4) {
            		x = x_coord - 1;
            	}
            	
            	else if (direction == 5) {
            		x = x_coord - 1;
            		y = y_coord - 1;
            	}
            	
            	else if (direction == 6) {
            		y = y_coord - 1;
            	}
            	
            	else if (direction == 7) {
            		x = x_coord + 1;
            		y = y_coord - 1;
            	}
        	}
        	else
        	{
        		if (direction == 0) {
            		x = x_coord + 2;
            	}
            	
            	else if (direction == 1) {
            		x = x_coord + 2;
            		y= y_coord +  2;
            	}
            	
            	else if (direction == 2) {
            		y = y_coord + 2;
            	}
            	
            	else if (direction == 3) {
            		x = x_coord -  2;
            		y = y_coord +  2;
            	}
            	
            	else if (direction == 4) {
            		x = x_coord - 2;
            	}
            	
            	else if (direction == 5) {
            		x = x_coord - 2;
            		y = y_coord - 2;
            	}
            	
            	else if (direction == 6) {
            		y = y_coord - 2;
            	}
            	
            	else if (direction == 7) {
            		x = x_coord + 2;
            		y = y_coord - 2;
            	}	
        	}
    	}
    	if (x < 0) {
    		x = x + Params.WORLD_WIDTH - 1;
    	}
    	
    	if (x > Params.WORLD_WIDTH - 1) {
    		x = x - Params.WORLD_WIDTH - 1;
    	}
    	
    	if (y < 0) {
    		y = y + Params.WORLD_HEIGHT - 1;
    	}
    	
    	if (y > Params.WORLD_HEIGHT - 1) {
    		y = y - Params.WORLD_HEIGHT - 1;
    	}
    	
    	for(int i = 0; i<population.size();i++)
    	{
    		Critter c = population.get(i);
    		if((c.x_coord == x) &&(c.y_coord == y))
    				return c.toString();
    	}
    	return null;
    }

    public static String runStats(List<Critter> critters) {
        // TODO Implement this method
    	String statLine = "" + critters.size() + " critters as follows -- ";
        Map<String, Integer>  critter_count = new HashMap<String,Integer>();
        for (Critter c : critters) {
        	String c_toString = c.toString();
        	critter_count.put(c_toString, critter_count.getOrDefault(c_toString, 0) + 1);
        }
        
        String prefix = "";
        for (String s : critter_count.keySet()) {
            statLine += (prefix + s + ":" + critter_count.get(s));
            prefix = ", ";
        }
        
        
        return statLine;
    }


    public static void displayWorld(Object pane) {
        // TODO Implement this method
    	Random rand = new Random();
    	GridPane pane1 = (GridPane) pane;
		pane1.getChildren().clear(); // clear the grid 
		int sizeX, sizeY, size;//4;
		int smallerDimension = 0; int k = 0;
	
		int sizeOfWorld = 500;
		sizeX = sizeOfWorld/Params.WORLD_WIDTH;
		sizeY = sizeOfWorld/Params.WORLD_HEIGHT;
		if(sizeX < sizeY) {
			smallerDimension = sizeX;
		}else {
			smallerDimension = sizeY;
		}
		size = smallerDimension;//(sizeOfWorld - (smallerDimension))/(smallerDimension-1);

		for(int i = 0; i< Params.WORLD_WIDTH; i++)
		{
			for(int j = 0; j<Params.WORLD_HEIGHT;j++)
			{
				Shape s = new Rectangle(sizeX,sizeY);
				s.setFill(null);
				s.setStroke(Color.ORANGE);
				//GridPane.setHalignment(s, HPos.CENTER);
				//GridPane.setValignment(s, VPos.CENTER);
				s.autosize();
				pane1.add(s, i, j);
			
			   int h = findCritter(i,j);
					if(h != -1)
					{
					Critter c = population.get(h);
					CritterShape sh = c.viewShape();
		    		Color co = c.viewOutlineColor(); 
		    		Color colo = c.viewFillColor();
		    		if(sh == CritterShape.CIRCLE)
		    		{
		    			Shape sha = new Circle(size/2);
		    			sha.setFill(colo);
		    			sha.setStroke(co);
		    			pane1.add(sha, c.x_coord, c.y_coord);
		    		}
		    		else if( sh == CritterShape.SQUARE)
		    		{
		    			Shape sha = new Rectangle(size,size);
		    			sha.setFill(colo);
		    			sha.setStroke(co);
		    			pane1.add(sha, c.x_coord, c.y_coord);
		    		}
		    		else if(sh == CritterShape.TRIANGLE)
		    		{
		    			Shape sha = null;
		    			sha = new Path(new MoveTo(0,0), new LineTo(-size+2,0), new LineTo(-size/2,-size+2), new LineTo(0,0));
		    			sha.setFill(colo);
		    			sha.setStroke(co);
		    			pane1.add(sha, c.x_coord, c.y_coord);
		    		}
		    		else if(sh == CritterShape.DIAMOND)
		    		{
		    			Shape sha = null;
		    			sha =  new Path(new MoveTo(0,0), new LineTo(size/2,size/2-2), new LineTo(size-2,0), new LineTo(size/2,-size/2+2), new LineTo(0,0));
		    			sha.setFill(colo);
		    			sha.setStroke(co);
		    			pane1.add(sha, c.x_coord, c.y_coord);
		    		}
		    		else if(sh == CritterShape.STAR)
		    		{
		    			Shape sha = null;
		    			sha=new Path(new MoveTo(0,0), new LineTo(size/3+size/25, size/3-size/6), new LineTo(size/2,size/2-2), new LineTo(3*size/4.7, size/3-size/6), new LineTo(size-3,0), new LineTo(3*size/4.7, -size/3+size/6),new LineTo(size/2,-size/2+2), new LineTo(size/3+size/25, -size/3+size/6), new LineTo(0,0));
		    			sha.setFill(colo);
		    			sha.setStroke(co);
		    			pane1.add(sha, c.y_coord, c.x_coord);
		    		}
				}    	
			}	
		}
	}
    
	static private int findCritter(int x,int y )
	{
		for(int i = 0 ; i<population.size(); i++)
		{
			if((population.get(i).x_coord==x)&&(population.get(i).y_coord==y))
				return i;
		}
		return -1;
	}

	/* END --- NEW FOR PROJECT 5
			rest is unchanged from Project 4 */

    private int energy = 0;

    private int x_coord;
    private int y_coord;
    private static boolean set = false;
    private int old_x_coord;
    private int old_y_coord;

    private static List<Critter> population = new ArrayList<Critter>();
    private static List<Critter> babies = new ArrayList<Critter>();
   

    /* Gets the package name.  This assumes that Critter and its
     * subclasses are all in the same package. */
    private static String myPackage;

    static {
        setMyPackage(Critter.class.getPackage().toString().split(" ")[1]);
    }

    private static Random rand = new Random();

    public static int getRandomInt(int max) {
        return rand.nextInt(max);
    }

    public static void setSeed(long new_seed) {
        rand = new Random(new_seed);
    }

    /**
     * create and initialize a Critter subclass.
     * critter_class_name must be the unqualified name of a concrete
     * subclass of Critter, if not, an InvalidCritterException must be
     * thrown.
     *
     * @param critter_class_name
     * @throws InvalidCritterException
     */
    public static void createCritter(String critter_class_name)
            throws InvalidCritterException {
        // TODO: Complete this method
    	String b = getMyPackage() + "." + critter_class_name;
    	try {
			Class a  = Class.forName(b);
			Class<Critter> f = Critter.class;
			boolean g = f.isAssignableFrom(a);
			if(g == false)
			{
				throw new InvalidCritterException(critter_class_name);
			}
			Object b1 = a.newInstance();
			Critter b2 = (Critter)b1;
			b2.x_coord = getRandomInt(Params.WORLD_WIDTH);
			b2.y_coord = getRandomInt(Params.WORLD_HEIGHT);
			b2.energy = Params.START_ENERGY;
			population.add(b2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new InvalidCritterException(critter_class_name);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			throw new InvalidCritterException(critter_class_name);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new InvalidCritterException(critter_class_name);
		}
    	
    }
    
    static List<Class<?>> getAllClasses() {
    	String fp = "assignment5";
    	List<Class<?>> classes = new ArrayList<>();
    	String[] classPathEntries = System.getProperty("java.class.path").split(System.getProperty("path.separator"));
    	String name;
    	
    	for (String cpe : classPathEntries) {
    		if (cpe.endsWith(".jar")) {
    			File jar = new File(cpe);
    			try {
    				JarInputStream is = new JarInputStream(new FileInputStream(jar));
    				JarEntry entry;
    				while ((entry = is.getNextJarEntry()) != null) {
    					name = entry.getName();
    					if (name.endsWith(".class")) {
    						if (name.contains(fp) && name.endsWith(".class")) {
    							String classPath = name.substring(0, entry.getName().length() - 6);
    							classPath = classPath.replaceAll("[\\|/]", ".");
    							classes.add(Class.forName(classPath));
    						}
    					}
    				}
    				is.close();
    			}
    			catch (Exception e) {
    				
    			}
    		}
    		
    		else {
    			try {
    				File base = new File(cpe + File.separatorChar + fp);
    				for (File file : base.listFiles()) {
    					name = file.getName();
    					if (name.endsWith(".class")) {
    						name = name.substring(0, name.length() - 6);
    						classes.add(Class.forName(fp + "." + name));
    						
    					}
    				}
    			}
    			catch (Exception e) {
    				
    			}
    		}
    	}
		return classes;
    }

    /**
     * Gets a list of critters of a specific type.
     *
     * @param critter_class_name What kind of Critter is to be listed.
     *        Unqualified class name.
     * @return List of Critters.
     * @throws InvalidCritterException
     */
    public static List<Critter> getInstances(String critter_class_name)
            throws InvalidCritterException {
    	List<Critter> instancesList = new ArrayList<Critter>();
    	Critter className;
    	try {
    		className = (Critter) Class.forName(getMyPackage() + "." + critter_class_name).newInstance();
    	}
    	
    	catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
    		throw new InvalidCritterException(critter_class_name);
    	}
    	
    	for (Critter c : population) {
    		if (className.getClass().isInstance(c)) {
    			instancesList.add(c);
    		}
    	}
    	
    	return instancesList;
    }

    /**
     * Clear the world of all critters, dead and alive
     */
    public static void clearWorld() {
        // TODO: Complete this method
    	population.clear();
    }
    
    /**
     *  runs time step for each critter, then resolves fights, makes clovers, adds babies
     * 
     * 
     */
    public static void worldTimeStep() {
        // TODO: Complete this method
    	//time step for each critter, subtract rest cost, and remove if dead
    	for (int i = 0; i < population.size(); i++) {
    		Critter c = population.get(i);
    	    set = true;
    	    c.old_x_coord = c.x_coord;
    	    c.old_y_coord = c.y_coord;
    		c.doTimeStep();
    		c.energy -= Params.REST_ENERGY_COST;
    		population.set(i, c);
    		
    		if (population.get(i).energy <= 0) {
    			population.remove(i);
    			i--;
    		}
    	}
    	for(int i = 0; i<population.size(); i++)
    	{
    		Critter c = population.get(i);
    		
    	}
    	doEncounters();
    	makeClovers();
      	
    	
    	//add babies
    	for(int i = 0; i<babies.size();i++)
    	{
    		population.add(babies.get(i));
    	}
    	//clear babies and resolve fights
    	babies.clear();
    }

    /** 
     * creates clovers and adds them to population
     * 
     */
    private static void makeClovers() {
    	//add clovers
    	for(int i = 0; i<Params.REFRESH_CLOVER_COUNT; i++)
    	{
    		try {
    			createCritter("Clover");
    		}
    		catch (InvalidCritterException e){
    			e.printStackTrace();
    		}
    	}
    }
    
    /**
     * displays the world in its current state
     * 
     */
   

    /**
     * Prints out how many Critters of each type there are on the
     * board.
     *
     * @param critters List of Critters.
     */
    

    public abstract void doTimeStep();

    public abstract boolean fight(String oponent);

    /* a one-character long string that visually depicts your critter
     * in the ASCII interface */
    public String toString() {
        return "";
    }

    protected int getEnergy() {
        return energy;
    }
    

    /**
     * moves critter 1 unit in specified direction
     * @param direction
     */
    protected final void walk(int direction) {
        // TODO: Complete this method
    	int currEnergy = this.getEnergy();
    	this.energy = currEnergy - Params.WALK_ENERGY_COST;
    	moveCritter(direction , 1);
    }
    
    
    /**
     * moves critter set direction the number of distance units specified
     * @param direction
     * @param distance
     * 
     */
    private final void moveCritter(int direction, int distance) {
    	
    	//move critter in direction the number of distance units
    	if (direction == 0) {
    		x_coord += distance;
    	}
    	
    	else if (direction == 1) {
    		x_coord += distance;
    		y_coord += distance;
    	}
    	
    	else if (direction == 2) {
    		y_coord += distance;
    	}
    	
    	else if (direction == 3) {
    		x_coord -= distance;
    		y_coord += distance;
    	}
    	
    	else if (direction == 4) {
    		x_coord -= distance;
    	}
    	
    	else if (direction == 5) {
    		x_coord -= distance;
    		y_coord -= distance;
    	}
    	
    	else if (direction == 6) {
    		y_coord -= distance;
    	}
    	
    	else if (direction == 7) {
    		x_coord += distance;
    		y_coord -= distance;
    	}
    	
    	//check if critter is out of bounds and move appropriately 
    	
    	if (x_coord < 0) {
    		x_coord = x_coord + Params.WORLD_WIDTH - 1;
    	}
    	
    	if (x_coord > Params.WORLD_WIDTH - 1) {
    		x_coord = x_coord - Params.WORLD_WIDTH - 1;
    	}
    	
    	if (y_coord < 0) {
    		y_coord = y_coord + Params.WORLD_HEIGHT - 1;
    	}
    	
    	if (y_coord > Params.WORLD_HEIGHT - 1) {
    		y_coord = y_coord - Params.WORLD_HEIGHT - 1;
    	}
    	
    	
    }

    /**
     *  moves critter 2 units in specified direction
     * @param direction
     * 
     */
    protected final void run(int direction) {
        // TODO: Complete this method
    	energy -= Params.RUN_ENERGY_COST;
    	//int currEnergy = this.getEnergy();
    	//this.energy = currEnergy - Params.RUN_ENERGY_COST;
    	moveCritter(direction , 2);
    }

    /**
     * reproduces critter offspring, adds to population
     * @param offspring
     * @param direction
     */
    protected final void reproduce(Critter offspring, int direction) {
        // TODO: Complete this method
    	int parentEnergy = this.getEnergy();
    	//parent doesn't have enough energy
    	if (parentEnergy < Params.MIN_REPRODUCE_ENERGY) 
    		return;
    	//transfer energy to offspring appropriately, add to babies list
    	offspring.energy = Math.floorDiv(parentEnergy, 2);
    	this.energy = (int) Math.ceil(parentEnergy / 2); 
    	offspring.x_coord = this.x_coord;
    	offspring.y_coord = this.y_coord;
    	offspring.moveCritter(direction , 1);
    	babies.add(offspring);
    	
    }
    
    /**
     * resolve fights btwn critters if they occupy the same location
     * 
     */
    private static void doEncounters() {
    	boolean critterAFight, critterBFight, fightResult;
    	set = false;
    	//check all critters to see if 2 occupy the same space
    	for (int i = 0; i < population.size() - 1; i++) {
    		for (int j = i + 1; j < population.size(); j++) {
    			Critter critterA = population.get(i);
    			Critter critterB = population.get(j);
    			//occupy the same position
    			if (critterA.x_coord == critterB.x_coord && critterA.y_coord == critterB.y_coord) {
    				
    				critterAFight = critterA.fight(critterB.toString());
    				critterBFight = critterB.fight(critterA.toString());
    				//if still occupy same position then see who fins the fight
    				if (critterA.energy > 0 && critterB.energy > 0 && critterA.x_coord == critterB.x_coord && critterA.y_coord == critterB.y_coord) {
    					//check who wins the fight - true means critterA won, false means critterB won
    					fightResult = doFights(critterA, critterB, critterAFight, critterBFight); 
    					
    					if (fightResult) {//critter A wins, transfer energy and remove critter B
    						critterA.energy += critterB.energy / 2;
    						population.remove(j);
    						j--;
    						
    					}
    					
    					else {
    						//critter B wins
    						critterB.energy += critterA.energy / 2;
    						population.remove(i);
    						i--;
    						j = population.size() - 1;
    						
    					}
    				}
    				
    				else { //if no fight, see if one of the critters is dead from moving
    					if (critterA.energy <= 0) {
    						population.remove(critterA);
    						i--;
    						j = population.size() - 1;
    						
    					}
    					
    					if (critterB.energy <= 0) {
    						population.remove(critterB);
    						j--;
    						
    					}
    					
    				}
    				
    			}
    		}
    	}
    }
    
    
    /**
     * resolve dice rolls btwn critters in fights, defaults to critter c2 winning if rolls are equal
     * @param c1
     * @param c2
     * @param c1Fight
     * @param c2Fight
     * @return true if c1 wins, false if not
     */
    private static boolean doFights(Critter c1, Critter c2, boolean c1Fight, boolean c2Fight) {
    	int c1DiceRoll, c2DiceRoll;
    	
    	if (!c1Fight) {
    		c1DiceRoll = 0;
    	}
    	
    	else {
    		c1DiceRoll = getRandomInt(c1.energy);
    	}
    	
    	if (!c2Fight ) {
    		c2DiceRoll = 0;
    	}
    	
    	else {
    		c2DiceRoll = getRandomInt(c2.energy);
    	}
    	
    	return c1DiceRoll > c2DiceRoll;
    }
   
    

    public static String getMyPackage() {
		return myPackage;
	}

	public static void setMyPackage(String myPackage) {
		Critter.myPackage = myPackage;
	}



	/**
     * The TestCritter class allows some critters to "cheat". If you
     * want to create tests of your Critter model, you can create
     * subclasses of this class and then use the setter functions
     * contained here.
     * <p>
     * NOTE: you must make sure that the setter functions work with
     * your implementation of Critter. That means, if you're recording
     * the positions of your critters using some sort of external grid
     * or some other data structure in addition to the x_coord and
     * y_coord functions, then you MUST update these setter functions
     * so that they correctly update your grid/data structure.
     */
    static abstract class TestCritter extends Critter {

        protected void setEnergy(int new_energy_value) {
            super.energy = new_energy_value;
        }

        protected void setX_coord(int new_x_coord) {
            super.x_coord = new_x_coord;
        } 

        protected void setY_coord(int new_y_coord) {
            super.y_coord = new_y_coord;
        }

        protected int getX_coord() {
            return super.x_coord;
        }

        protected int getY_coord() {
            return super.y_coord;
        }

        /**
         * This method getPopulation has to be modified by you if you
         * are not using the population ArrayList that has been
         * provided in the starter code.  In any case, it has to be
         * implemented for grading tests to work.
         */
        protected static List<Critter> getPopulation() {
            return population;
        }

        /**
         * This method getBabies has to be modified by you if you are
         * not using the babies ArrayList that has been provided in
         * the starter code.  In any case, it has to be implemented
         * for grading tests to work.  Babies should be added to the
         * general population at either the beginning OR the end of
         * every timestep.
         */
        protected static List<Critter> getBabies() {
            return babies;
        }

    }
}
