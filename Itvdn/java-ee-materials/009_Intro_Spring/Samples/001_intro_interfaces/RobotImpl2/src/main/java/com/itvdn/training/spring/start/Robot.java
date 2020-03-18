package com.itvdn.training.spring.start;

import com.itvdn.training.spring.interfaces.Leg;
import com.itvdn.training.spring.interfaces.Hand;
import com.itvdn.training.spring.interfaces.Head;

public class Robot {
	
	private Hand hand;
	private Leg leg;
	private Head head;
	
	public Robot(Hand hand, Leg leg, Head head) {
		super();
		this.hand = hand;
		this.leg = leg;
		this.head = head;
	}

	public void action(){
		head.calc();
		hand.catchSomething();
		leg.go();
	}

}
