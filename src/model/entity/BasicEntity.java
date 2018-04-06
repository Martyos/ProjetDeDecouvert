package model.entity;

import java.awt.Graphics;
import java.util.Observable;

public abstract class BasicEntity extends Observable{
	public String name;
	public int hp;
	public int maxHp;
	public int str;
	public int mana;
	public int maxMana;
	public int stamina;
	public int maxStamina;
	public int power;
	public int dex;
	public int intel;
	public int panic;
	public int panic_resist;
	public int defense;
	public int posX,posY;
	public int speed;
	public int jumpHeight; 
	public int relativeX;
	public int relativeY;
	
	protected void setBasicEntity(String name,int hp,int maxHp,int str,int mana,int maxMana,int stamina,int maxStamina,int power,int dex,int intel,int panic,int panic_resist,int defense,int speed, int jumpHeight) {
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.str = str;
		this.mana = mana;
		this.maxMana = maxMana;
		this.stamina = stamina;
		this.maxStamina = maxStamina;
		this.power = power;
		this.dex = dex;
		this.intel = intel;
		this.panic = panic;
		this.panic_resist = panic_resist;
		this.defense = defense;
		this.posX = 0;
		this.posY = 0;
		this.speed = speed;
		this.jumpHeight = jumpHeight;
		this.relativeX = 0;
		this.relativeY = 0;
	}
	
	public void setPosition(int x, int y) {
		this.posX = x;
		this.posY = y;
		this.setChanged();
		this.notifyObservers();
	}
	
	public abstract void paintComponent(Graphics g);
	
	public abstract void move(int dx,int dy);
	
	public abstract void loop();
	
	public abstract void jump();
}
