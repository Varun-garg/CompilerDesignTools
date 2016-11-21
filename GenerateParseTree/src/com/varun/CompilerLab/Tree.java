package com.varun.CompilerLab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varun on 06/10/2016.
 */

public class Tree<String>{
    private Node<String> root;

    public Tree(String rootData)
    {
        root = new Node<String>();
        root.data = rootData;
        root.children = new ArrayList<Node<String>>();
    }

    public static class Node<String>
    {
        private String data;
        private Node<String> parent;
        private List<Node<String>> children;
    }

    public Node<String> getTop()
    {
        return root;
    }
}