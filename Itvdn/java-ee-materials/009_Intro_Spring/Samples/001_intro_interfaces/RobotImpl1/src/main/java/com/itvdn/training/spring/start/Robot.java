package com.itvdn.training.spring.start;

import com.itvdn.training.spring.objects.SonyHead;
import com.itvdn.training.spring.objects.SonyHand;
import com.itvdn.training.spring.objects.SonyLeg;

public class Robot {
	
	private SonyHand hand = new SonyHand();
	private SonyLeg leg = new SonyLeg();
	private SonyHead head = new SonyHead();
	
	public void action() {
		head.calc();
		hand.catchSomething();
		leg.go();
	}

}
