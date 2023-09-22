class Solution {
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        var left = 0
        var right = costs.size-1
        var queue = PriorityQueue<Array<Int>> (compareBy({ it[0] }, { it[1] }))
        var result = 0L
        
        repeat(candidates) {
            if(left < costs.size && left <= right) queue.add(arrayOf(costs[left], left++))
            if(right > 0 && right >= left) queue.add(arrayOf(costs[right], right--))
        }
        
        repeat(k) {
            val (c, p) = queue.poll()
            result += c
            
            if(p < left && left < costs.size && left <= right) queue.add(arrayOf(costs[left], left++))
            else if(p > right && right > 0 && right >= left) queue.add(arrayOf(costs[right], right--))
        }
        
        return result
    }
}