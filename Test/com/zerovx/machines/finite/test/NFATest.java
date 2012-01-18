package com.zerovx.machines.finite.test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.zerovx.machines.finite.FiniteMachine;
import com.zerovx.machines.finite.NFAState;


public class NFATest {

	private static FiniteMachine m;

	@BeforeClass
	public static void setUp(){
		NFAState s = new NFAState();
		NFAState a = new NFAState();
		NFAState b = new NFAState();
		NFAState c = new NFAState();
		NFAState d = new NFAState();
		NFAState e = new NFAState();
		NFAState f = new NFAState();
		s.addTransition('t', a);
		a.addTransition('i', c);
		c.addTransition('m', d);
		d.addTransition('i', c);
		d.setAccepting(true);
		s.addTransition('t', b);
		b.addTransition('o', e);
		e.addTransition('m', f);
		f.addTransition('*', b);
		f.setAccepting(true);		
		m = new FiniteMachine(s);
		
	}

	@Test
	public void test0() {
		assertTrue(m.accepts("timim"));
	}
	@Test
	public void test1() {
		assertTrue(m.accepts("tomomom"));
	}
	@Test
	public void test2() {
		assertFalse(m.accepts("tomim"));
	}

}
