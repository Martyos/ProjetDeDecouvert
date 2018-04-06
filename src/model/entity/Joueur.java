package model.entity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observer;

import constantes.Statics;

public class Joueur extends BasicEntity {
	
	public boolean top = false, left = false, right = false, bot = false;
	
	private Joueur(String name,int hp,int maxHp,int str,int mana,int maxMana,int stamina,int maxStamina,int power,int dex,int intel,int panic,int panic_resist,int defense, int speed, int jumpHeight) {
		super.setBasicEntity(name,hp,maxHp,str,mana,maxMana,stamina,maxStamina,power,dex,intel,panic,panic_resist,defense,speed,jumpHeight);
	}
	
	public static Joueur newPlayer(String name) {
		Joueur j = new Joueur(name,1,1000,1,20,20,20,20,1,1,1,0,1,1,10,30);
		j.setPosition(0, 0);
		return j;
	}
	public static Joueur loadPlayer(String name,int hp,int maxHp,int str,int mana,int maxMana,int stamina,int maxStamina,int power,int dex,int intel,int panic,int panic_resist,int defense, int speed, int jumpHeight) {
		Joueur j = new Joueur(name,hp,maxHp,str,mana,maxMana,stamina,maxStamina,power,dex,intel,panic,panic_resist,defense,speed,jumpHeight);
		j.setPosition(0, 0);
		return j;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval((int)((Dimension)Statics.APPDIM.getObject()).getWidth()/2, (int)((Dimension)Statics.APPDIM.getObject()).getHeight()/2+this.relativeY, (int)((Dimension)Statics.BASICDIM.getObject()).getWidth(), (int)((Dimension)Statics.BASICDIM.getObject()).getHeight());
		g.setColor(Color.RED);
		g.drawRect((int)((Dimension)Statics.APPDIM.getObject()).getWidth()/2, (int)((Dimension)Statics.APPDIM.getObject()).getHeight()/2+this.relativeY, (int)((Dimension)Statics.BASICDIM.getObject()).getWidth(), (int)((Dimension)Statics.BASICDIM.getObject()).getHeight());
		g.setColor(Color.MAGENTA);
		g.setFont(new Font("Helvetica", Font.PLAIN, 20));
		g.drawString(this.name, 10, 20);
		g.setColor(Color.RED);
		g.drawString("Life : " + ((int)(((double)this.hp/(double)this.maxHp)*100))+"%", 10, 50);
		g.setColor(Color.GREEN);
		g.drawString("Stamina : " + ((int)(((double)this.stamina/(double)this.maxStamina)*100))+"%", 10, 80);
		g.setColor(Color.BLUE);
		g.drawString("Mana : " + ((int)(((double)this.mana/(double)this.maxMana)*100))+"%", 10, 110);
	}

	@Override
	public void move(int dx, int dy) {
		this.posX+=dx;
		this.posY+=dy;
		this.setChanged();
		this.notifyObservers();
	}
	
	public void addPlayerObserver(Observer o) {
		this.addObserver(o);
	}
	
	@Override
	public void loop() {
		if (this.top && !this.bot) {
			if (this.left && !this.right) {
				this.move((int)((double)this.speed * Math.cos(45)),(int)((double)this.speed * Math.sin(45)));
			} else if (this.right && !this.left) {
				this.move(-(int)((double)this.speed * Math.cos(45)),(int)((double)this.speed * Math.sin(45)));
			} else {
				this.move(0,this.speed);
			}
		} else if (this.bot && !this.top) {
			if (this.left && !this.right) {
				this.move((int)((double)this.speed * Math.cos(45)),-(int)((double)this.speed * Math.sin(45)));
			} else if (this.right && !this.left) {
				this.move(-(int)((double)this.speed * Math.cos(45)),-(int)((double)this.speed * Math.sin(45)));
			} else {
				this.move(0,-this.speed);
			}
		} else if (this.left && !this.right) {
			this.move(this.speed,0);
		} else if (this.right && !this.left) {
			this.move(-this.speed,0);
		}

	}

	@Override
	public void jump() {
		
	}
}
