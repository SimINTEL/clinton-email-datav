package com.aprj.models;

import java.util.List;
import java.util.Set;

/**
 * Created by southdom on 2017/4/22.
 */
public class EmailRelationshipModel {

    private Set<Node> nodes;
    private List<Link> links;

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public EmailRelationshipModel(Set<Node> nodes, List<Link> links) {
        this.nodes = nodes;
        this.links = links;
    }
}
