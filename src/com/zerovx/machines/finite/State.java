package com.zerovx.machines.finite;
import java.util.List;

public abstract class State {
		private boolean accepting;
		
		State(){
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
		
		protected abstract List<State> epsilon();

}