package pkg2;

public class Queen extends Piece{

	@Override
	public boolean isValid(Piece[][] board, int initX, int initY, int targetX,
			int targetY) {
		// TODO Auto-generated method stub

		if(initX == targetX){
			for(int i=Math.min(initY,targetY);i<=Math.max(initY,targetY);i++){
				if(board[targetX][i] != board[initX][initY] && board[targetX][i] != board[targetX][targetY] &&  board[targetX][i] != null )
					return false;
			}
		}else if(initY == targetY){
			for(int i=Math.min(initX,targetX);i<=Math.max(initX,targetX);i++){
				if(board[i][targetY] != board[initX][initY] && board[i][targetY] != board[targetX][targetY] && board[i][targetY] != null )
					return false;
			}
		}else if(Math.abs(targetX-initX)==Math.abs(targetY-initY)){
			int tempX=targetX-initX>0?1:-1;
			int tempY=targetY-initY>0?1:-1;
			while(Math.abs(targetX-initX) > 1 || Math.abs(targetY-initY) > 1){
				initX += tempX;
				initY += tempY;
				
				if(board[initX][initY] != null)
					return false;
			}
			
		}
			
		
		
		return true;
	}

}
