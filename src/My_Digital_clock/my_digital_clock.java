package My_Digital_clock;
import javax.swing.Timer;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Calendar;
import java.awt.Font;
import java.awt.Color;
public class my_digital_clock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel date_formate;
	private JLabel day_formate;
	private static  Calendar cal;
	private static int hour,minute,second,am_pm;
	private  static int dayOfWeek,year,month,day;
	private static String months[]= {
	"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY",
	"AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"
	};
	private static String days[]= {
		"SUNDAY","MONDAY","TUESDAY","WEDNESDAY",
		"THURSDAY","FRIDAY","SATURDAY"
	};
	private static String str;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					my_digital_clock frame = new my_digital_clock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public my_digital_clock() {
		setTitle("Digital Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 282);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel current_time=new JLabel();
		current_time.setForeground(Color.DARK_GRAY);
		current_time.setBackground(Color.WHITE);
		current_time.setFont(new Font("Stencil", Font.PLAIN, 40));
		current_time.setBounds(36, 64, 324, 60);
		contentPane.add(current_time);
		
		date_formate= new JLabel();
		date_formate.setFont(new Font("Wide Latin", Font.PLAIN, 15));
		date_formate.setForeground(Color.GREEN);
		date_formate.setBackground(Color.WHITE);
		date_formate.setBounds(36, 128, 348, 60);
		contentPane.add(date_formate);
		
		JLabel day_formate = new JLabel();
		day_formate.setForeground(Color.GREEN);
		day_formate.setFont(new Font("Stencil", Font.PLAIN, 20));
		day_formate.setBackground(Color.BLACK);
		day_formate.setBounds(36, 27, 324, 38);
		contentPane.add(day_formate);
		
		
		Timer timer = new Timer(1000, new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                cal = Calendar.getInstance();
	                // time
	                hour = cal.get(Calendar.HOUR);
	                minute = cal.get(Calendar.MINUTE);
	                second = cal.get(Calendar.SECOND);
	                am_pm = cal.get(Calendar.AM_PM);

	                // date
	                day = cal.get(Calendar.DAY_OF_MONTH);
	                dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	                month = cal.get(Calendar.MONTH);
	                year = cal.get(Calendar.YEAR);

	                if (am_pm == 0) {
	                    str = "AM";
	                } else {
	                    str = "PM";
	                }
	                current_time.setText(hour + ":" + minute + ":" + second + "" + str);

	                date_formate.setText(  day + " " + months[month] + " " + year);
	                
	                day_formate.setText(days[dayOfWeek - 1]);
	            }
	        });
	        timer.start();
	}
}
