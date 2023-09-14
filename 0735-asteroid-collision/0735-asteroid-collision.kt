class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val list = mutableListOf<Int>()
        asteroids.forEach {
            if (list.isEmpty()) list.add(it)
            else if (it.sign != list.last().sign) {
                var remove = false
                while (list.isNotEmpty() && it.sign == -1 && list.last().sign == 1) {
                    if (it.absoluteValue > list.last().absoluteValue) list.removeLast()
                    else if (it.absoluteValue == list.last().absoluteValue) {
                        list.removeLast()
                        remove = true
                        break
                    }
                    else {
                        remove = true
                        break
                    }
                }
                if (!remove) list.add(it)
            }
            else list.add(it)
        }
        return list.toIntArray()
    }
}