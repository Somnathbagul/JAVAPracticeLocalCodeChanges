import java.util.*;
import java.util.concurrent.*;

public class TTLCache<K, V> {
    private final Map<K, Node<K, V>> map;
    private final Queue<Node<K, V>> queue;
    private final long defaultTTL;
    private final ReentrantReadWriteLock lock;
    private final Lock readLock;
    private final Lock writeLock;

    public TTLCache(long defaultTTL) {
        this.map = new ConcurrentHashMap<>();
        this.queue = new LinkedList<>();
        this.defaultTTL = defaultTTL;
        this.lock = new ReentrantReadWriteLock();
        this.readLock = lock.readLock();
        this.writeLock = lock.writeLock();
    }

    public void put(K key, V value, long ttl) {
        writeLock.lock();
        try {
            Node<K, V> node = new Node<>(key, value, System.currentTimeMillis() + ttl);
            map.put(key, node);
            queue.offer(node);
            evictExpired();
            evictLRU();
        } finally {
            writeLock.unlock();
        }
    }

    public V get(K key) {
        readLock.lock();
        try {
            Node<K, V> node = map.get(key);
            if (node != null && node.expirationTime >= System.currentTimeMillis()) {
                queue.remove(node);
                queue.offer(node);
                return node.value;
            } else {
                return null;
            }
        } finally {
            readLock.unlock();
        }
    }

    public void clear() {
        writeLock.lock();
        try {
            map.clear();
            queue.clear();
        } finally {
            writeLock.unlock();
        }
    }

    private void evictExpired() {
        long currentTime = System.currentTimeMillis();
        Iterator<Node<K, V>> iterator = queue.iterator();
        while (iterator.hasNext()) {
            Node<K, V> node = iterator.next();
            if (node.expirationTime < currentTime) {
                iterator.remove();
                map.remove(node.key);
            } else {
                break;
            }
        }
    }

    private void evictLRU() {
        while (map.size() > 10) {
            Node<K, V> node = queue.poll();
            if (node != null) {
                map.remove(node.key);
            }
        }
    }

    private static class Node<K, V> {
        private final K key;
        private final V value;
        private final long expirationTime;

        public Node(K key, V value, long expirationTime) {
            this.key = key;
            this.value = value;
            this.expirationTime = expirationTime;
        }
    }
}
