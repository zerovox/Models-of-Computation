package com.zerovx.machines.finite;
import java.util.ArrayList;
import java.util.List;

public class FiniteMachine {
	State start;
	List<State> current;
	
	public FiniteMachine(State s){
		start = s;
		current = new ArrayList<State>();
	}
	
	public boolean accepts(String s){
		current.clear();
		current.add(start);
		for(int i = 0; i<s.length(); i++){
			List<State> next = new ArrayList<State>();
			for(State state : current){
				next.addAll(state.consumeCharacter(s.charAt(i)));
			}
			current = next;
		}
		for(State state : current){
			if(state.isAccepting()){
				return true;
			}
		}
		return false;
	}

}