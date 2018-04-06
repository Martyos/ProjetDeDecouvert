package view;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;

import constantes.Statics;
import control.KeyControl;
import control.MouseControl;
import model.entity.Joueur;
import view.panes.StartPane;

public class PrincipalFrame extends JFrame {
	
	private Joueur player;
	
	public PrincipalFrame(){
		super(Statics.APPNAME.toString());
		this.player = Joueur.newPlayer("Joueur");
		StartPane pane = new StartPane(this.player);
		this.player.addPlayerObserver(pane);
		this.setContentPane(pane);
		this.pack();
		this.setVisible(true);
		((GraphicsDevice)Statics.DEVICE.getObject()).setFullScreenWindow(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addKeyListener(new KeyControl(this.player));
		this.addMouseListener(new MouseControl(this.player));
		this.looper();
	}
	
	public void looper() {
		while (true) {
			this.player.loop();
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}
	
}
