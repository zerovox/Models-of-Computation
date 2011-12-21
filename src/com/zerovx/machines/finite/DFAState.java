package com.zerovx.machines.finite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DFAState extends State{
	
	protected Map<Character, State> transitions;
	
	public DFAState(){
		super();
		transitions = new HashMap<Character, State>();
	}

	@Override
	public void addTransition(Character x, State s) {
		transitions.put(x, s);		
	}

	@Override
	public List<State> consumeCharacter(char x) {
		List<State> out = new ArrayList<State>();
		if(transitions.containsKey(x)){
			out.add(transitions.get((Character) x));
		}
			return out;
	}

	@Override
	public List<State> epsilon() {
		List<State> out = new ArrayList<State>();
		out.add(this);
		return out;
	}

}