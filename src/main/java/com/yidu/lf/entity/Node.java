package com.yidu.lf.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: Tree节点类
 * @author: LvFang
 * date:2021/1/5 15:39
 * version:1.0
 */
public class Node {
    private String text;

    private String id;

    private List<NodeChild> nodes =new ArrayList<>();

    public Node() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<NodeChild> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeChild> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Node{" +
                "text='" + text + '\'' +
                ", id='" + id + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
