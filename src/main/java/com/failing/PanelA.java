/******************************************************************************
 * Copyright (c) 2012-2018 semedy AG
 * All rights reserved.
 *
 * Created on: 2/15/18
 ******************************************************************************/
package com.failing;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class PanelA extends Panel {

	private boolean visible = false;
	private FeedbackPanel feedbackPanel;

	public PanelA(String id) {
		super(id);
		add(feedbackPanel = new FeedbackPanel("feedback") {

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(visible);
			}
		});

		feedbackPanel.setOutputMarkupPlaceholderTag(true);

		add(new AjaxLink<Void>("clickMe") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				visible = true;
				getPage().info("Bang! I will blow up in the air!");
				target.add(feedbackPanel);
			}
		}.setBody(Model.of("Click me!")));
	}
}
