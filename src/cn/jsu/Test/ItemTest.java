package cn.jsu.Test;

import java.awt.EventQueue;

import cn.jsu.View.LoginInterface;

/**
  * ”√ªß≤‚ ‘¿‡
 * @author Black
 *
 */

public class ItemTest {

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginInterface();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}