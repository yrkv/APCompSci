// Colleague #1
//
// This is the code for the Piece class.
// In the Tic-Tac-Toe game, a Piece will be either
// an X or an O.

public class Piece
{
	private String id;

	public Piece()
	{
		id = " ";
	}

	public Piece(String x)
	{
		id = x;
	}

	public String getID()
	{
		return id;
	}

	public boolean equals(Piece p)
	{
		if (this.getID().equals(p.getID()))
			return true;
		else
			return false;
	}
}