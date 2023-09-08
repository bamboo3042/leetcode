class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var temp = 0
        
        for(i in flowerbed.indices) {
            if((i-1 < 0 || flowerbed[i-1] == 0) && flowerbed[i] == 0 && (i+1 == flowerbed.size || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1
                temp++
            }
        }
        
        return temp >= n
    }
}