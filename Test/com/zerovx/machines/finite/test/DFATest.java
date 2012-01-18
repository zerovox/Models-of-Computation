package com.zerovx.machines.finite.test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.zerovx.machines.finite.DFAState;
import com.zerovx.machines.finite.FiniteMachine;


public class DFATest {
	private static FiniteMachine m;

	@BeforeClass
	public static void setUp(){
		DFAState s = new DFAState();
		DFAState a = new DFAState();
		DFAState b = new DFAState();
		DFAState c = new DFAState();
		DFAState d = new DFAState();
		DFAState f = new DFAState();
		s.addTransition('t', a);
		a.addTransition('i', b);
		b.addTransition('m', c);
		c.addTransition('m', d);
		c.addTransition('o', f);
		c.addTransition('i', b);
		d.addTransition('y', f);
		f.setAccepting(true);
		c.setAccepting(true);
		m = new FiniteMachine(s);
		
	}

	@Test
	public void test0() {
		assertTrue(m.accepts("timimim"));
	}
	@Test
	public void test1() {
		assertTrue(m.accepts("timimo"));
	}
	@Test
	public void test2() {
		assertTrue(m.accepts("timimimimmy"));
	}

}
