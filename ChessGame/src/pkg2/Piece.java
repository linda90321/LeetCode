package pkg2;

public abstract class Piece {
public String color;

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public abstract boolean isValid(Piece[][] board, int initX, int initY, int targetX, int targetY);

}
