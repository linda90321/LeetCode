package pkg2;

public class King extends Piece {
	public String color;
    
	public King(String color) {
		super();
		this.color = color;
	}

	@Override
	public boolean isValid(Piece[][] board, int initX, int initY, int targetX,
			int targetY) {
		// TODO Auto-generated method stub
		if(Math.abs(targetX-initX) <=1 && Math.abs(targetY-initY) <= 1)
			return true;
		
		return false;
	}

}
