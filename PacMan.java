import java.util.Scanner;

/**
 * PacMan class places the PacMan on the grid and will be moved based on the user commands
 * and it also contains menu display for user to select an option.
 * 
 * @author Monica
 * @version 1.8.0_131
 */
class PacMan{
	//inputs from the user
	Integer xValue, yValue;
	String fValue = null;
	String positionInput;
	Scanner in;
	
	//dimensions
	int xUnit = 5, yUnit = 5 ;
	
	/**
     * Main method to run program
     * 
     */
	public static void main(String args[]){
		PacMan pacman = new PacMan();
		pacman.run();
	}
	
	/**
     * This method is invoked when user enters "1" option
     * place() is used to place the PacMan on the grid.
     * 
     */
	public void place(){
		
		String currentPlace="";
						
		/**  
	      *  get x,y,face inputs and check whether they are placed correctly 
	      *  
	      */
		while(true) {
			System.out.println();
			System.out.println("***--- Please place PacMan on the grid with this format X,Y,Face ---***");
			System.out.println("**--- X: 0-5 , Y: 0-5, Face: NORTH/SOUTH/EAST/WEST ---**");
			
			//place input
			positionInput = getString("PLACE : ");
			
			if(xValue!=null && yValue!=null && fValue!=null) {
				currentPlace = xValue.toString()+","+yValue.toString()+","+fValue;
			}
			
			/*if(currentPlace.equals(positionInput.toUpperCase())){
				System.out.println("Pacman is already in that position");
			}*/
			if(checkPlaceInputFormat(positionInput)) {
				System.out.println("Pacman is placed on the grid");
				break;
				//return "placed";
			} else {
				//System.out.println("Pacman");
			}						
		}
		
	}
	
	/**
     *  checkPlaceInputFormat method is used to check whether given "Place PacMan" input is in following
     *  format ---- x,y,face and is within the grid.
     * 
     * @return Boolean    
     */
	public boolean checkPlaceInputFormat(String position) {
		String[] inputs;
		inputs = position.split(",");
		
		//check x,y,face inputs 
		if(inputs.length > 2 && inputs.length < 4) {
			try
            {
				xValue = Integer.parseInt(inputs[0]);
				yValue = Integer.parseInt(inputs[1]);
				fValue = inputs[2].toUpperCase();
				
				//check whether it is within the grid
				if(checkPlacedPosition(xValue,yValue,fValue).equals("valid")) {
					return true;
				} 		
            }
            catch(Exception e)
			{
            }				
		} else {
			return false;
		}
		return false;
	}
	
	/**
     * getString() method is used to get string input
     * 
     * @param prompt String - the String contains prompt
     * @returns string in.nextLine()     
     */
    public String getString(String prompt)
    {
    	in = new Scanner(System.in);
        System.out.print(prompt + " ");
        return in.nextLine();
    }
    
    /**
     * getInteger() method is used to get integer input
     * 
     * @param prompt String - the String contains prompt
     * @returns i     
     */
     public Integer getInteger(String prompt)
    {
    	in = new Scanner(System.in);
        Integer i = 0;
        while(true)
        {
            try
            {
                System.out.print(prompt + " ");
                i = Integer.parseInt(in.nextLine());
                break;
            }
            catch(Exception e)
            {
                System.out.println("Not a valid Integer");
            }
        }
        return i;  
    }
	
     /**
      *  checkPlacedPosition method is used to check whether given x,y,f values are within the grid.
      * 
      * @return String     
      */
 	public String checkPlacedPosition(int xValue,int yValue, String fValue){
 		if(check_XPosition(xValue) && check_YPosition(yValue) && checkDirection(fValue)) {
 		return "valid";
 		} else if(!check_XPosition(xValue) && !check_YPosition(yValue)) {
 			System.out.println("The given x and y position should be between '0 - 5'");
 			return "invalid";
 		} else if(!check_XPosition(xValue)) {
 			System.out.println("The given x position should be between '0 - 5'");
 			return "invalid";
 		} else if(!check_YPosition(yValue)){
 			System.out.println("The given y position should be between '0 - 5'");
 			return "invalid";
 		} else if(!checkDirection(fValue)) {
 			System.out.println("The given PacMan facing position should be NORTH or SOUTH or EAST or WEST without spaces and other symbols");
 			return "invalid";
 		}
 		return "invalid";
 	}
 	
	/**
     *  check_XPosition method is used to check whether given x position is with in the boundary line.
     * 
     * @return true or false     
     */
	public boolean check_XPosition(int x){
		if(x >=0 & x <=5)
		return true;
		else 
		return false;
	}
	
	/**
     *  check_YPosition method is used to check whether given y position is with in the boundary line.
     * 
     * @return true or false     
     */
	public boolean check_YPosition(int y){
		if(y >=0 & y <=5)
		return true;
		else 
		return false;
	}
	
	/**
     *  checkDirection method is used to check whether face value is NORTH, SOUTH,EAST or WEST
     * 
     * @return true or false     
     */
	public boolean checkDirection(String face){
		if(face.equals("NORTH") || face.equals("SOUTH") || face.equals("EAST") || face.equals("WEST"))
		return true;
		else 
		return false;
	}
	
