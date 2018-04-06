package view.panes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import constantes.Statics;
import control.KeyControl;
import model.entity.BasicEntity;
import model.entity.Joueur;
import view.PrincipalFrame;

public class StartPane extends JPanel implements Observer{

	public ArrayList<BasicEntity> allEntities;
	public Joueur player;
	public Image bgImg;
	
	public StartPane(Joueur j) {
		super();
		this.setPreferredSize((Dimension)Statics.APPDIM.getObject());
		this.allEntities = new ArrayList<BasicEntity>();
		this.player = j;
		try {
			this.bgImg = ImageIO.read(new File("C:/Users/quent/eclipse-workspace/Rpg/src/Test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ((Dimension)Statics.APPDIM.getObject()).width, ((Dimension)Statics.APPDIM.getObject()).height);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(this.bgImg, this.player.posX, this.player.posY, this);
		this.player.paintComponent(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Joueur) {
			this.player = (Joueur)o;
		}
		this.repaint();
	}
}
