package com.vathanakmao.testproj.springtest.web.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Item;
import com.vathanakmao.testproj.springtest.model.Employee;

public class RssFeedView extends AbstractRssFeedView {

    @Override
    protected void buildFeedMetadata(Map<String, Object> model, com.sun.syndication.feed.rss.Channel feed,
            HttpServletRequest request) {

        feed.setTitle("Vathanak's Employees");
        feed.setDescription("Vathanak's employee Information");
        feed.setLink("http://vathanakmao.com/employees");

        super.buildFeedMetadata(model, feed, request);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<Item> items = new ArrayList<Item>(1);

        List<Employee> employees = (ArrayList<Employee>) model.get("employees");
        for(Employee emp : employees) {
            Item item = new Item();
            // item.setAuthor("vathanakmao");
            // tem.setLink("http://www.vathanakmao.com");

            Content content = new Content();
            content.setValue("ID: " + emp.getId() + ", Name: " + emp.getName());

            item.setContent(content);

            items.add(item);
        }

        return items;
    }

}
