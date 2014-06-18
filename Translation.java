package misc.navigation;

public class Translation {
	public static final int facing_south = 0,
							facing_east = 1,
							facing_north = 2,
							facing_west = 3;

	public double	x,
					y;
	public int	orientation;
	
	public Translation(int orientation, double xCoordinate, double yCoordinate){
		this.orientation = orientation % 4;
		x = xCoordinate;
		y = yCoordinate;
	}
}
