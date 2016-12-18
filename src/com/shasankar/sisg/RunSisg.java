package com.shasankar.sisg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RunSisg {
	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String[] gridSize = br.readLine().split(" ");
			int width = Integer.parseInt(gridSize[0]);
			int height = Integer.parseInt(gridSize[1]);
			MountnPoint[][] grid = new MountnPoint[width][height];
			for(int i=0; i<height; i++){
				String[] elevations = br.readLine().split(" ");
				for(int j=0; j<width; j++){
					grid[i][j] = new MountnPoint(Integer.parseInt(elevations[j]));
				}
			}
			for(int i=0; i<height; i++){
				for(int j=0; j<width; j++){
					//North
					if(i>0 && grid[i-1][j].getElevation()<grid[i][j].getElevation())
						grid[i][j].addNeighbours(grid[i-1][j]);
					//South
					if(i<height-1 && grid[i+1][j].getElevation()<grid[i][j].getElevation())
						grid[i][j].addNeighbours(grid[i+1][j]);
					//East
					if(j<width-1 && grid[i][j+1].getElevation()<grid[i][j].getElevation())
						grid[i][j].addNeighbours(grid[i][j+1]);
					//West
					if(j>0 && grid[i][j-1].getElevation()<grid[i][j].getElevation())
						grid[i][j].addNeighbours(grid[i][j-1]);
				}
			}
			ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<height; i++){
				for(int j=0; j<width; j++){
					 grid[i][j].traverse(paths,new ArrayList<Integer>());
				}
			}
			int maxLength = 0;
			ArrayList<Integer> greatestPath = new ArrayList<Integer>();
			for(ArrayList<Integer> path: paths){
				if (path.size()>maxLength){
					greatestPath = path;
					maxLength = path.size();
				}else if(path.size()==maxLength){
					int pathDescent = path.get(0) - path.get(path.size()-1);
					int greatestPathDescent = greatestPath.get(0) - greatestPath.get(greatestPath.size()-1);
					if (pathDescent > greatestPathDescent)
						greatestPath = path;
				}
			}
			System.out.println(greatestPath);
		}catch(IOException e){
			System.out.println("IOException while reading input file");
			e.printStackTrace();
		}
	}
}