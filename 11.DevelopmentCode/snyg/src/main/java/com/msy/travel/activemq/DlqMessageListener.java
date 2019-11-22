package com.msy.travel.activemq;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class DlqMessageListener implements MessageListener {

	public void onMessage(Message message) {
		TextMessage textMsg = (TextMessage) message;
		try {

			System.out.println("==========收到死信消息=========：" + textMsg.getText());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