	/**
     * This method is invoked when user enters "2" option
     * move() is used to move the PacMan one step forward in the direction it is facing.
     * 
     */
	public String move(){
		if(xValue!=null && yValue!= null && fValue!=null) {
			if(fValue.equals("NORTH") && yValue < 5 && yValue >= 0){
				yValue = yValue+1;
			} else if(fValue.equals("SOUTH") && yValue <= 5 && yValue > 0){
				yValue = yValue-1;
			} else if(fValue.equals("EAST") && xValue < 5 && xValue >= 0){
				//System.out.println("x:"+xValue+" y:"+yValue+" face:"+fValue);
				xValue = xValue+1;
			} else if(fValue.equals("WEST") && xValue <= 5 && xValue > 0){
				//System.out.println("x:"+xValue+" y:"+yValue+" face:"+fValue);
				xValue = xValue-1;
			} else {
				System.out.println("PacMan is going to fall please select some other command");
				return "PacMan is going to fall please select some other command";
			}
			System.out.println("PacMan is at x:"+xValue+" y:"+yValue+" face:"+fValue);
			return "PacMan is at x:"+xValue+" y:"+yValue+" face:"+fValue;
		} else {
			System.out.println("PacMan must be placed to move");
			return "PacMan must be placed to move";
		}
		
	}
	
	/**
     * This method is invoked when user enters "3" option
     * turnLeft() is used to rotate PacMan 90 degrees in the specified direction without changing the position of PacMan.
     * 
     */
	public String turnLeft(){
		if(xValue!=null && yValue!= null && fValue!=null) {
			if(fValue.equals("NORTH")){
				fValue = "WEST";
			} else if(fValue.equals("WEST")){
				fValue = "SOUTH";
			} else if(fValue.equals("SOUTH")){
				fValue = "EAST";
			} else if(fValue.equals("EAST")){
				fValue = "NORTH";
			}
			System.out.println("PacMan is at x:"+xValue+" y:"+yValue+" face:"+fValue);
			return "PacMan is at x:"+xValue+" y:"+yValue+" face:"+fValue;
		} else {
			System.out.println("PacMan must be placed to turn left");
			return "PacMan must be placed to turn left";
		}
		
	}
	
	/**
     * This method is invoked when user enters "4" option
     * turnRight() is used to rotate PacMan 90 degrees in the specified direction without changing the position of PacMan.
     * 
     */
	public String turnRight(){
		if(xValue!=null && yValue!= null && fValue!=null) {
			if(fValue.equals("NORTH")){
				fValue = "EAST";
			} else if(fValue.equals("EAST")){
				fValue = "SOUTH";
			} else if(fValue.equals("SOUTH")){
				fValue = "WEST";
			} else if(fValue.equals("WEST")){
				fValue = "NORTH";
			}
			System.out.println("PacMan is at x:"+xValue+" y:"+yValue+" face:"+fValue);
			return "PacMan is at x:"+xValue+" y:"+yValue+" face:"+fValue;
		} else {
			System.out.println("PacMan must be placed to turn right");
			return "PacMan must be placed to turn right";
		}
		
	}
	
	/**
     * This method is invoked when user enters "5" option
     * report() is used to announce the X,Y and Face of PacMan
     * 
     */
	public String report(){
		if(xValue!=null && yValue!= null && fValue!=null) {
			System.out.println("OUTPUT - x:"+xValue+" y:"+yValue+" face:"+fValue);
			return "OUTPUT - x:"+xValue+" y:"+yValue+" face:"+fValue;
		} else {
			System.out.println("PacMan must be placed in order to report");
			return "PacMan must be placed to report";
		}
	}
	
	/**
     * run() method is used to call menu method where user is
     * asked to select an option.
     */
    public void run()
    {
        while(true)
            /**
             * switch case is used to check choice entered by user 
             * matches the particular behavior.
             * It calls menu method for user 
             * to select an option.
             */
            switch (menu()) 
            {
            		case 1:
            			place();
            			break;
                    case 2:
                        move();
                        break;
                    case 3:
                        turnLeft();
                        break;
                    case 4:
                        turnRight();
                        break;
                    case 5:
                        report();
                        break;                 
                    case 6:
                    	//close scanner
                    	in.close();
                        return;  
                    default:
                        System.out.println ( "Unrecognized option" );
                        break;
            }
    }
    
    /**
     * menu() method asks the user for his or her input.
     * @returns integer
     */
    private int menu()
    {  
    	System.out.println("-----------------------------------------------------------------");
    	System.out.println("|********************* PACMAN SIMULATOR ************************|");
    	System.out.println("|	1) Place PacMan						|");
        System.out.println("|	2) Move							|");
        System.out.println("|	3) Left							|");
        System.out.println("|	4) Right						|");
        System.out.println("|	5) Report						|");
        System.out.println("|	6) Exit							|");
        System.out.println("-----------------------------------------------------------------");
        return getInteger("Please Select Option: ");
    }
    		
}
