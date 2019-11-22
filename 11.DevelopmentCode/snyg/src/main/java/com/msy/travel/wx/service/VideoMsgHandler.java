package com.msy.travel.wx.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msy.travel.wx.resp.BaseMessage;

@Service
@Transactional
public class VideoMsgHandler extends AbstractMsgHandler {

	private static final Log log = LogFactory.getLog(VideoMsgHandler.class);

	@Override
	protected String handle(Map<String, String> requestMap, BaseMessage msg, HttpServletRequest request) {
		return null;
	}

}
