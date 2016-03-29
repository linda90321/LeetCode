package pkg2;

public class Knight extends Piece {

	@Override
	public boolean isValid(Piece[][] board, int initX, int initY, int targetX,
			int targetY) {
		// TODO Auto-generated method stub
		if((Math.abs(targetX-initX) == 2 && Math.abs(targetY-initY) == 1) || (Math.abs(targetX-initX) == 1 && Math.abs(targetY-initY) == 2)){
			if(board[targetX][targetY] == null)
				return true;
		}
		
		return false;
	}


}
