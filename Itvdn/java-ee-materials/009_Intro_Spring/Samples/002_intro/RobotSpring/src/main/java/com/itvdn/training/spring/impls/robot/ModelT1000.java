package com.itvdn.training.spring.impls.robot;

import com.itvdn.training.spring.interfaces.Hand;
import com.itvdn.training.spring.interfaces.Head;
import com.itvdn.training.spring.interfaces.Leg;
import com.itvdn.training.spring.interfaces.Robot;

public class ModelT1000 implements Robot {

	private Hand hand;
	private Leg leg;
	private Head head;

	public ModelT1000() {
	}

	public ModelT1000(Hand hand, Leg leg, Head head) {
		super();
		this.hand = hand;
		this.leg = leg;
		this.head = head;
	}

	//@Override
	public void fire() {
		head.calc();
		hand.catchSomething();
		leg.go();
	}

	//@Override
	public void dance() {
		System.out.println("T1000 is dancing!");
	}

}
