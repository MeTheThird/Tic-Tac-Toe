package TicTacToe;

import apcs.*;

public class MainGame {

	static int[][] grid;
	
	static final int SYMBOL_X = 1;
	static final int SYMBOL_C = 0;
	
	static int player;

	
	public static void main(String[] args) {
		Window.size(600, 600);
		setup();
		
		while (true)
		{
			Window.out.background("black");
			drawBackground();
			move();
			Window.frame();
		}
	}
	
	public static void setup()
	{
		Window.out.font("Lobster", 200);
		player = 1;
		grid = new int[3][3];
	}
	
	public static void drawBackground()
	{
		Window.out.color("white");
		Window.out.fontSize(200);
		
		Window.out.rectangle(200, Window.height()/2, 20, 550);
		Window.out.rectangle(400, Window.height()/2, 20, 550);
		
		Window.out.rectangle(Window.height()/2, 200, 550, 20);
		Window.out.rectangle(Window.height()/2, 400, 550, 20);
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (grid[i][j] == 1)
				{
					Window.out.print("X", i * 200, j * 200 + 200);
				}
				else if (grid[i][j] == 2)
				{
					Window.out.print("O", i * 200, j * 200 + 200);

				}
			}
		}
		
		if (player1Win())
		{
			Window.out.fontSize(50);
			Window.out.color("orange");
			Window.out.print("Player 1 Wins, but,", 200, 300);
			Window.out.print("unfortunately, Charizard", 0, 350);
			Window.out.print("comes and uses flamethrower", 0, 400);
			Window.out.print("on both players!", 0, 450);
			Window.out.print("TEEHEE", 200, 500);

		}
		
		if (player2Win())
		{
			Window.out.fontSize(50);
			Window.out.color("orange");
			Window.out.print("Player 2 Wins, but,", 200, 300);
			Window.out.print("unfortunately, Kyoger", 0, 350);
			Window.out.print("comes and uses surf", 0, 400);
			Window.out.print("on both players!", 0, 450);
			Window.out.print("TEEHEE", 200, 500);
		}

	}
	
	public static void move()
	{
		if (player == 1)
		{
			if (Window.mouse.clicked())
			{
				int x = Window.mouse.getX();
				int y = Window.mouse.getY();
				
//				if (x >= 0 && x<= 200 && y >= 0 && y <= 200)
//				{
//					
//				}
				
				yoself : for (int i = 0; i < 3; i++)
				{
					for (int j = 0; j < 3; j++)
					{
						if (x >= i * 200 && x <= (i+1) * 200 && y >= j * 200 && y <= (j+1) * 200)
						{
							if (grid[i][j] == 0)
							{
								grid[i][j] = player;
								player = 2;
								break yoself;
							}
							
						}
					}
				}
			}
		}
		else if (player == 2)
		{
			if (Window.mouse.clicked())
			{
				int x = Window.mouse.getX();
				int y = Window.mouse.getY();
				
//				if (x >= 0 && x<= 200 && y >= 0 && y <= 200)
//				{
//					
//				}
				
				potato : for (int i = 0; i < 3; i++)
				{
					for (int j = 0; j < 3; j++)
					{
						if (x >= i * 200 && x <= (i+1) * 200 && y >= j * 200 && y <= (j+1) * 200)
						{
							if (grid[i][j] == 0)
							{
								grid[i][j] = player;
								player = 1;
								break potato;
							}
							
						}
					}
				}
			}
		}
	}
	
	public static boolean player1Win()
	{
		int count = 0;
		for (int i = 0; i < 3; i++)
		{
			if (grid[i][0] == 1)
			{
				count++;
			}
		}
		
		if (count == 3)
		{
			return true;
		}
		
		count = 0;

		
		for (int i = 0; i < 3; i++)
		{
			if (grid[i][1] == 1)
			{
				count++;
			}
		}
		
		if (count == 3)
		{
			return true;
		}
		
		count = 0;

		
		for (int i = 0; i < 3; i++)
		{
			if (grid[i][2] == 1)
			{
				count++;
			}
		}
		
		if (count == 3)
		{
			return true;
		}
		
		count = 0;

		
		for (int i = 0; i < 3; i++)
		{
			if (grid[0][i] == 1)
			{
				count++;
			}
		}
		if (count == 3)
			return true;
		
		count = 0;

		
		for (int i = 0; i < 3; i++)
		{
			if (grid[1][i] == 1)
			{
				count++;
			}
		}
		if (count == 3)
			return true;
		
		count = 0;

		
		for (int i = 0; i < 3; i++)
		{
			if (grid[2][i] == 1)
			{
				count++;
			}
		}
		if (count == 3)
			return true;
		
		count = 0;
		
		if (grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 1)
			return true;
		
		if (grid[2][0] == 1 && grid[1][1] == 1 && grid[0][2] == 1)
			return true;
		
		return false;
	}
	
	public static boolean player2Win()
	{
		int count = 0;
		for (int i = 0; i < 3; i++)
		{
			if (grid[i][0] == 2)
			{
				count++;
			}
		}
		
		if (count == 3)
			return true;
		
		count = 0;
		
		for (int i = 0; i < 3; i++)
		{
			if (grid[i][1] == 2)
			{
				count++;
			}
		}
		
		if (count == 3)
		{
			return true;
		}
		
		count = 0;
		
		for (int i = 0; i < 3; i++)
		{
			if (grid[i][2] == 2)
			{
				count++;
			}
		}
		
		if (count == 3)
		{
			return true;
		}
		
		count = 0;

		
		for (int i = 0; i < 3; i++)
		{
			if (grid[0][i] == 2)
			{
				count++;
			}
		}
		
		if (count == 3)
			return true;
		
		count = 0;

		
		for (int i = 0; i < 3; i++)
		{
			if (grid[1][i] == 2)
			{
				count++;
			}
		}
		if (count == 3)
			return true;
		
		count = 0;
		
		for (int i = 0; i < 3; i++)
		{
			if (grid[2][i] == 2)
			{
				count++;
			}
		}
		if (count == 3)
			return true;
		
		count = 0;
		
		if (grid[0][0] == 2 && grid[1][1] == 2 && grid[2][2] == 2)
			return true;
		
		if (grid[2][0] == 2 && grid[1][1] == 2 && grid[0][2] == 2)
			return true;
		
		return false;
	}

}
