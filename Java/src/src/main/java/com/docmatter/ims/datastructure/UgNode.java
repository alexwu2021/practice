//package com.docmatter.ims.datastructure;
//
//import java.util.*;
//
//public class UgNode {
//    public Long Id;
//    public boolean isUser;
//    public boolean visited;
//    public boolean isBelongToProduct;
//    public Set<UgNode> children;
//
//    public UgNode(Long id){
//        this.Id = id;
//        this.isUser = false;
//        this.visited = false;
//        this.isBelongToProduct = false;
//        this.children = new HashSet<>();
//    }
//
//    public UgNode(Long id, boolean isUser){
//        this.Id = id;
//        this.isUser = true;
//        this.visited = false;
//        this.isBelongToProduct = false;
//        this.children = new HashSet<>();
//    }
//
//
//    public UgNode(Long id, ArrayList<UgNode>children){
//        this.Id = id;
//        this.isUser = false;
//        this.visited = false;
//        this.isBelongToProduct = false;
//        this.children = new HashSet<>();
//        this.children.addAll(children);
//    }
//
//    @Override
//    public String toString() {
//        return "userSeq=" + Id +
//                ", childrenSize=" + children.size() ;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UgNode ugNode = (UgNode) o;
//        return Objects.equals(Id, ugNode.Id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(Id, children);
//    }
//
//    public String toChildNodeString() {
//        return "(ugSeq=" + Id + ")";
//    }
//}
