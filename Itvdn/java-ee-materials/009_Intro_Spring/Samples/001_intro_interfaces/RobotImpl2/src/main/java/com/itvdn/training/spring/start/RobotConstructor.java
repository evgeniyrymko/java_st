package com.itvdn.training.spring.start;

import com.itvdn.training.spring.impls.toshiba.ToshibaLeg;
import com.itvdn.training.spring.impls.sony.SonyHand;
import com.itvdn.training.spring.impls.sony.SonyHead;


public class RobotConstructor {
	
	public static void main(String[] args){
		
		SonyHand sonyHand = new SonyHand();		
		ToshibaLeg toshibaLeg = new ToshibaLeg();
		SonyHead sonyHead = new SonyHead();
		
		Robot robot = new Robot(sonyHand, toshibaLeg, sonyHead);
		
		robot.action();
		
		
	}

}
