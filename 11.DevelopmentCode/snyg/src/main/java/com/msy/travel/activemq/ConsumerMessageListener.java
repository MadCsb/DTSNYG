package com.msy.travel.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;

public class ConsumerMessageListener implements SessionAwareMessageListener<Message> {

	private Log log = LogFactory.getLog(ConsumerMessageListener.class);

	@Override
	public void onMessage(Message message, Session session) throws JMSException {
		TextMessage textMsg = (TextMessage) message;
		try {
			System.out.println("1111111111接收者受到消息：" + textMsg.getText());
			int a = 0;
			int b = 0;
			a = a / b;
			textMsg.acknowledge();

		} catch (Exception e) {
			session.recover();
			log.error(e, e);
		}

	}

	// @Override
	// public void onMessage(Message message) {
	// TextMessage textMsg = (TextMessage) message;
	// try {
	// System.out.println("1111111111接收者受到消息：" + textMsg.getText());
	// int a = 0;
	// int b = 0;
	// a = a / b;
	// textMsg.acknowledge();
	//
	// } catch (Exception e) {
	//
	// throw new LogicException("error..........");
	// }
	//
	// }
}
