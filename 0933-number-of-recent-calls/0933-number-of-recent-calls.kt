class RecentCounter() {
    val queue: ArrayDeque<Int> = ArrayDeque()

    fun ping(t: Int): Int {
        queue.addLast(t)
        while (queue.isNotEmpty() && queue.first() < t - 3000) {
            queue.removeFirst()
        }
        return queue.size
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */