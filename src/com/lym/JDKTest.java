package com.lym;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liyiming
 * @version 1.0
 * @description
 * @date 2020/7/29 10:31 下午
 */
public class JDKTest {
    public static void main(String[] args) {

        //创建输入对象
        Scanner sc = new Scanner(System.in);

        //获取用户输入的字符串
        int i = 0;
        String str = null;
        System.out.print("请输入任意字符:");
        i = sc.nextInt();

        System.out.println("你输入的字符为:" + str);
        System.out.print("请输入任意字符:");
        str = sc.nextLine();

        System.out.println("你输入的字符为:" + str);

    }
}

class LRUCache {
    HashMap<Integer, MyNode> cache;
    int capacity;
    int size;
    MyNode head, tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        head = new MyNode();
        tail = new MyNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        MyNode node = cache.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        MyNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new MyNode(key, value);
            cache.put(key, node);
            addToHead(node);
            if (++size > capacity) {
                node = tail.prev;
                removeTail();
                cache.remove(node.key);
                size--;
            }
        }

    }

    private void moveToHead(MyNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(MyNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(MyNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeTail() {
        MyNode node = tail.prev;
        removeNode(node);

    }


}

class MyNode {
    int key;
    int value;
    MyNode prev, next;

    MyNode() {
    }

    ;

    MyNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    ;
}