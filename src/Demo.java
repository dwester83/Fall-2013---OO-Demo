
import javax.media.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.File;
import java.awt.*;

@SuppressWarnings("serial")
public class Demo extends JFrame {// implements ControllerListener {

	static Player p;

	public static void main (String[] args) {
		try {
			JFrame f = new Demo();
			JPanel te = new JPanel(new BorderLayout());
			te.add(p.getVisualComponent(), BorderLayout.CENTER);
			te.add(p.getControlPanelComponent(), BorderLayout.SOUTH);
			f.add(te);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.pack();
			f.setVisible (true);
			p.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Demo() 
			throws java.io.IOException,
			java.net.MalformedURLException,
			javax.media.MediaException {
		FileDialog fd = new FileDialog
				(this, "JMFPlayer", FileDialog.LOAD);
		fd.setVisible(true);
		File f = new File(fd.getDirectory(), fd.getFile());
		p = Manager.createRealizedPlayer
				(f.toURI().toURL());
	}
}
