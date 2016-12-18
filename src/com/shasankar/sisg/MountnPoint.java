package com.shasankar.sisg;

import java.util.ArrayList;

public class MountnPoint {
	private int elevation;
	private int xCord;
	private int yCord;
	private ArrayList<MountnPoint> neighbours;
	public MountnPoint(int elevation, int xCord, int yCord){
		this.elevation = elevation;
		this.xCord = xCord;
		this.yCord = yCord;
		neighbours = new ArrayList<MountnPoint>();
	}
	public int getElevation() {
		return elevation;
	}
	public int getxCord() {
		return xCord;
	}
	public int getyCord() {
		return yCord;
	}
	public ArrayList<MountnPoint> getNeighbours() {
		return neighbours;
	}
	public void addNeighbours(MountnPoint neighbour) {
		this.neighbours.add(neighbour);
	}
	public void traverse(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path){
		path.add(elevation);
		if(neighbours.isEmpty()){
			paths.add(path);
		}
		for(MountnPoint neighbour: neighbours){
			neighbour.traverse(paths,new ArrayList<Integer>(path));			
		}
	}
}
