package com.shasankar.sisg;

import java.util.ArrayList;

public class MountnPoint {
	private int elevation;
	private ArrayList<MountnPoint> neighbours;
	public MountnPoint(int elevation){
		this.elevation = elevation;
		neighbours = new ArrayList<MountnPoint>();
	}
	public int getElevation() {
		return elevation;
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
