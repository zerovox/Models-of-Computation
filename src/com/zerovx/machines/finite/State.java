package com.zerovx.machines.finite;
import java.util.List;

public abstract class State {
		protected boolean accepting;
		
		public State(){
			accepting = false;
		}
		
		public void setAccepting(boolean x){
			accepting = x;
		}
		
		public boolean isAccepting(){
			return accepting;
		}
		
		public abstract void addTransition(Character x, State s);
		
		public abstract List<State> consumeCharacter(char x);
		
		public abstract List<State> epsilon();

}