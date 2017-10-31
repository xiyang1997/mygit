import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseMotionListener; 
public class LifeGame extends JFrame implements MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final World world;
	//JButton button = new JButton ("button");
	static JMenu location=new JMenu();
	public LifeGame(int rows,int columns)
	{
		world=new World(rows, columns);
		world.setBackground(Color.LIGHT_GRAY);
		new Thread(world).start();
		add(world);
	}
	public static void main(String[]args)
	{
		LifeGame frame=new LifeGame(40, 50);
		
		frame.addMouseMotionListener(frame);
		JMenuBar menu=new JMenuBar();
		frame.setJMenuBar(menu);
		
		
		JMenu options =new JMenu("选项");
		menu.add(options);
		JMenu changeSpeed=new JMenu("变速");
		menu.add(changeSpeed);
		JMenu other = new JMenu("其他");
		menu.add(other);
		
		JMenuItem arrow=options.add("箭头");
		arrow.addActionListener(frame.new ArrowActionListener());
		JMenuItem square=options.add("笑脸");
		square.addActionListener(frame.new SquareActionListener());
		
		JMenuItem stop=options.add("停止");
		stop.addActionListener(frame.new StopActionListener());
		JMenuItem pause=options.add("暂停");
		pause.addActionListener(frame.new PauseActionListener());
		
		JMenuItem slow=changeSpeed.add("慢");
		slow.addActionListener(frame.new SlowActionListener());
		JMenuItem fast=changeSpeed.add("快");
		fast.addActionListener(frame.new FastActionListener());
		JMenuItem hyper=changeSpeed.add("更快");
		hyper.addActionListener(frame.new HyperActionListener());
		
		JMenuItem help=other.add("帮助");
		help.addActionListener(frame.new HelpActionListener());
		
		JMenuItem about=other.add("关于");
		about.addActionListener(frame.new AboutActionListener());
		//about.addActionListener(frame.new AboutActionListener());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1007,859);
		//frame.setSize(1207,859);
		//JButton button = new JButton ("button");
		//frame.button.setBounds(108,100,100,100);
		//frame.add(frame.button,BorderLayout.EAST);
		frame.setTitle("Game of Life");
		frame.setVisible(true);
		frame.setResizable(false);
		}
	class ArrowActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			world.diy=false;
			world.setArrow();
			world.setBackground(Color.LIGHT_GRAY);
			world.diy=false;
			world.clean=false;
			world.setShape();
		}
	}
	class SquareActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.diy=false;
			world.setSquare();
			world.setBackground(Color.LIGHT_GRAY);
			world.diy=false;
			world.clean=false;
			world.setShape();
		}
	}
	class StopActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//world.time=0;
			world.setBackground(Color.LIGHT_GRAY);
			world.diy=false;
			world.clean=false;
			world.setStop();
		}
	}
	class PauseActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.setBackground(Color.LIGHT_GRAY);
			world.diy=false;
			world.clean=false;
			world.setPause();
		}
	}
	class SlowActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.changeSpeedSlow();
		}
	}
	class FastActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.changeSpeedFast();
		}
	}
	class HyperActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			world.changeSpeedHyper();
		}
	}
	class HelpActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			JOptionPane.showMessageDialog(null, "这是生命游戏!!!\n生命游戏是英国数学家约翰·何顿·康威在1970年发明的细胞自动机\n "+"1．如果一个细胞周围有3个细胞为生，则该细胞为生;\n"
												+"2． 如果一个细胞周围有2个细胞为生，则该细胞的生死状态保持不变;\n"
												+"3． 在其它情况下，该细胞为死。");
		}
	}
	class AboutActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			JOptionPane.showMessageDialog(null, "游戏作者：杨熙、刘著");
		}
	}
	
	
    @Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(world.diy){
		int x=e.getX();
		int y=e.getY();
		//button.setText("x:"+x+"y:"+y);
		World.pauseshape[(y-50)/20][x/20]=1;
		world.setDiy();
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(world.clean){
		int x=e.getX();
		int y=e.getY();
		//button.setText("x:"+x+"y:"+y);
		World.pauseshape[(y-50)/20][x/20]=0;
		world.setDiy();
		}
	} }

