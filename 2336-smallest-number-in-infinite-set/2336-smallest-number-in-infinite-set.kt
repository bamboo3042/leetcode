class SmallestInfiniteSet() {

    val queue: PriorityQueue<Int> = PriorityQueue()

    init { for (i in 1 .. 1000) queue.add(i) }

    fun popSmallest(): Int {
        return queue.poll()
    }

    fun addBack(num: Int) {
        if (num !in queue) queue.add(num)
    }

}