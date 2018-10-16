package com.hanxiaocu.Algorithm;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Description:
 * * 通过HashMap 来查找节点
 * * 通过双向列表来进行删除插入操作
 * * 没有考虑到加锁的情况-----
 * User: hanchenghai
 * Date: 2018/10/16 10:16 AM
 */

public class LRUCache<K, V> implements Iterable<K> {

    private Node head;//头指针
    private Node tail;//尾部指针

    private HashMap<K, Node> map;
    private int              maxSize;//缓存最多存储量，map的大小小于这个尺寸，防止map自动扩容

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);

        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.pre = head;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }

        Node node = map.get(key);
        unlink(node);
        appendHead(node);
        return node.v;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        appendHead(node);

        if (map.size() > maxSize) { //超过map容量，那么就移除尾部节点
            Node removeNode = removeTail();
            map.remove(removeNode.k);
        }
    }

    /**
     * 移除关联的节点
     *
     * @param node
     */
    private void unlink(Node node) {
        Node next = node.next;
        Node pre  = node.pre;
        pre.next = next;
        next.pre = pre;
    }

    /**
     * 移除尾部节点
     * @return
     */
    private Node removeTail() {
        Node node = tail.pre;
        tail.pre = node.pre;
        node.pre.next = tail;
        return node;
    }

    /**
     * 对于经常访问的节点，提到链表首部
     */
    private void appendHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.pre = node;
        node.pre = head;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private class Node {
        Node next;
        Node pre;
        K    k;
        V    v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
}

