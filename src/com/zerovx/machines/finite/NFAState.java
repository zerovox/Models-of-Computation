package com.zerovx.machines.finite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NFAState extends State {
	
	protected Map<Character, List<State>> transitions;
	
	public NFAState(){
		super();
		transitions = new HashMap<Character, List<State>>();		
	}

	@Override
	public void addTransition(Character x, State s) {
		if(transitions.containsKey(x)){
			transitions.get(x).add(s);
		} else {
			ArrayList<State> states = new ArrayList<State>();
			states.add(s);
			transitions.put(x, states);
		}
	}

	@Override
	public List<State> consumeCharacter(char x) {
		List<State> out = new ArrayList<State>();
		if(transitions.containsKey(x)){
			for(State s : transitions.get(x)){
				out.addAll(s.epsilon());
			}
		}		
		return out;
	}
	
	public List<State> epsilon(){
		//Assume no cycles of epsilon transitions, as these can always be compressed into single states
		//Could add caching to ensure this is the case.
		List<State> x = new ArrayList<State>();
		x.add(this);
		if(transitions.containsKey('*')){
			for(State s : transitions.get('*')){
				x.addAll(s.epsilon());
			}
		}
		return x;	
	}
}
